import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("Main Menu");
            System.out.println("1. Run Caesar Cipher");
            System.out.println("2. Run Combination Generator");
            System.out.println("3. Run Consecutive Number Summer");
            System.out.println("4. Run Digit Sum Loop");
            System.out.println("5. Run Encoding Challenge");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    CaesarCipher.main(new String[]{}); 
                    break;
                case 2:
                    CombinationGenerator.main(new String[]{}); 
                    break;
                case 3:
                    ConsecutiveSum.main(new String[]{}); 
                    break;
                case 4:
                    DigitSumLoop.main(new String[]{}); 
                    break;
                case 5:
                    EncodingChallenge.main(new String[]{}); 
                    break;
                case 6:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice! Please select a valid option.");
            }
        }

        scanner.close();
        System.out.println("Exiting.....");
    }
}
