/***
 * Decimal code of main function.
 * Owner name :Ritika suman
 * Date of Creation : 24-09-24 - 26-09-24
 */

public class Decimal {

    //Method Decimal to Octal
    public static String decimalToOctal(int decimal){
        if (decimal < 0) {
            return Constant.InvalidFormat;
        }

        if (decimal == 0) {
            return "0";
        }
        String binary = "";
      while(decimal > 0) {
          int remainder = decimal % 8;
          binary = remainder + binary;
          decimal /= 8;
      }
        return binary;
    }

    //Method Decimal to Binary
    public static String decimalToBinary(int input){
        if (input < 0) {
            return Constant.InvalidFormat;
        }

        if (input == 0) {
            return "0";
        }
        String binary = "";
        while (input > 0){
            int remainder = input % 2;
            binary = remainder + binary;
            input /= 2;
        }
        return binary;
    }

    //Method Decimal to Hexadecimal
    public static String decimalToHexadecimal(int Decimal){
        if (Decimal < 0) {
            return Constant.InvalidFormat;
        }

        if (Decimal == 0) {
            return "0";
        }
        String binary = "";
        while (Decimal > 0){
            int remainder = Decimal % 16;
            if(remainder < 10){
                binary = remainder + binary;
            }
            else{
                binary = (char)('A' + (remainder - 10)) + binary;
            }
            Decimal /= 16;
        }
        return binary;
    }
}