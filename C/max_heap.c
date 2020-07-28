#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

#define ARR_SIZE 15
#define new_max(x,y) ((x) >= (y)) ? (x) : (y)
#define new_min(x,y) ((x) <= (y)) ? (x) : (y)

// Note: if index n is parent, 2n and 2n + 1 are child nodes. This removes the need to create node structs.
int arr[ARR_SIZE];
int top = 0;


// Array methods.

int get_parent(int a) {
    return a / 2;
}

int get_child1(int a) {
    return 2 * a + 1;
}

int get_child2(int a) {
    return 2 * a + 2;
}

void arr_swap(int a, int b) {
    int temp = arr[a];
    arr[a] = arr[b];
    arr[b] = temp;
}

// Heap Methods.
bool isEmpty() {
    return top == 0;
}

bool isFull() {
    return top == ARR_SIZE;
}

void push(int x) {
    if (isFull()) {
        printf("Error: Array is full.\n");
    } else {
        // printf("Now inserting %d at %d\n", x, top);
        arr[top] = x;
        // print_arr();

        rebalanceUp(top);
        top++;
    }
}

void rebalanceUp(int a) {
    int cur = a; // Current position to swap in maxheap.
    int parent = get_parent(cur); // Parent to compare to.

    // Swap the inserted number higher if it is larger than parent.
    while (arr[cur] > arr[parent]) {
        // printf("child %d is moving up to its parent %d in location %d\n", arr[cur], arr[parent], parent);
        arr_swap(cur, parent);
        cur = parent;
        parent = get_parent(cur);
        // print_arr();

    }
}


int pop() {
    if (isEmpty()) {
        printf("Error: Array is empty.\n");
        return 0;
    } else {
        // Pop the first element(maximum) and rebase the structure before returning. 
        int temp = arr[0];

        arr[0] = arr[top];
        arr[top--] = NULL;
        rebalanceDown(0);
        return temp;
    }
}

void rebalanceDown(int a) {
    // Recursively generate children and swap with larger child if needed.
    int cur = a;
    int child1 = get_child1(cur);
    int child2 = get_child2(cur);

    while (arr[cur] < arr[child1] || arr[cur] < arr[child2]) {
        if (arr[child1] > arr[child2]) {
            arr_swap(cur, child1);
            cur = child1;
        } else {
            arr_swap(cur, child2);
            cur = child2;
        }

        child1 = get_child1(cur);
        child2 = get_child2(cur);
    }
}

void isNull(int a) {
    return a >= top;
}

// Helper function to print the list.
void print_arr() {
    for (int i = 0; i < ARR_SIZE; i++) {
        printf("%d ", arr[i]);
    }
    printf("\n");
}

int main() {
    push(16);
    push(84);
    push(22);
    push(129);
    push(7);
    push(15);
    push(0);
    printf("%d\n", pop());
    printf("%d\n", pop());
    printf("%d\n", pop());
    printf("%d\n", pop());
    print_arr();
}
