# include <stdio.h>
#include <stdlib.h>
#include <time.h>

int main() {
    int res[100];
    int nums[100];
    int size = 100;

    // Seed for better random numbers.
    srand(time(0));

    // Create unsorted array nums.
    printf("Generating unsorted array.\n");
    for (int i = 0; i < 100; i++) {
        int r = rand() % 99;
        printf("%d ", r);
        nums[i] = r;
    }

    // Iterate 100 times to account for every number
    for (int i = 0; i < 100; i++) {
        int min = nums[0];
        int index;

        // Iterate through remaining numbers to find new minimum.
        for (int j = 1; j < size; j++) {
            if (nums[j] < min) {
                min = nums[j];
                index = j;
            } 
        }

        // Remove minimum from nums.
        for (int next = index; next < size; next++) {
            nums[next] = nums[next + 1];
        }
    
        // Append minimum to res.
        res[i] = min;

        // Decrease the effective size of the array.
        size--;
    }

    printf("\nPrinting sorted list:\n");
    for (int i = 0; i < 100; i++) {
        printf("%d ", res[i]);
    }
}
