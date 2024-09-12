
import java.util.*;

public class Main {
    static public void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean validChoice = false;

        while (!validChoice) {
         System.out.println("Choose an option:");
         System.out.println("1. Binary to Decimal");
         System.out.println("2. Nth Fibonacci Number");
         System.out.println("3. Count Consonants in a String");
         System.out.println("4. Convert Snake case to Camel case");
         System.out.println("5. Count palindromes in a String");
         String choice = scan.nextLine();

         switch (choice) {
            case "1":
                System.out.println("Enter a binary string:");
                String binaryString = scan.nextLine();
                int binaryResult = Binary2Decimal(binaryString, 0);
                if (binaryResult == -1) {
                    System.out.println("Invalid Choice");
                } else {
                    System.out.println("Decimal Value: " + binaryResult);
                }
                break;
            
            case "2":
                System.out.println("Enter the of Nth no. :");
                int GivenNo = scan.nextInt();
                long fibonacciResult = NthFibonacci(GivenNo);
                System.out.println("Fibonacci Number: " + fibonacciResult);
                break;

            case "3":
                System.out.println("Enter a string:");
                String userString = scan.nextLine();
                long consonantCount = CountConsonants(userString);
                System.out.println("Number of consonants: " + consonantCount);
                break;

            case "4":
                System.out.println("Enter a string:");
                String NewString = scan.nextLine();
                System.out.println("Output: " + convertToCamelCase(NewString, 0, "", false));
                break;

            case "5": 
                System.out.println("Enter a string:");
                String inputString = scan.nextLine();
                System.out.print("The No. of Palindrome are :");
                System.out.println(countPalindrome(inputString,0));
                break;
            
            default:
                System.out.println("Invalid option");
                break;
            }
        }
    }

    public static int Binary2Decimal(String BinaryString, int value) {
        int Length = BinaryString.length();
        if (Length == 0) {
            return value;
        }
        if (Character.getNumericValue(BinaryString.charAt(0)) == 1 || Character.getNumericValue(BinaryString.charAt(0)) == 0) {
            value = value + Character.getNumericValue(BinaryString.charAt(0)) * (int) Math.pow(2, Length - 1);
        } else {
            return -1;
        }
        return Binary2Decimal(BinaryString.substring(1), value);
    }

    public static long NthFibonacci(int position) {
        if (position == 0) {
            return 0;
        }
        if (position == 1) {
            return 1;
        }
        return NthFibonacci(position - 1) + NthFibonacci(position - 2);
    }

    public static long CountConsonants(String InputString) {
        return countConsonantsHelper(InputString, 0);
    }

    private static int countConsonantsHelper(String InputString, int index) {
     if (index == InputString.length()) {
      return 0;
    }
     char character = InputString.charAt(index);
     boolean isConsonant = (character >= 'a' && character <= 'z' || character >= 'A' && character <= 'Z') && 
                        character != 'a' && character != 'e' && character != 'i' && character != 'o' && character != 'u' &&
                        character != 'A' && character != 'E' && character != 'I' && character != 'O' && character != 'U';
     return (isConsonant ? 1 : 0) + countConsonantsHelper(InputString, index + 1);
    }

    private static String convertToCamelCase(String InputString, int index, String result, boolean capitalize) {
        if (index == InputString.length()) return result;
        char character = InputString.charAt(index);
        if ((character >= 'A' && character <= 'Z') || (character >= 'a' && character <= 'z') || character == ' ' || character == '_') {
            character = (character >= 'A' && character <= 'Z') ? (char) (character + 32) : character; 
            if (character == ' ' || character == '_') {
                return convertToCamelCase(InputString, index + 1, result, true);
            }
            result += capitalize ? (char) (character - 32) : character; 
            return convertToCamelCase(InputString, index + 1, result, false);
        }
        return convertToCamelCase(InputString, index + 1, result, capitalize); 
    }

    public static int countPalindrome(String InputString , int count) {
        if(InputString.length() == 1){
            return count + 1;
        }
        if (InputString.isBlank()) {
            return count ;
        }
        if (isValidPalindrome(InputString)){
                count++;
            }
        if(InputString.charAt(0) == InputString.charAt(InputString.length()-1)){
                count++;
        }
        else{
                count = count + 2;
            }
        return countPalindrome(InputString.substring(1,InputString.length()-1),count);
        }
        public static boolean isValidPalindrome(String s){

        if(s.isEmpty() || s.length() == 1){
            return true;
        }
            if(s.charAt(0) == s.charAt(s.length()-1)){
                return isValidPalindrome(s.substring(1,s.length()-1));
            }
            else{
                return false;
            }
    }
}










