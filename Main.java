/**
 * Java program for multiple tasks: counting unique palindromes,
 * computing the nth Fibonacci number, converting snake_case to camelCase,
 * counting consonants, and converting binary to decimal. 
 * Author: Ritika suman | Date: 2024-09-12
 */
import java.util.*;
public class Main {
     public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean validChoice = false;

        while (!validChoice) {
            System.out.println(Constants.CHOOSE_OPTION_PROMPT);
            System.out.println(Constants.OPTION_BINARY_TO_DECIMAL);
            System.out.println(Constants.OPTION_NTH_FIBONACCI);
            System.out.println(Constants.OPTION_COUNT_CONSONANTS);
            System.out.println(Constants.OPTION_CONVERT_SNAKE_TO_CAMEL);
            System.out.println(Constants.OPTION_COUNT_PALINDROMES);

            try {
                String choice = scan.nextLine();

                switch (choice) {
                    case "1" -> {
                        System.out.println(Constants.BINARY_STRING_PROMPT);
                        String binaryString = scan.nextLine();
                        int binaryResult = Binary2Decimal(binaryString, 0);
                        if (binaryResult == -1) {
                            System.out.println(Constants.INVALID_CHOICE_MESSAGE);
                        } else {
                            System.out.println( Constants.DECIMAL_VALUE_MESSAGE+ binaryResult);
                        }
                    }

                    case "2" -> {
                        System.out.println(Constants.NTH_NUMBER_PROMPT);
                        int givenNo = scan.nextInt();
                        scan.nextLine(); 
                        long fibonacciResult = NthFibonacci(givenNo,1,1);
                        System.out.println(Constants.FIBONACCI_NUMBER_MESSAGE + fibonacciResult);
                    }

                    case "3" -> {
                        System.out.println(Constants.STRING_PROMPT);
                        String userString = scan.nextLine();
                        long consonantCount = CountConsonants(userString);
                        System.out.println(Constants.CONSONANT_COUNT_MESSAGE + consonantCount);
                    }

                    case "4" -> {
                        System.out.println(Constants.STRING_PROMPT);
                        String newString = scan.nextLine();
                        System.out.println(Constants.CONVERTED_OUTPUT_MESSAGE + convertToCamelCase(newString, 0, "", false));
                    }

                    case "5" -> {
                        System.out.println(Constants.STRING_PROMPT);
                        String inputString = scan.nextLine();
                        System.out.println(Constants.PALINDROME_COUNT_PROMPT + " " + countPalindrome(inputString, 0));
                    }

                    default -> System.out.println(Constants.INVALID_OPTION_MESSAGE);
                }
            } catch (Exception e) {
                System.out.println(Constants.INVALID_INPUT_MESSAGE);
                scan.nextLine(); 
            }
        }
    }
    /**
     * Converts a binary string to a decimal value.
     * input: binary string to convert.
     *        The accumulated decimal value.
     * output: decimal value or -1 if invalid binary.
     */
    public static int Binary2Decimal(String binaryString, int value) {
        int length = binaryString.length();
        if (length == 0) {
            return value;
        }
        if (Character.getNumericValue(binaryString.charAt(0)) == 1 || Character.getNumericValue(binaryString.charAt(0)) == 0) {
            value = value + Character.getNumericValue(binaryString.charAt(0)) * (int) Math.pow(2, length - 1);
        } else {
            return -1;
        }
        return Binary2Decimal(binaryString.substring(1), value);
    }

     /**
     * Calculates the Nth Fibonacci number 
     * input: position of the Fibonacci number 
     *        first number in the Fibonacci sequence
     *        second number in the Fibonacci sequence 
     * output: the Nth Fibonacci number.
     */
    public static long NthFibonacci(long count,long first,long second){
        {
            long third = first + second;
            first = second;
            second = third ;
            count-- ;
            if(count == 0){
                return third;
            }
            return NthFibonacci(count,first,second);
        }
    }

    /**
     * Counts the number of consonants in a string.
     * input: The string to check.
     * output:The number of consonants.
     */
    public static long CountConsonants(String inputString) {
        return countConsonantsHelper(inputString, 0);
    }

    /**
     * Helper method to count consonants recursively.
     * input: The string to check.
     *        current index in the string.
     * output: number of consonants from the current index onwards.
     */
    private static int countConsonantsHelper(String inputString, int index) {
        if (index == inputString.length()) {
            return 0;
        }
        char character = inputString.charAt(index);
        boolean isConsonant = (character >= 'a' && character <= 'z' || character >= 'A' && character <= 'Z') &&
                character != 'a' && character != 'e' && character != 'i' && character != 'o' && character != 'u' &&
                character != 'A' && character != 'E' && character != 'I' && character != 'O' && character != 'U';
        return (isConsonant ? 1 : 0) + countConsonantsHelper(inputString, index + 1);
    }

    /**
     * Converts a snake_case or space-separated string to camelCase.
     * input: string in snake_case or space-separated.
     *        The current index in the string.
     *        The accumulated result.
     *        Whether to capitalize the next character.
     * output: The string in camelCase.
     */
    private static String convertToCamelCase(String inputString, int index, String result, boolean capitalize) {
        if (index == inputString.length()) return result;
        char character = inputString.charAt(index);
        if ((character >= 'A' && character <= 'Z') || (character >= 'a' && character <= 'z') || character == ' ' || character == '_') {
            character = (character >= 'A' && character <= 'Z') ? (char) (character + 32) : character;
            if (character == ' ' || character == '_') {
                return convertToCamelCase(inputString, index + 1, result, true);
            }
            result += capitalize ? (char) (character - 32) : character;
            return convertToCamelCase(inputString, index + 1, result, false);
        }
        return convertToCamelCase(inputString, index + 1, result, capitalize);
    }

    /**
     * Counts the number of palindromes in a string.
     * imput: The string to check.
     *        The current count of palindromes.
     * output:The total number of palindromes.
     */
    public static int countPalindrome(String inputString, int count) {
        if (inputString.length() == 1) {
            return count + 1;
        }
        if (inputString.isBlank()) {
            return count;
        }
        if (isValidPalindrome(inputString)) {
            count++;
        }
        if (inputString.charAt(0) == inputString.charAt(inputString.length() - 1)) {
            count++;
        } else {
            count = count + 2;
        }
        return countPalindrome(inputString.substring(1, inputString.length() - 1), count);
    }

    /**
     * Checks if a string is a valid palindrome.
     * input : The string to check.
     * output : True if the string is a palindrome, otherwise false.
     */
    public static boolean isValidPalindrome(String GivenString) {
        if (GivenString.isEmpty() || GivenString.length() == 1) {
            return true;
        }
        if (GivenString.charAt(0) == GivenString.charAt(GivenString.length() - 1)) {
            return isValidPalindrome(GivenString.substring(1, GivenString.length() - 1));
        } else {
            return false;
        }
    }
}
