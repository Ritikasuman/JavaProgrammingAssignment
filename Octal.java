/***
 * Octal code of main function.
 * Owner name : Ritika suman
 * Date of Creation : 24-09-24 - 26-09-24
 */

public class Octal {

    //Method Octal to decimal
    public static int octalToDecimal(String octal){
        for (int i = 0; i < octal.length(); i++) {
            char currentCharacter = octal.charAt(i);
            if (currentCharacter < '0' || currentCharacter > '7') {
                System.out.println(Constant.InvalidFormat);
                return -1;
            }
        }
       if(octal.equals("0")){
        return 0;
       }
       int decimal = 0;
       for(int i = 0;i < octal.length();i++){
           int value = octal.charAt(i) - '0';
           decimal = 8 * decimal + value;
       }
       return decimal;
    }

    //Method Octal to binary
    public static String octalToBinary(String octalDigit){
         int digit = octalToDecimal(octalDigit);
        return Decimal.decimalToBinary(digit);
    }

    //Method Octal to Hexadecimal
    public static String octalToHexadecimal(String octalInput){
         int value = octalToDecimal(octalInput);
        return Decimal.decimalToHexadecimal(value);
    }
}