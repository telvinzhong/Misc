#include <stdio.h>
#include <stdlib.h>
#include <time.h>

#define ARR_SIZE 1

int nums[ARR_SIZE];
// Problem would be much harder if we passed pointers to arrays in the functions.

// int nums[6] = {6,4,3,1,5,2};

void merge(int l, int mid, int r) {

    // Create two lists for easier merging.
    // I could not use variables to initialize list lengths, strangely. 
    // https://stackoverflow.com/questions/2427336/why-cant-i-create-an-array-with-size-determined-by-a-global-variable
    int L[25], R[25]; 

    for (int i = 0; i < mid - l + 1; i++) 
        L[i] = nums[l + i]; 
    for (int j = 0; j < r - mid; j++) 
        R[j] = nums[mid + 1+ j]; 

    // Start at left index and modify values as we select the smaller number.
    int i = 0, j = 0, k = l;
    while (i < mid - l + 1 && j < r - mid) { 
        if (L[i] <= R[j]) { 
            nums[k++] = L[i++]; 
        } else { 
            nums[k++] = R[j++]; 
        } 
    } 

    // Add remainders.
    while (i < mid - l + 1) { 
        nums[k++] = L[i++]; 
    } 

    while (j < r - mid) { 
        nums[k++] = R[j++]; 
    } 
} 

void mergesort(int l, int r) {

    if (l < r) {
        int mid = (l + r) / 2;

        mergesort(l, mid);
        mergesort(mid + 1, r);

        // Merge given left and right parameters. 
        merge(l, mid, r);
    }
}

void generate_random() {
    // Seed for better random numbers.
    srand(time(0));

    // Create unsorted array nums.
    printf("Generating unsorted array.\n");
    for (int i = 0; i < ARR_SIZE; i++) {
        int r = rand() % 99;
        nums[i] = r;
    }
}

// Helper function to print the list.
void print_arr() {
    for (int i = 0; i < ARR_SIZE; i++) {
        printf("%d ", nums[i]);
    }
    printf("\n");
}


int main() {
    generate_random();
    print_arr();
    // mergesort(0, ARR_SIZE - 1);
    mergesort(0, ARR_SIZE - 1);
    printf("\nArray has been sorted: \n");
    print_arr();
    return 0;
}
