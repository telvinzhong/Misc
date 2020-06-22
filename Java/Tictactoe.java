import java.util.Scanner;

public class Tictactoe {
    
    /*
    This class allows users to play Tic Tac Toe with standard rules.

    Telvin Zhong
    6/6/2020
    */

    public static String winner = "";
    public static String turn = "X";
    // Use 2d array for ease of checking for winners.
    public static String[][] board = new String[][] {{"_", "_", "_",},
                                              {"_", "_", "_",},
                                              {"_", "_", "_",}};

    public static void printBoard() {
        System.out.println("  A   B   C  ");
        System.out.println("/-----------\\");
        System.out.println("| " + board[0][0] + " | " + board[0][1] + " | " + board[0][2] + " | 1");
        System.out.println("|-----------|");
        System.out.println("| " + board[1][0] + " | " + board[1][1] + " | " + board[1][2] + " | 2");
        System.out.println("|-----------|");
        System.out.println("| " + board[2][0] + " | " + board[2][1] + " | " + board[2][2] + " | 3");
        System.out.println("\\-----------/");
            }                                        

    // Validate only strings of length two with A-C and 1-3 as characters.
    public static boolean checkMove(String input) {
        if (input.charAt(0) < 65 || input.charAt(0) > 99 || input.charAt(0) > 67 && input.charAt(0) < 95) {
            return false;
        }
        else if (input.charAt(1) < 49 || input.charAt(1) > 51) {
            return false;
        }
        else if (input.length() != 2) {
            return false;
        }

        return true;
        }


    public static void setBoard(String input) {
        int row = 0, col = 0;

        // Get the numerical column from the alphabetical input.
        // Support for upper and lower is pretty easy with switches so I threw it in.
        switch (input.charAt(0)) {
        case 'A':
        case 'a':
            col = 0;
            break;
        case 'B':
        case 'b':
            col = 1;
            break;    
        case 'C':
        case 'c':
            col = 2;
            break;
        default:
            // It should never be able to reach this line.
            System.out.println("Invalid input. Please try again.");
            break;
        }

        row = input.charAt(1) - 49;

        // Assign 
        board[row][col] = turn;
    }

    public static boolean checkWinner(String player) {
        for (int i = 0; i < 3; i++) {
            if ((board[0][i].equals(player) && board[1][i].equals(player) && board[2][i].equals(player)) || 
            (board[i][0].equals(player) && board[i][1].equals(player) && board[i][2].equals(player)) || 
            (board[0][0].equals(player) && board[1][1].equals(player) && board[2][2].equals(player)) ||
            (board[0][2].equals(player) && board[1][1].equals(player) && board[2][0].equals(player))) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        // Begin the game.
        System.out.print("Welcome to Tic-Tac-Toe!\n");
        System.out.print("Please enter an uppercase letter and a number to choose a square.\n\n");
        printBoard();

        while (winner == "") {
            System.out.printf("Player %s to move:\n\n", turn);

            // Ensure that a valid square has been chosen before assigning to the square.
            String move = keyboard.nextLine();
            while (checkMove(move) == false) {
                System.out.println("Input not valid. Please try again.\n");
                move = keyboard.nextLine();
            }

            // Allow player to make a move.
            setBoard(move);

            // Print the board so that players can see the updated board.
            printBoard();
            
            // Check for winners. 
            if (checkWinner(turn)) {
                winner = turn;
            }

            // End the turn.
            if (turn == "X") {
                turn = "O"; 
            } else {
                turn = "X";
            }

        // Continue the loop if a winner has not been chosen.
        }

        // After this point, game is over and there is a winner.
        System.out.printf("\nCongratulations to Player %s for winning!!\n", winner);
        keyboard.close();
        }
}