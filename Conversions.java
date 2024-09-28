/***
 * Problem Statement : Conversions  and mathematical operations of number systems.
 * Owner name : Ritika suman
 * Date of Creation : 24-09-24 - 26-09-24
 */


import java.util.Scanner;

public class Conversions {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println(Constant.Choice);

            String mainChoice = scanner.nextLine();

            switch (mainChoice) {
                case "1":
                    runConversionOperations(scanner);
                    break;
                case "2":
                    runMathOperations(scanner);
                    break;
                default:
                    System.out.println(Constant.InvalidFormat);
                    break;
            }
        }
    }

    // Method to handle Conversion operations
    public static void runConversionOperations(Scanner scanner) {
        System.out.println(Constant.Options);
        while (true) {
            System.out.print(Constant.Choose);
            String operation = scanner.nextLine();
            switch (operation) {
                case "1":
                    System.out.print(Constant.Decimal);
                    String input = scanner.nextLine();
                    try {
                        int decimal = Integer.parseInt(input);
                        if (decimal < 0) {
                            System.out.println(Constant.Negative);
                        }
                        else {
                            System.out.println(Constant.binary + Decimal.decimalToBinary(decimal));
                        }
                    }
                    catch (NumberFormatException exception) {
                        System.out.println(Constant.InvalidFormat);
                    }
                    break;
                case "2":
                    System.out.print(Constant.Decimal);
                    String decimalInput = scanner.nextLine();
                    try {
                        int decimal = Integer.parseInt(decimalInput);
                        if (decimal < 0) {
                            System.out.println(Constant.Negative);
                        }
                        else {
                            System.out.println(Constant.hexadecimal + Decimal.decimalToHexadecimal(decimal));
                        }
                    }
                    catch (NumberFormatException exception) {
                        System.out.println(Constant.InvalidFormat);
                    }
                    break;
                case "3":
                    System.out.print(Constant.Decimal);
                    String userInput = scanner.nextLine();
                    try {
                        int decimal = Integer.parseInt(userInput);
                        if (decimal < 0) {
                            System.out.println(Constant.Negative);
                        }
                        else {
                            System.out.println("Decimal to Octal: " + Decimal.decimalToOctal(decimal));
                        }
                    }
                    catch (NumberFormatException exception) {
                        System.out.println(Constant.InvalidFormat);
                    }
                    break;
                case "4":
                    System.out.print(Constant.Binary);
                    String binary = scanner.nextLine();
                    try {
                        System.out.println(Constant.decimal + Binary.binaryToDecimal(binary));
                    }
                    catch (Exception exception) {
                        System.out.println(Constant.InvalidFormat);
                    }
                    break;
                case "5":
                    System.out.print(Constant.Binary);
                    String binaryInput = scanner.nextLine();
                    try {
                        System.out.println(Constant.octadecimal + Binary.binaryToOctal(binaryInput));
                    }
                    catch (Exception exception) {
                        System.out.println(Constant.InvalidFormat);
                    }
                    break;
                case "6":
                    System.out.print(Constant.Binary);
                    String binaryDigit = scanner.nextLine();
                    try {
                        System.out.println(Constant.hexadecimal + Binary.binaryToHexadecimal(binaryDigit));
                    }
                    catch (Exception exception) {
                        System.out.println(Constant.InvalidFormat);
                    }
                    break;
                case "7":
                    System.out.print(Constant.Octal);
                    String octal = scanner.nextLine();
                    try {
                        System.out.println(Constant.decimal + Octal.octalToDecimal(octal));
                    }
                    catch (Exception exception) {
                        System.out.println(Constant.InvalidFormat);
                    }
                    break;
                case "8":
                    System.out.print(Constant.Octal);
                    String octalDigit = scanner.nextLine();
                    try {
                        System.out.println(Constant.binary + Octal.octalToBinary(octalDigit));
                    }
                    catch (Exception exception) {
                        System.out.println(Constant.InvalidFormat);
                    }
                    break;
                case "9":
                    System.out.print(Constant.Octal);
                    String octalInput = scanner.nextLine();
                    try {
                        System.out.println(Constant.hexadecimal + Octal.octalToHexadecimal(octalInput));
                    }
                    catch (Exception exception) {
                        System.out.println(Constant.InvalidFormat);
                    }
                    break;
                case "10":
                    System.out.print(Constant.Hexadecimal);
                    String digit = scanner.nextLine();
                    try {
                        System.out.println(Constant.decimal + Hexadecimal.hexadecimalToDecimal(digit));
                    }
                    catch (Exception exception) {
                        System.out.println(Constant.InvalidFormat);
                    }
                    break;
                case "11":
                    System.out.print(Constant.Hexadecimal);
                    String hexInput = scanner.nextLine();
                    try {
                        System.out.println(Constant.binary + Hexadecimal.hexadecimalToBinary(hexInput));
                    }
                    catch (Exception exception) {
                        System.out.println(Constant.InvalidFormat);
                    }
                    break;
                case "12":
                    System.out.print(Constant.Hexadecimal);
                    String hexDigit = scanner.nextLine();
                    try {
                        System.out.println(Constant.octadecimal + Hexadecimal.hexadecimalToOctal(hexDigit));
                    }
                    catch (Exception exception) {
                        System.out.println(Constant.InvalidFormat);
                    }
                    break;
                default:
                    System.out.println(Constant.Invalid);
                    break;
            }

            System.out.print(Constant.YesOrNoMessage);
            String constant = scanner.nextLine();
            if (!constant.equalsIgnoreCase("yes")) {
                System.out.println("Exiting conversion operations...");
                break;
            }
        }
    }

    public static void runMathOperations(Scanner scanner) {
        System.out.println(Constant.Operations);

        while (true) {
            System.out.print(Constant.Mathematical);
            String operation = scanner.nextLine();

            try {
                switch (operation) {
                    case "1":
                        Addition.addition();
                        break;
                    case "2":
                        Subtraction.subtraction();
                        break;
                    default:
                        System.out.println(Constant.InvalidFormat);
                        break;
                }
            }
            catch (NumberFormatException exception) {
                System.out.println(Constant.InvalidFormat);
            }

            System.out.print(Constant.YesOrNoMessage);
            String choice = scanner.nextLine();
            if (!choice.equalsIgnoreCase("yes")) {
                System.out.println("Exiting mathematical operations...");
                break;
            }
        }
    }
}