/***
 * Hexadecimal code of the main function.
 * Owner name : Ritika suman
 * Date of Creation : 24-09-24 - 26-09-24
 */

public class Hexadecimal {

    //Method hexadecimal to decimal
    public static int hexadecimalToDecimal(String hexadecimal){
        if(hexadecimal.equals("0")){
            return 0;
        }
        int decimal = 0;
        for(int i = 0;i < hexadecimal.length();i++){
            int value = 0;
            char hexCharacter = hexadecimal.charAt(i);
            if (hexCharacter >= '0' && hexCharacter <= '9') {
                value = hexCharacter - '0';
            }
            else if (hexCharacter >= 'A' && hexCharacter <= 'F') {
                value = 10 + (hexCharacter - 'A');
            }
            else if (hexCharacter >= 'a' && hexCharacter <= 'f') {
                value = 10 + (hexCharacter - 'a');
            }
            else {
                System.out.println( "Invalid hexadecimal character.");
                return 0;
            }
            decimal = 16 * decimal + value;
        }
        return decimal;
    }

    //Method Hexadecimal to binary
    public static int hexadecimalToBinary(String hexInput){
        int binary = hexadecimalToDecimal(hexInput);
        return Integer.parseInt(Decimal.decimalToBinary(binary));
    }

    //Method Hexadecimal to octal
    public static int hexadecimalToOctal(String hexDigit){
        int octal = hexadecimalToDecimal(hexDigit);
        return Integer.parseInt(Decimal.decimalToOctal(octal));
    }
}