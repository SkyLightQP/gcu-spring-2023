#include <stdio.h>

#define MAX_SIZE 10

int stack[MAX_SIZE] = {};
int top = -1;

int stack_full() {
    return top == (MAX_SIZE - 1);
}

int stack_empty() {
    return top == -1;
}

void push(int n) {
    if (stack_full()) return;
    stack[++top] = n;
}

int pop() {
    if (stack_empty()) return -1;
    return stack[top--];
}

int main() {
    printf("is stack full: %d\n", stack_full());
    printf("\n");

    push(1);
    push(2);

    printf("pop: %d\n", pop());
    printf("pop: %d\n", pop());
    printf("\n");

    printf("is stack empty: %d\n", stack_empty());
    printf("\n");

    for (int i = 1; i <= 10; i++) {
        push(i);
    }
    printf("is stack full: %d\n", stack_full());
    printf("\n");

    printf("pop: %d\n", pop());

    return 0;
}