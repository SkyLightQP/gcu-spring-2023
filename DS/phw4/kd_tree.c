#include <math.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>

#define MAX_DIM 3
struct kd_node_t {
    double x[MAX_DIM];
    struct kd_node_t *left, *right;
};

double dist(struct kd_node_t *a, struct kd_node_t *b, int dim) {
    double t, d = 0;
    while (dim--) {
        t = a->x[dim] - b->x[dim];
        d += t * t;
    }
    return d;
}

void swap(struct kd_node_t *x, struct kd_node_t *y) {
    double tmp[MAX_DIM];
    memcpy(tmp, x->x, sizeof(tmp));
    memcpy(x->x, y->x, sizeof(tmp));
    memcpy(y->x, tmp, sizeof(tmp));
}

/* see quickselect method */
struct kd_node_t *find_median(struct kd_node_t *start, struct kd_node_t *end, int idx) {
    if (end <= start) return NULL;
    if (end == start + 1)
        return start;

    struct kd_node_t *p, *store, *md = start + (end - start) / 2;
    double pivot;
    while (1) {
        pivot = md->x[idx];

        swap(md, end - 1);
        for (store = p = start; p < end; p++) {
            if (p->x[idx] < pivot) {
                if (p != store)
                    swap(p, store);
                store++;
            }
        }
        swap(store, end - 1);

        /* median has duplicate values */
        if (store->x[idx] == md->x[idx])
            return md;

        if (store > md)
            end = store;
        else
            start = store;
    }
}

struct kd_node_t *make_tree(struct kd_node_t *t, int len, int i, int dim) {
    struct kd_node_t *n;

    if (!len) return 0;
    if ((n = find_median(t, t + len, i))) {
        i = (i + 1) % dim;
        n->left = make_tree(t, n - t, i, dim);
        n->right = make_tree(n + 1, t + len - (n + 1), i, dim);
    }
    return n;
}

/* global variable, so sue me */
int visited;

void nearest(struct kd_node_t *root, struct kd_node_t *nd, int i, int dim,
             struct kd_node_t **best, double *best_dist) {
    double d, dx, dx2;

    if (!root) return;
    d = dist(root, nd, dim);
    dx = root->x[i] - nd->x[i];
    dx2 = dx * dx;

    visited++;

    if (!*best || d < *best_dist) {
        *best_dist = d;
        *best = root;
    }

    /* if chance of exact match is high */
    if (!*best_dist) return;

    if (++i >= dim) i = 0;

    nearest(dx > 0 ? root->left : root->right, nd, i, dim, best, best_dist);
    if (dx2 >= *best_dist) return;
    nearest(dx > 0 ? root->right : root->left, nd, i, dim, best, best_dist);
}

#define N 1000000
#define rand1() (rand() / (double)RAND_MAX)
#define rand_pt(v)        \
    {                     \
        v.x[0] = rand1(); \
        v.x[1] = rand1(); \
        v.x[2] = rand1(); \
    }

int point_search(struct kd_node_t *root, struct kd_node_t target, int i, int dim) {
    if (root == NULL) return 0;

    struct kd_node_t *result;
    double dist;

    nearest(root, &target, 0, 2, &result, &dist);

    if (result != NULL && dist == 0) return 1;
    return 0;
}

void range_search(struct kd_node_t *root, struct kd_node_t *min, struct kd_node_t *max, int dim) {
    if (root == NULL) return;

    int flag = 1;
    for (int i = 0; i < dim; i++) {
        if (root->x[i] < min->x[i] || root->x[i] > max->x[i]) {
            flag = 0;
            break;
        }
    }

    if (flag) {
        printf("2) Found node within (%g, %g)~(%g, %g): (%g, %g)\n", min->x[0], min->x[1], max->x[0], max->x[1], root->x[0], root->x[1]);
    }

    range_search(root->left, min, max, dim);
    range_search(root->right, min, max, dim);
}

void nearest_neighbor_search(struct kd_node_t *root, struct kd_node_t *target, int dep, int dim, double *result_dist) {
    if (root == NULL) return;

    double new_dist = dist(root, target, dim);
    if (new_dist < *result_dist) {
        *result_dist = new_dist;
        printf("3) Found neighbor node from (%g, %g): (%g, %g)\n", target->x[0], target->x[1], root->x[0], root->x[1]);
    }

    int axis = dep % dim;

    if (target->x[axis] < root->x[axis]) {
        nearest_neighbor_search(root->left, target, dep + 1, dim, result_dist);
        if (root->x[axis] - target->x[axis] <= ((*result_dist) * (*result_dist))) {
            nearest_neighbor_search(root->right, target, dep + 1, dim, result_dist);
        }
    } else {
        nearest_neighbor_search(root->right, target, dep + 1, dim, result_dist);
        if (target->x[axis] - root->x[axis] <= ((*result_dist) * (*result_dist))) {
            nearest_neighbor_search(root->left, target, dep + 1, dim, result_dist);
        }
    }
}

int main(void) {
    struct kd_node_t wp[] = {{{2, 3}}, {{5, 4}}, {{3, 4}}, {{9, 6}}, {{4, 7}}, {{8, 1}}, {{7, 2}}};
    struct kd_node_t *root;

    root = make_tree(wp, sizeof(wp) / sizeof(wp[1]), 0, 2);

    struct kd_node_t testcase_a[] = {{{5, 4}}, {{4, 7}}, {{10, 5}}};
    for (int t = 0; t < 3; t++) {
        int point_search_result = point_search(root, testcase_a[t], 0, 2);
        printf("1) Point Search (%g, %g): %s\n", testcase_a[t].x[0], testcase_a[t].x[1], point_search_result ? "found" : "not found");
    }

    struct kd_node_t testcase_min = {{6, 3}};
    struct kd_node_t testcase_max = {{9, 7}};
    range_search(root, &testcase_min, &testcase_max, 2);

    struct kd_node_t testcase_b[] = {{{5, 4}}, {{4, 7}}};
    for (int t = 0; t < 2; t++) {
        double temp_dist = 97654321;
        nearest_neighbor_search(root, &testcase_b[t], 0, 2, &temp_dist);
    }
	
    return 0;
}
