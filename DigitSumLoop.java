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
import java.util.Scanner;

public class DigitSumLoop {

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
        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        while (number >= 10) {
            number = sumOfDigits(number);
        }

        System.out.println("Reduced to single digit: " + number);
        sc.close();
    }
}