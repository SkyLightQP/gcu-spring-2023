#include <stdio.h>

#define MAX_SIZE 10

int queue[MAX_SIZE] = {};
int front = -1;
int rear = -1;

int queue_full() {
    return rear == (MAX_SIZE - 1);
}

int queue_empty() {
    return front == rear;
}

void enqueue(int n) {
    if (queue_full()) return;
    queue[++rear] = n;
}

int dequeue() {
    if (queue_empty()) return -1;
    return queue[++front];
}

int main() {
    printf("is queue full: %d\n", queue_full());
    printf("\n");

    enqueue(1);
    enqueue(2);

    printf("dequeue: %d\n", dequeue());
    printf("dequeue: %d\n", dequeue());
    printf("\n");

    printf("is queue empty: %d\n", queue_empty());
    printf("\n");

    for (int i = 1; i <= 10; i++) {
        enqueue(i);
    }
    printf("is queue full: %d\n", queue_full());
    printf("\n");

    printf("dequeue: %d\n", dequeue());

    return 0;
}