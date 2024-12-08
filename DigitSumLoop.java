/**
 * Task: Digit Sum Loop (String)
 * Description: Write a Java program that continuously takes a number as input 
 * and replaces it with the sum of its digits until the number is reduced to a single digit.
 * 
 * Example:
 * Input: 9875
 * Output: 2 (Explanation: 9+8+7+5=29, 2+9=11, 1+1=2)
 * 
 * Author: Ritika suman
 * Date: 09 September 2024
 */
import java.util.InputMismatchException;
import java.util.Scanner;

public class DigitSumLoop {

    /**
     * Calculates the sum of the digits of the given number.
     * input number: The number for which the sum of digits is to be calculated.
     * return :The sum of the digits of the given number.
     */
    public static int sumOfDigits(int number) {
        int sum = 0;
        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int number = 0;
        boolean validInput = false;

        while (!validInput) {
            System.out.print(Constants.ENTER_NUMBER_PROMPT);
            try {
                number = sc.nextInt();
                validInput = true; 
            } catch (InputMismatchException e) {
                System.out.println(Constants.INVALID_INPUT_MESSAGE);
                sc.next(); 
            }
        }

        while (number >= 10) {
            number = sumOfDigits(number);
        }
        System.out.println(Constants.REDUCED_TO_SINGLE_DIGIT + number);
        sc.close();
    }
}
