/**
 * Task: Caesar Cipher with Shift Variability
 * Description: Write a program that implements the Caesar Cipher encryption technique but with a twist. 
 * The program should take an input string and a shift pattern array. For each character in the string, 
 * apply the corresponding shift value from the pattern array. If the pattern array length is shorter 
 * than the input string, repeat the pattern.
 * 
 * Example:
 * Input: "HELLO WORLD", Shift Pattern: [1, 2, 3]
 * Output: "IFMMP XPSME"
 * 
 * Author: Ritika suman
 * Date: 09 September 2024
 */
import java.util.Scanner;

public class CaesarCipher {
    /*
     * Encodes a given string using Caesar Cipher with a specified shift pattern.
     * text: The input string to be encoded.
     * shiftPattern: An array of integers specifying the shift pattern.
     * returning The encoded string after applying the Caesar Cipher.
     */
    public static String caesarCipher(String text, int[] shiftPattern) {
        String result = "";
        int shiftIndex = 0;

        for (int i = 0; i < text.length(); i++) {
            char character = text.charAt(i);

            if (character == ' ') {
                shiftIndex = (shiftIndex + shiftPattern.length) % shiftPattern.length;
                result += character;
            } else if (Character.isLetter(character)) {
                int shift = shiftPattern[shiftIndex];

                if (Character.isLowerCase(character)) {
                    char shiftedChar = (char) ('a' + (character - 'a' + shift + 26) % 26);
                    result += shiftedChar;
                } else if (Character.isUpperCase(character)) {
                    char shiftedChar = (char) ('A' + (character - 'A' + shift + 26) % 26);
                    result += shiftedChar;
                }

                shiftIndex = (shiftIndex + 1) % shiftPattern.length;
            } else {
                result += character;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print(Constants.INPUT_STRING_PROMPT);
        String input = scanner.nextLine();

        String result = caesarCipher(input, Constants.CAESAR_SHIFT_PATTERN);

        System.out.println("Encoded: " + result);

        scanner.close();
    }
}
