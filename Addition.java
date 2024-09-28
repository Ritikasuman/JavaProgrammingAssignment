/***
 * Addition code of main function.
 * Owner name : Ritika suman
 * Date of Creation : 24-09-24 - 26-09-24
 */

import java.util.Scanner;

public class Addition {
    private static final Scanner scanner = new Scanner(System.in);

    public static void addition() {
        while (true) {
            System.out.println(Constant.AdditionOperation);

            System.out.print(Constant.FirstNumber);
            String firstInput = scanner.nextLine();
            System.out.print(Constant.firstNumber);
            String firstFormat = scanner.nextLine().toLowerCase();


            System.out.print(Constant.SecondNumber);
            String secondInput = scanner.nextLine();
            System.out.print(Constant.secondNumber);
            String secondFormat = scanner.nextLine().toLowerCase();


            int firstDecimal = convertToDecimal(firstInput, firstFormat);
            int secondDecimal = convertToDecimal(secondInput, secondFormat);

            if (firstDecimal == -1 || secondDecimal == -1) {
                System.out.println(Constant.InvalidFormat);
                continue;
            }

            int result = firstDecimal + secondDecimal;
            System.out.println("Addition result in decimal: " + result);


            System.out.print(Constant.Format);
            String outputFormat = scanner.nextLine().toLowerCase();

            String formattedResult = convertFromDecimal(result, outputFormat);
            if (formattedResult.equals("Invalid")) {
                System.out.println("Invalid output format.");
            } else {
                System.out.println("Result in " + outputFormat + ": " + formattedResult);
            }

            System.out.print(Constant.YesOrNoMessage);
            String choice = scanner.nextLine();
            if (!choice.equalsIgnoreCase("yes")) {
                System.out.println("Exiting...");
                break;
            }
        }
    }

    // Convert the input to decimal based on its format
    public static int convertToDecimal(String input, String format) {
        try {
            switch (format) {
                case "1":
                    return Integer.parseInt(input, 2);
                case "2":
                    return Integer.parseInt(input, 8);
                case "3":
                    return Integer.parseInt(input);
                case "4":
                    return Integer.parseInt(input, 16);
                default:
                    System.out.println(Constant.InvalidFormat);
                    return -1;
            }
        } catch (NumberFormatException exception) {
            System.out.println(Constant.InvalidFormat);
            return -1;
        }
    }

    // Convert the decimal result to the desired output format
    public static String convertFromDecimal(int decimal, String format) {
        switch (format) {
            case "1":
                return Integer.toBinaryString(decimal);
            case "2":
                return Integer.toOctalString(decimal);
            case "3":
                return Integer.toString(decimal);
            case "4":
                return Integer.toHexString(decimal).toUpperCase();
            default:
                return "Invalid";
        }
    }
}
