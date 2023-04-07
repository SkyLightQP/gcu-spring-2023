#include <stdio.h>
#include <stdlib.h>

#define MAX_SIZE 10

typedef struct _Node {
    struct _Node* next;
    int value;
} Node;

Node* top = NULL;
int nodes = 0;

int stack_full() {
    return nodes == MAX_SIZE;
}

int stack_empty() {
    return nodes == 0;
}

void push(int n) {
    Node* new_node = (Node*)malloc(sizeof(Node));
    if (new_node == NULL) {
        printf("Memory allocation failed.\n");
        exit(1);
    }

    new_node->value = n;
    new_node->next = top;
    top = new_node;

    nodes++;
}

int pop() {
    Node* temp = top;
    int result = temp->value;
    top = top->next;
    free(temp);
    nodes--;
    return result;
}

void print_stack() {
    printf("stack = (top)");
    Node* cur = top;
    while (cur != NULL) {
        printf(" %d", cur->value);
        cur = cur->next;
    }
    printf("\n");
}

void run_pushes(int arr[], int num) {
    for (int i = 0; i < num; i++) {
        printf("push(%d) , ", arr[i]);

        if (!stack_full()) {
            push(arr[i]);
        } else {
            printf("stack full! ");
        }

        print_stack();
    }
}

void run_pops(int num) {
    int value;

    for (int i = 0; i < num; i++) {
        printf("pop() ");
        if (!stack_empty()) {
            value = pop();
            printf("-> %d , ", value);
        } else {
            printf("stack empty! ");
        }
        print_stack();
    }
}

int main() {
    int numbers[] = {3, 9, 4, 5, 2, 1, 6, 8, 7, 5, 8};
    print_stack();
    run_pushes(numbers, 5);
    run_pops(3);
    run_pushes(numbers, 10);
    run_pops(11);
}