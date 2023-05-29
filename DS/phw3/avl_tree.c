#include <stdio.h>
#include <stdlib.h>
#include <time.h>

#define RMAX 100

typedef struct node {
    int data;
    struct node *left, *right;
    int ht;
} node;

int max_key = -1;

node *insert(node *, int);
node *Delete(node *, int);
void preorder(node *);
void inorder(node *);
int height(node *);
node *rotateright(node *);
node *rotateleft(node *);
node *RR(node *);
node *LL(node *);
node *LR(node *);
node *RL(node *);
int BF(node *);

void postorder(node *);
void search(node *, int);
void search_max(node *);
void search_less_than(node *, int);
void search_greater_than(node *, int);
void search_between(node *, int, int);

int main() {
    srand(time(NULL));

    node *root = NULL;

    // Make array list with 15, 50 and random numbers.
    int list[200] = {};
    list[0] = 15;
    list[1] = 50;
    for (int i = 2; i < 200; i++) {
        int random = 1 + (int)rand() % RMAX;
        list[i] = random;
    }

    // Make AVL tree
    for (int i = 0; i < 50; i++) {
        root = insert(root, list[i]);
    }

    // Run codes
    printf("Traverse keys in inorder, preorder and postorder:\n");
    printf("[Inorder]\n");
    inorder(root);
    printf("\n[Preorder]\n");
    preorder(root);
    printf("\n[Postorder]\n");
    postorder(root);

    printf("\n\nSearch for keys 15, 20, 50, 70, and 90:\n");
    int search_testcase[5] = {15, 20, 50, 70, 90};
    for (int i = 0; i < 5; i++) {
        search(root, search_testcase[i]);
    }

    printf("\nSearch max key:\n");
    search_max(root);

    printf("\nSearch all keys < 15:\n");
    search_less_than(root, 15);

    printf("\nSearch all keys > 50:\n");
    search_greater_than(root, 50);

    printf("\nSearch all keys between 15 and 50:\n");
    search_between(root, 15, 50);

    return 0;
}

node *insert(node *T, int x) {
    if (T == NULL) {
        T = (node *)malloc(sizeof(node));
        T->data = x;
        T->left = NULL;
        T->right = NULL;
    } else if (x > T->data)  // insert in right subtree
    {
        T->right = insert(T->right, x);
        if (BF(T) == -2)
            if (x > T->right->data)
                T = RR(T);
            else
                T = RL(T);
    } else if (x < T->data) {
        T->left = insert(T->left, x);
        if (BF(T) == 2)
            if (x < T->left->data)
                T = LL(T);
            else
                T = LR(T);
    }
    T->ht = height(T);
    return (T);
}

node *Delete(node *T, int x) {
    node *p;
    if (T == NULL) {
        return NULL;
    } else if (x > T->data)  // insert in right subtree
    {
        T->right = Delete(T->right, x);
        if (BF(T) == 2)
            if (BF(T->left) >= 0)
                T = LL(T);
            else
                T = LR(T);
    } else if (x < T->data) {
        T->left = Delete(T->left, x);
        if (BF(T) == -2)  // Rebalance during windup
            if (BF(T->right) <= 0)
                T = RR(T);
            else
                T = RL(T);
    } else {
        // data to be deleted is found
        if (T->right != NULL) {  // delete its inorder succesor
            p = T->right;
            while (p->left != NULL)
                p = p->left;
            T->data = p->data;
            T->right = Delete(T->right, p->data);
            if (BF(T) == 2)  // Rebalance during windup
                if (BF(T->left) >= 0)
                    T = LL(T);
                else
                    T = LR(T);
        } else
            return (T->left);
    }
    T->ht = height(T);
    return (T);
}

int height(node *T) {
    int lh, rh;
    if (T == NULL)
        return (0);
    if (T->left == NULL)
        lh = 0;
    else
        lh = 1 + T->left->ht;
    if (T->right == NULL)
        rh = 0;
    else
        rh = 1 + T->right->ht;
    if (lh > rh)
        return (lh);
    return (rh);
}

node *rotateright(node *x) {
    node *y;
    y = x->left;
    x->left = y->right;
    y->right = x;
    x->ht = height(x);
    y->ht = height(y);
    return (y);
}

node *rotateleft(node *x) {
    node *y;
    y = x->right;
    x->right = y->left;
    y->left = x;
    x->ht = height(x);
    y->ht = height(y);
    return (y);
}

node *RR(node *T) {
    T = rotateleft(T);
    return (T);
}

node *LL(node *T) {
    T = rotateright(T);
    return (T);
}

node *LR(node *T) {
    T->left = rotateleft(T->left);
    T = rotateright(T);
    return (T);
}

node *RL(node *T) {
    T->right = rotateright(T->right);
    T = rotateleft(T);
    return (T);
}

int BF(node *T) {
    int lh, rh;
    if (T == NULL)
        return (0);

    if (T->left == NULL)
        lh = 0;
    else
        lh = 1 + T->left->ht;

    if (T->right == NULL)
        rh = 0;
    else
        rh = 1 + T->right->ht;

    return (lh - rh);
}

void preorder(node *T) {
    if (T != NULL) {
        printf("%d(Bf=%d) ", T->data, BF(T));
        preorder(T->left);
        preorder(T->right);
    }
}

void inorder(node *T) {
    if (T != NULL) {
        inorder(T->left);
        printf("%d(Bf=%d) ", T->data, BF(T));
        inorder(T->right);
    }
}

void postorder(node *T) {
    if (T != NULL) {
        postorder(T->left);
        postorder(T->right);
        printf("%d(Bf=%d) ", T->data, BF(T));
    }
}

void search(node *T, int key) {
    if (T == NULL) return;
    search(T->left, key);
    if (T->data == key) {
        printf("Found key. (%d)\n", T->data);
    }
    search(T->right, key);
}

void search_max(node *T) {
    if (T == NULL) return;
    while (T->right != NULL) {
        T = T->right;
    }
    printf("Found max key. (%d)\n", T->data);
}

void search_less_than(node *T, int key) {
    if (T == NULL) return;
    search_less_than(T->left, key);
    if (T->data < key) {
        printf("Found less than %d key. (%d)\n", key, T->data);
    }
    search_less_than(T->right, key);
}

void search_greater_than(node *T, int key) {
    if (T == NULL) return;
    search_greater_than(T->left, key);
    if (T->data > key) {
        printf("Found greater than %d key. (%d)\n", key, T->data);
    }
    search_greater_than(T->right, key);
}

void search_between(node *T, int a, int b) {
    if (T == NULL) return;
    if (T->data > a && T->data < b) {
        printf("Found between %d and %d key. (%d)\n", a, b, T->data);
    }
    if (T->data >= a) {
        search_between(T->left, a, b);
    }
    if (T->data <= b) {
        search_between(T->right, a, b);
    }
}
