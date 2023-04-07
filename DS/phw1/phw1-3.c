#include <stdio.h>
#include <stdlib.h>

#define MAX_SIZE 10

typedef struct _Node {
    struct _Node* next;
    int value;
} Node;

Node* front = NULL;
Node* rear = NULL;
int nodes = 0;

int queue_full() {
    return nodes == MAX_SIZE;
}

int queue_empty() {
    return nodes == 0;
}

void enqueue(int n) {
    Node* new_node = (Node*)malloc(sizeof(Node));
    if (new_node == NULL) {
        printf("Memory allocation failed.\n");
        exit(1);
    }

    new_node->value = n;
    new_node->next = NULL;

    if (queue_empty()) {
        front = rear = new_node;
    } else {
        rear->next = new_node;
        rear = rear->next;
    }

    nodes++;
}

int dequeue() {
    Node* temp = front;
    int result = temp->value;
    front = temp->next;
    free(temp);
    nodes--;
    return result;
}

void print_queue() {
    Node* n = front;

    printf("queue =");
    while (n != NULL) {
        printf(" %d ", n->value);
        n = n->next;
    }
    printf("\n");
}

void run_enqueues(int arr[], int num) {
    for (int i = 0; i < num; i++) {
        printf("enqueue(%d) , ", arr[i]);
        if (!queue_full()) {
            enqueue(arr[i]);
        } else {
            printf("queue full! ");
        }
        print_queue();
    }
}

void run_dequeues(int num) {
    int value;
    for (int i = 0; i < num; i++) {
        printf("dequeue() ");
        if (!queue_empty()) {
            value = dequeue();
            printf("-> %d , ", value);
        } else {
            printf("queue empty! ");
            front = rear = NULL;
        }
        print_queue();
    }
}

int main() {
    int numbers[] = {3, 9, 4, 5, 2, 1, 6, 8, 7, 5, 8};

    print_queue();
    run_enqueues(numbers, 5);
    run_dequeues(3);
    run_enqueues(numbers, 10);
    run_dequeues(11);
    run_enqueues(numbers, 11);
}