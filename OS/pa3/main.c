#include <stdio.h>
#include <stdlib.h>

#define MAX_PROCESS 10
#define GET_PRIORITY(base, t, alpha) base + (alpha * t)

typedef struct _PCB {
    int pid;
    int priority;
    double current_priority;
    int arrival_time;
    int burst_time;
    int current_burst_time;

    int first_enter_time;
    int waiting_time;
} PCB;

typedef PCB Data;
typedef struct _Node {
    Data data;
    struct _Node *next;
} Node;
typedef struct _ReadyQueue {
    Node *front;
    Node *rear;
    int size;
} ReadyQueue;

FILE *output = NULL;

void push(ReadyQueue *q, Data data) {
    if (q->size >= 10) {
        fprintf(output, "ERROR: Queue is full.\n");
        exit(0);
    }

    Node *new_node = (Node *)malloc(sizeof(Node));

    new_node->data = data;
    new_node->next = NULL;

    if (q->size == 0) {
        q->front = q->rear = new_node;
    } else {
        q->rear->next = new_node;
        q->rear = q->rear->next;
    }

    q->size++;
}

Data pop(ReadyQueue *q) {
    if (q->size <= 0) {
        fprintf(output, "ERROR: Queue is empty.\n");
        exit(0);
    }

    Node *temp = q->front;
    Data result = temp->data;
    q->front = temp->next;
    free(temp);
    q->size--;
    return result;
}

Data get_front(ReadyQueue *q) {
    if (q->size <= 0) {
        fprintf(output, "ERROR: Queue is empty.\n");
        exit(0);
    }
    return q->front->data;
}

void refresh_priority(ReadyQueue *q, double alpha) {
    Node *cur = q->front;
    while (cur->next != NULL) {
        cur->data.waiting_time++;
        cur->data.current_priority = GET_PRIORITY(cur->data.priority, cur->data.waiting_time, alpha);
        cur = cur->next;
    }
}

void calculate_stat(int *total_waiting_time, int *total_turnaround_time, int *total_response_time, int time, PCB cpu) {
    *total_waiting_time += time - cpu.arrival_time - cpu.burst_time;
    *total_turnaround_time += time - cpu.arrival_time;
    *total_response_time += cpu.first_enter_time - cpu.arrival_time;
}

int compare_by_arrival_time(const void *a, const void *b) {
    return ((PCB *)a)->arrival_time > ((PCB *)b)->arrival_time;
}

void fcfs_scheduler(PCB p[], int process_size) {
    fprintf(output, "Scheduling : FCFS\n");
    fprintf(output, "==========================================\n");

    ReadyQueue ready_queue = {};
    PCB *cpu = NULL;
    int time = 0;
    int index = 0;

    int idle_count = 0;
    int context_switch_count = 0;

    int total_waiting_time = 0;
    int total_response_time = 0;
    int total_turnaround_time = 0;

    while (1) {
        if (time == p[index].arrival_time) {
            push(&ready_queue, p[index]);
            fprintf(output, "<time %d> [new arrival] process %d\n", time, p[index].pid);
            index++;
        }

        if (cpu == NULL) {
            if (ready_queue.size > 0) {
                if (index > 1) {
                    context_switch_count++;
                    fprintf(output, "----------------------------- (Context-Switch)\n");
                }
                PCB tmp = pop(&ready_queue);
                cpu = &tmp;
                if (cpu->burst_time == cpu->current_burst_time) cpu->first_enter_time = time;
                fprintf(output, "<time %d> process %d is running\n", time, cpu->pid);
                cpu->current_burst_time--;
            } else {
                idle_count++;
                fprintf(output, "<time %d> ---- system is idle ----\n", time);
            }
        } else {
            if (cpu->current_burst_time <= 1) {
                cpu->current_burst_time--;
                fprintf(output, "<time %d> process %d is finished\n", time, cpu->pid);
                calculate_stat(&total_waiting_time, &total_turnaround_time, &total_response_time, time + 1, *cpu);
                cpu = NULL;
            } else {
                cpu->current_burst_time--;
                fprintf(output, "<time %d> process %d is running\n", time, cpu->pid);
            }
        }

        time++;

        if ((index == process_size) && (ready_queue.size == 0) && (cpu == NULL)) {
            fprintf(output, "<time %d> all processes finish\n", time);
            fprintf(output, "==========================================\n");
            fprintf(output, "Avarage cpu usage: %.2lf %% \n", ((double)(time - (idle_count + context_switch_count)) / time) * 100);
            fprintf(output, "Avarage waiting time: %.2lf\n", ((double)total_waiting_time / process_size));
            fprintf(output, "Avarage response time: %.2lf\n", ((double)total_response_time / process_size));
            fprintf(output, "Avarage turnaround time: %.2lf\n", ((double)total_turnaround_time / process_size));
            break;
        }
    }
}

void rr_scheduler(PCB p[], int process_size, int q) {
    fprintf(output, "Scheduling : RR\n");
    fprintf(output, "==========================================\n");

    ReadyQueue ready_queue = {};
    PCB *cpu = NULL;
    int time = 0;
    int index = 0;

    int idle_count = 0;
    int context_switch_count = 0;

    int total_waiting_time = 0;
    int total_response_time = 0;
    int total_turnaround_time = 0;

    int time_slicer = 0;

    while (1) {
        if (time == p[index].arrival_time) {
            push(&ready_queue, p[index]);
            fprintf(output, "<time %d> [new arrival] process %d\n", time, p[index].pid);
            index++;
        }

        if (cpu == NULL) {
            if (ready_queue.size > 0) {
                PCB tmp = pop(&ready_queue);
                cpu = &tmp;
                if (cpu->burst_time == cpu->current_burst_time) cpu->first_enter_time = time;
                fprintf(output, "<time %d> process %d is running\n", time, cpu->pid);
                cpu->current_burst_time--;
                time_slicer++;
            } else {
                idle_count++;
                fprintf(output, "<time %d> ---- system is idle ----\n", time);
            }
        } else {
            if (time > 0 && time_slicer >= q) {
                push(&ready_queue, *cpu);
                context_switch_count++;
                fprintf(output, "----------------------------- (Context-Switch)\n");
                PCB tmp = pop(&ready_queue);
                cpu = &tmp;
                time_slicer = 0;
                if (cpu->burst_time == cpu->current_burst_time) cpu->first_enter_time = time;
            }
            if (cpu->current_burst_time <= 1) {
                cpu->current_burst_time--;
                fprintf(output, "<time %d> process %d is finished\n", time, cpu->pid);
                calculate_stat(&total_waiting_time, &total_turnaround_time, &total_response_time, time + 1, *cpu);
                cpu = NULL;
                if (ready_queue.size > 0) {
                    context_switch_count++;
                    time_slicer = 0;
                    fprintf(output, "----------------------------- (Context-Switch)\n");
                }
            } else {
                cpu->current_burst_time--;
                time_slicer++;
                fprintf(output, "<time %d> process %d is running\n", time, cpu->pid);
            }
        }

        time++;

        if ((index == process_size) && (ready_queue.size == 0) && (cpu == NULL)) {
            fprintf(output, "<time %d> all processes finish\n", time);
            fprintf(output, "==========================================\n");
            fprintf(output, "Avarage cpu usage: %.2lf %% \n", ((double)(time - (idle_count + context_switch_count)) / time) * 100);
            fprintf(output, "Avarage waiting time: %.2lf\n", ((double)total_waiting_time / process_size));
            fprintf(output, "Avarage response time: %.2lf\n", ((double)total_response_time / process_size));
            fprintf(output, "Avarage turnaround time: %.2lf\n", ((double)total_turnaround_time / process_size));
            break;
        }
    }
}

void priority_scheduler(PCB p[], int process_size, double alpha) {
    fprintf(output, "Scheduling : Priority\n");
    fprintf(output, "==========================================\n");

    ReadyQueue ready_queue = {};
    PCB *cpu = NULL;
    int time = 0;
    int index = 0;

    int idle_count = 0;
    int context_switch_count = 0;

    int total_waiting_time = 0;
    int total_response_time = 0;
    int total_turnaround_time = 0;

    while (1) {
        if (time == p[index].arrival_time) {
            push(&ready_queue, p[index]);
            fprintf(output, "<time %d> [new arrival] process %d\n", time, p[index].pid);
            index++;
        }

        if (cpu == NULL) {
            if (ready_queue.size > 0) {
                PCB tmp = pop(&ready_queue);
                cpu = &tmp;
                if (cpu->burst_time == cpu->current_burst_time) cpu->first_enter_time = time;
                fprintf(output, "<time %d> process %d is running\n", time, cpu->pid);
                cpu->current_burst_time--;
            } else {
                idle_count++;
                fprintf(output, "<time %d> ---- system is idle ----\n", time);
            }
        } else {
            if (time > 0 && ready_queue.size > 0) {
                refresh_priority(&ready_queue, alpha);

                Data front = get_front(&ready_queue);
                if (front.current_priority > cpu->current_priority) {
                    push(&ready_queue, *cpu);
                    context_switch_count++;
                    fprintf(output, "----------------------------- (Context-Switch)\n");
                    PCB tmp = pop(&ready_queue);
                    cpu = &tmp;
                    cpu->waiting_time = 0;
                    if (cpu->burst_time == cpu->current_burst_time) cpu->first_enter_time = time;
                }
            }
            if (cpu->current_burst_time <= 1) {
                cpu->current_burst_time--;
                fprintf(output, "<time %d> process %d is finished\n", time, cpu->pid);
                calculate_stat(&total_waiting_time, &total_turnaround_time, &total_response_time, time + 1, *cpu);
                cpu = NULL;
                if (ready_queue.size > 0) {
                    context_switch_count++;
                    fprintf(output, "----------------------------- (Context-Switch)\n");
                }
            } else {
                cpu->current_burst_time--;
                fprintf(output, "<time %d> process %d is running\n", time, cpu->pid);
            }
        }

        time++;

        if ((index == process_size) && (ready_queue.size == 0) && (cpu == NULL)) {
            fprintf(output, "<time %d> all processes finish\n", time);
            fprintf(output, "==========================================\n");
            fprintf(output, "Avarage cpu usage: %.2lf %% \n", ((double)(time - (idle_count + context_switch_count)) / time) * 100);
            fprintf(output, "Avarage waiting time: %.2lf\n", ((double)total_waiting_time / process_size));
            fprintf(output, "Avarage response time: %.2lf\n", ((double)total_response_time / process_size));
            fprintf(output, "Avarage turnaround time: %.2lf\n", ((double)total_turnaround_time / process_size));
            break;
        }
    }
}

int main(int argc, char *argv[]) {
    if (argc != 5) {
        printf("Usage: <input file> <output file> <time quantum> <alpha>\n");
        return 0;
    }

    FILE *file = fopen(argv[1], "r");
    if (file == 0) {
        printf("ERROR: Could not open the input file.\n");
        return 0;
    }
    output = fopen(argv[2], "w");
    if (output == 0) {
        printf("ERROR: Could not open the output file.\n");
        return 0;
    }

    PCB job_queue[MAX_PROCESS] = {};
    int file_cnt = 0;
    while (fscanf(file, "%d\t%d\t%d\t%d", &job_queue[file_cnt].pid, &job_queue[file_cnt].priority, &job_queue[file_cnt].arrival_time, &job_queue[file_cnt].burst_time) != EOF) {
        job_queue[file_cnt].current_burst_time = job_queue[file_cnt].burst_time;
        job_queue[file_cnt].current_priority = job_queue[file_cnt].priority;
        job_queue[file_cnt].first_enter_time = 0;
        job_queue[file_cnt].waiting_time = 0;
        file_cnt++;
    }
    qsort(job_queue, file_cnt, sizeof(PCB), compare_by_arrival_time);

    fcfs_scheduler(job_queue, file_cnt);
    fprintf(output, "\n");
    rr_scheduler(job_queue, file_cnt, atoi(argv[3]));
    fprintf(output, "\n");
    priority_scheduler(job_queue, file_cnt, atof(argv[4]));

    fclose(file);
    fclose(output);

    return 0;
}