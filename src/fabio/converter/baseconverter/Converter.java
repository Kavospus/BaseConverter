package fabio.converter.baseconverter;

public class Converter {

    // Convert decimal to binary
    public String decimalToBinary(long number) {
        return Long.toBinaryString(number);
    }

    // Convert decimal to octal
    public String decimalToOctal(long number) {
        return Long.toOctalString(number);
    }

    // Convert decimal to hexadecimal
    public String decimalToHex(long number) {
        return Long.toHexString(number);

    }


    // Convert binary to decimal
    public long binaryToDecimal(long number) {
        return this.baseNToDecimal(number, 2);
    }

    // Convert octal to decimal
    public long octalToDecimal(long number) {
        return this.baseNToDecimal(number, 8);
    }

    // Convert hexadecimal to decimal
    public long hexToDecimal(String value) {
        value = this.reverseString(value);
        long result = 0;
        int number;

        for(int i = 0; i < value.length(); i++) {
            number = this.hexCharValueInNumber(value.charAt(i));
            result += number * Math.pow(16, i);
        }

        return result;
    }


    // Reverse a string
    private String reverseString(String value) {
        String result = new String();

        for(int i = value.length()-1; i >= 0; i--)
            result += value.charAt(i);

        return result;
    }

    // Convert N base to decimal
    private long baseNToDecimal(long number, int base) {
        String value = new String(Long.toString(number));
        value = this.reverseString(value);

        long result = 0;

        for(int i = 0; i < value.length(); i++) {
            result += Character.getNumericValue(value.charAt(i)) * Math.pow(base, i);
        }

        return result;
    }

    // Convert decimal to N base up to 10
    private int decimalToBaseN(long decimalNumber, int base) {
        String result = new String();

        while(decimalNumber > 0) {
            result += Long.toString(decimalNumber%base);
            decimalNumber /=  base;
        }
        result = this.reverseString(result);

        return Integer.valueOf(result);
    }

    // Get the hexadecimal of a number
    private String numberValueInHex(int number) {
        String result = "";

        if(number >= 0 && number <= 9)
            result = Integer.toString(number);
        else if(number > 15)
            result = "Er";
        else
            switch(number) {
                case 10: result = "A"; break;
                case 11: result = "B"; break;
                case 12: result = "C"; break;
                case 13: result = "D"; break;
                case 14: result = "E"; break;
                case 15: result = "F"; break;
            }

        return result;
    }

    // Get the number value of a hexadecimal character value
    private int hexCharValueInNumber(char value) {
        int result = 0;

        if( Character.isDigit(value) )
            result = Character.getNumericValue(value);
        else
            switch(value) {
                case 'A': result = 10; break;
                case 'a': result = 10; break;
                case 'B': result = 11; break;
                case 'b': result = 11; break;
                case 'C': result = 12; break;
                case 'c': result = 12; break;
                case 'D': result = 13; break;
                case 'd': result = 13; break;
                case 'E': result = 14; break;
                case 'e': result = 14; break;
                case 'F': result = 15; break;
                case 'f': result = 15; break;
            }

        return result;
    }
}
