/***
 * Binary code of main function.
 * Owner name : Ritika suman
 * Date of Creation : 24-09-24 - 26-09-24
 */

public class Binary {

    //Method Binary to Decimal
    public static int binaryToDecimal(String binary) {
        int decimal = 0;
        for (int i = 0; i < binary.length(); i++) {
            char currentCharacter = binary.charAt(i);
            if (currentCharacter == '0' || currentCharacter == '1') {
                int value = binary.charAt(i) - '0';
                decimal = 2 * decimal + value;
            }
            else {
                System.out.println(Constant.InvalidFormat);
                return 0;
            }
        }
        return decimal;
    }

    //Method Binary to Octal
    public static int binaryToOctal(String binaryInput){
        int decimal = binaryToDecimal(binaryInput);
        if (decimal == -1) {
            System.out.println(Constant.InvalidFormat);
            return -1;
        }
            return Integer.parseInt(Decimal.decimalToOctal(decimal));
    }

    //Method Decimal to Hexadecimal
    public static String binaryToHexadecimal(String binaryDigit){
        int binary = binaryToDecimal(binaryDigit);
        if (binary == -1) {
            System.out.println(Constant.InvalidFormat);
            return "-1";
        }
        return Decimal.decimalToHexadecimal(binary);
    }
}