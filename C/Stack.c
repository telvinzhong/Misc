# include <stdio.h>

// Initialize global stack and top variables
int stack[100], top = -1;

int push(int v) {
    // Stack only allocates space for 100 items
    if (top >= 99) {
        printf("Error: Stack is full.\n");
        return 0;
    }

    // top + 1 is the index for the pushed number
    else {
        stack[++top] = v;
        return 0;
    }
}

int pop() {
    // Returns error only for when top is -1, or when empty
    if (top < 0) {
        printf("Error: Stack is empty.\n");
        return 0;
    }

    else {
        // Return stack[top] and also decrement top by one
        return stack[top--];
    }
}

int isEmpty() {
    // Return 0 (false) only if top is still -1, meaning empty list
    if (top < 0) {
        return 0;
    }

    else {
        return 1;
    }
}

// Test cases, expecting: 0, 3, 4, 5, 6, 2
int main() {
    printf("%d, ", pop());
    push(1); push(2); push(3);
    printf("%d, ", pop());
    push(4); push(5);
    printf("%d, %d, ", pop(), pop());
    push(6);
    printf("%d, ", pop());
    printf("%d", pop());

    return 0;
}
