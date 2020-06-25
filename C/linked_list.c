#include <stdio.h>
#include <stdlib.h>

//define the node type, will be referred to as node 
typedef struct nd {
	int data;
	struct nd* next;
} node;

// top points to front of the linked list
// temp is just to initialize for now
node* top = NULL; // meaning currently the list is empty

//define a function to create a new node when you give it a data parameter
node* newNode(int d) {
  node* temp;
  temp = (node*)malloc(sizeof(node));
  temp->data = d;
  temp->next = NULL;
  return temp;
}

//add a node (given in parameter) to the top of the stack
void push(int d) {
  node* temp;
  if (top == NULL) {
    top = newNode(d);
  } else {
    temp = newNode(d);
    // Right to left, so the newly created temp points to current top
    // Then the actual top of stack moves to the one we just made
    temp->next = top;
    top = temp;
  }

  return;
}

//remove the node at the front of the list and return it
int pop() {
  int n = 0;
  if (top != NULL) {
    printf("Popped: %d\n",top -> data);
    n = top->data;
    top = top->next;
    // Ideally change the old-->next to NULL and then temp = top; free(temp);
  } else {
    printf("Error: attempt to remove a null node\n");
    return 0;
  }
  return n;

}

int isEmpty() {
  if (top != NULL) {
    return 0;
  } 
  return 1;
}

int main () {

    pop();
    push(1);
    push(2);
    push(3);
    pop();
    push(4);
    push(5);
    pop();
    pop();
    push(6);
    pop();
    pop();

  return 0;
}