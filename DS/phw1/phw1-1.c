#include <stdio.h>

#define MAX_SIZE 10

int queue[MAX_SIZE] = {};
int front = -1;
int rear = -1;

int queue_full() {
    return (rear % MAX_SIZE) == (MAX_SIZE - 1);
}

int queue_empty() {
    return (front % MAX_SIZE) == -1 || (front % MAX_SIZE) > (rear % MAX_SIZE);
}

void enqueue(int n) {
    if (queue_full()) return;

    if (rear == -1) front++;
    queue[++rear % MAX_SIZE] = n;
}

int dequeue() {
    if (queue_empty()) return -1;
    return queue[front++ % MAX_SIZE];
}

void print_queue() {
    for (int i = (front % MAX_SIZE); i <= (rear % MAX_SIZE); i++) {
        printf(" %d", queue[i]);
    }
    printf(" (front=%d, rear=%d)\n", front % MAX_SIZE, rear % MAX_SIZE);
}

void enqueue_with_print(int n) {
    enqueue(n);
    printf("enqueue(%d),", n);
    print_queue();
}

int dequeue_with_print() {
    int temp = dequeue();
    printf("dequeue() %d,", temp);
    print_queue();
    return temp;
}

int main() {
    enqueue_with_print(10);
    enqueue_with_print(50);
    enqueue_with_print(20);
    enqueue_with_print(70);
    dequeue_with_print();
    enqueue_with_print(100);
    enqueue_with_print(40);
    enqueue_with_print(140);
    dequeue_with_print();
    dequeue_with_print();
    dequeue_with_print();

    return 0;
}