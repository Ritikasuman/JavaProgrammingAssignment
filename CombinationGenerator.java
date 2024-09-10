/**
 * Task: Valid Parentheses Combination Generator
 * Description: Write a Java program that generates all valid combinations of 
 * the string pairs of characters. Each combination should be unique and well-formed.
 * 
 * Example:
 * Input: "abc"
 * Output: ["a", "b", "c", "ab", "ac", "ba", "bc", "ca", "cb", "abc", "acb", "bac", "bca", "cab", "cba"]
 * 
 * Things Included:
 * - Recursion 
 * - Use of Set to store unique combinations
 * 
 * Author: Ritika suman
 * Date: 09 September 2024
 */
import java.util.Scanner;

public class CombinationGenerator {
    public static void main(String[] args) {
        CombinationGenerator generator = new CombinationGenerator();
        generator.generateCombinations();
    }
    public void generateCombinations() {
        Scanner scanner = new Scanner(System.in);
        boolean continueGenerating = true;

        while (continueGenerating) {
          
            System.out.print(Constants.INPUT_STRING_PROMPT);
            String userInputString = scanner.nextLine();
            char[] inputArray = userInputString.toCharArray();
            int length = inputArray.length;
            System.out.println(Constants.COMBINATIONS_PERMUTATIONS_MESSAGE);

            for (int i = 1; i < (1 << length); i++) {
                char[] subset = new char[length];
                int subsetLength = 0;

                for (int j = 0; j < length; j++) {
                    if ((i & (1 << j)) != 0) {
                        subset[subsetLength++] = inputArray[j];
                    }
                }

                generatePermutations(subset, 0, subsetLength);
            }
            System.out.println(Constants.OPTION_PROMPT);
            System.out.println(Constants.OPTION_1);
            System.out.println(Constants.OPTION_2);
            System.out.print(Constants.ENTER_OPTION_PROMPT);
            String option = scanner.nextLine();

            switch (option) {
                case "1":
                    break;
                case "2":
                    continueGenerating = false;
                    break;
                default:
                    System.out.println(Constants.INVALID_OPTION_MESSAGE);
                    continueGenerating = false;
                    break;
            }
        }

        scanner.close();
    }

    /**
     * This method generates all permutations of the given array.
     *  array :The array to generate permutations from.
     *  left : The starting index.
     *  right : The ending index.
     */
    private void generatePermutations(char[] array, int left, int right) {
        if (left == right) {
            for (int i = 0; i < right; i++) {
                System.out.print(array[i]);
            }
            System.out.println();
        } else {
            for (int i = left; i < right; i++) {
                swap(array, left, i);
                generatePermutations(array, left + 1, right);
                swap(array, left, i); // Backtrack
            }
        }
    }

    /**
     * Helper method to swap elements in the array.
     * array: The array to swap elements in.
     * i : The first index.
     * j : The second index.
     */
    private void swap(char[] array, int i, int j) {
        char temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
