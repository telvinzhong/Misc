/*
 * CS5007 Homework 5: Memory Hierarchy and Processes
 * Author (team): Mark Yu, Telvin Zhong
 * Date: 2020-06-04
 */

# include <stdio.h>
# include <string.h>

int main() {
    char input[100] = "";
    int true = 1;

    // if the user don't quit, the loop keeps executing
    while (true) {
        // prompt the user to enter a string
        printf("Input a string or type \"QUIT\" to exit the program:\n");
        fgets(input, 100, stdin);
        // convert all the input to upper case
        for (int i = 0; i < strlen(input); i++) {
            if (('a' <= input[i]) && (input[i] <= 'z')) {
                input[i] -= 0x20;
            }
        }
        // if the user input is "quit" (any lower-case variation), break the loop
        if (strcmp(input, "QUIT\n") == 0) {
            printf("\nGood bye!\n\n");
            break;
        }
        // print the converted (upper-cased) string
        printf("%s\n", input);
        // use a counting array as a dictionary, to check if a char is unique
        int count[128] = {0};
        // print the each unique letter and its hex code
        for (int j = 0; j < strlen(input); j++) {
            if (input[j] == '\n' && count[input[j]] == 0) {
                printf("\\n -- 0x0%x\n\n", input[j]);
                count[input[j]]++;
            } else if (count[input[j]] == 0) {
                printf(" %c -- 0x%x\n", input[j], input[j]);
                count[input[j]]++;
            }
        }
    }

    return 0;
}