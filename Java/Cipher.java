import java.util.Scanner;

/*
This class performs the Julius Caesar cipher on a string.

Telvin Zhong
5-29-2020
*/

public class Cipher {

    /*
    This class shifts all alphabet characters in an inputted string by a key.
    Upper/lowercase and symbols are preserved.

    @param args (unused)
    */

    public static boolean leave_unchanged(char c) {
        // Quick function to check if the character should remain unchanged.
        return (c == ' ' || c == '.' || c == ',' || c == '!' || c == '?');
    }

    public static String encrypt(String s, int key) {
        // Encrypt by shifting characters forward by a key.
        String ans = "";

        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);
            
            if (leave_unchanged(c)) {
                ans += c;
            }

            else if (Character.isUpperCase(c)) {
                // If uppercase, rotate in range 65 to 65 + 26
                int c_int = ((int) c - 65 + key) % 26 + 65;
                char c_moved = (char) c_int;
                ans += c_moved;
            }

            else {
                // If lowercase, range is 97 to 97 + 26
                int c_int = ((int) c - 97 + key) % 26 + 97;
                char c_moved = (char) c_int;
                ans += c_moved;
            }

        }

        return ans;
    }
    
    public static String decrypt(String s, int key) {
        // Decrypt by shifting characters backwards by a key
        String ans = "";

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (leave_unchanged(c)) {
                ans += c;
            }

            else if (Character.isUpperCase(c)) {
                // If uppercase, rotate in range 65 to 65 + 26
                // The + 26 helps get around Java modulo traits
                int c_int = ((int) c - 65 + 26 - key) % 26 + 65;
                char c_moved = (char) c_int;
                ans += c_moved;
            }

            else {
                // If lowercase, range is 97 to 97 + 26
                int c_int = ((int) c - 97 + 26 - key) % 26 + 97;
                char c_moved = (char) c_int;
                ans += c_moved;
            }
        }

        return ans;
    }
    
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Enter the text below.");
        String s = keyboard.nextLine();

        char mode = ' ';
        // Continue asking questions until a valid input is given.

        while(mode == ' ') {
            System.out.println("Enter E for Encryption, D for Decryption, or X to exit:");
            String input = keyboard.nextLine();

            if (input.equals("X")) {
                System.out.println("Exiting Program.");
                System.exit(0);
            }

            else if (input.equals("E")) {
                mode = 'e';
            }

            else if (input.equals("D")) {
                mode = 'd';
            }

            else {
                System.out.println("Input not recognized. Try again.");
            }
        }

        System.out.println("Enter the key:");
        int key = keyboard.nextInt() % 26;

        if (key < 0) {
            System.out.println("Your key must be non-negative.");
            System.exit(0);
        }

        // Run either encrypt or decrypt depending on which input was given.
        if (mode == 'e') {
            System.out.println("The encrypted text is below:");
            System.out.println(encrypt(s, key));
        }

        else if (mode == 'd') {
            System.out.println("The decrypted text is below:");
            System.out.println(decrypt(s, key));
        }
        keyboard.close();
    }
}