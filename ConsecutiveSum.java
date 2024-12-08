/**
 * Task: Consecutive Number Summer
 * Description: Write a Java program that finds whether a given number can be expressed 
 * as the sum of two or more consecutive natural numbers. If possible, the program should 
 * print all possible combinations of consecutive natural numbers that sum up to the given number.
 * Example:
 * Input: 15
 * Output:
 * 1 + 2 + 3 + 4 + 5
 * 4 + 5 + 6
 * 7 + 8
 * Things Included:
 * - Iteration 
 * - Use of lists to store and print combination
 * Author: Ritika suman
 * Date: 09 September 2024
 */
import java.util.Scanner;

public class ConsecutiveSum {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print(Constants.ENTER_NUMBER_PROMPT);
        int number = scan.nextInt();
        
        findConsecutiveSums(number);
        
        scan.close();
    }

    /* 
     * Finds and prints all sequences of consecutive integers that sum up to the specified number.
     *  input : number The target number for which consecutive sums are to be found.
     *  does not return a value.
     */
    private static void findConsecutiveSums(int number) {
        for (int start = 1; start < number; start++) {
            int sum = start;
            for (int next = start + 1; sum < number; next++) {
                sum += next;
                if (sum == number) {
                    printSequence(start, next - 1);
                }
            }
        }
    }

    /**
     * Prints a sequence of integers from start to end.
     * start: The starting integer of the sequence.
     * end: The ending integer of the sequence.
     * does not return a value.
     */
    private static void printSequence(int start, int end) {
        for (int i = start; i <= end; i++) {
            System.out.print(i + (i < end ? " + " : ""));
        }
        System.out.println();
    }
}
