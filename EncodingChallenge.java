/**
 * Task: Encoding Challenge with ASCII Conversion
 * Description: Write a Java program that takes an unsorted array of digits and a series of integers. 
 * It encodes the highest digits, based on the provided series, into their corresponding ASCII characters.
 * Example:
 * Input: Array: [2, 3, 1, 5], Series: [1, 2, 3]
 * Output: "535150"
 * Explanation: The three highest numbers 5, 3, 2 are converted to ASCII characters.
 * Author: Ritika suman
 * Date: 09 September 2024
 */
import java.util.Arrays;
import java.util.Scanner;

public class EncodingChallenge {

    /**
     * Encodes the input array to ASCII values based on the given series.
     * array : The input array of integers.
     * series : The series of indices used for encoding.
     * return A string representing the ASCII values of the encoded characters.
     */
    public static String encodeToAscii(int[] array, int[] series) {
        Arrays.sort(array);
        int n = array.length;
        String result = "";

        for (int i = 0; i < series.length; i++) {
            int index = n - series[i];
            if (index >= 0 && index < n) {
                char encodedChar = (char) ('0' + array[index]);
                result += (int) encodedChar + " ";
            } else {
                result += " ";
            }
        }

        if (result.length() > 0 && result.charAt(result.length() - 1) == ' ') {
            result = result.substring(0, result.length() - 1);
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(Constants.ENTER_NUMBER_PROMPT);
        int arraySize = scanner.nextInt();

        int[] array = new int[arraySize];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < arraySize; i++) {
            array[i] = scanner.nextInt();
        }
        System.out.print("Enter the number of elements in the series: ");
        int seriesSize = scanner.nextInt();
        int[] series = new int[seriesSize];
        System.out.println("Enter the elements of the series:");
        for (int i = 0; i < seriesSize; i++) {
            series[i] = scanner.nextInt();
        }

        String encodedString = encodeToAscii(array, series);

        System.out.println(Constants.ENCODED_STRING_MESSAGE + encodedString);

        scanner.close();
    }
}
