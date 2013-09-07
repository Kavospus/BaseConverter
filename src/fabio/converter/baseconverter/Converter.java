package fabio.converter.baseconverter;

public class Converter {
	
	public String decimalToBinary(int number) {
		return this.decimalToBaseN(number, 2);
	}
	
	public String decimalToOctal(int number) {
		return this.decimalToBaseN(number, 8);
	}
	
	public String decimalToHex(int number) {
		String result = new String();
		int remainder;
		
		while(number > 0) {
			remainder = number%16;
			
			result += this.numberValueInHex(remainder);
			number /=  16;
		}
		
		return this.reverseString(result);
	}
	
	public int binaryToDecimal(int number) {
		String value = new String(Integer.toString(number));
		value = this.reverseString(value);
		
		int result = 0;
		
		for(int i = 0; i < value.length(); i++) {
			result += Character.getNumericValue(value.charAt(i)) * Math.pow(2, i);
		}
		
		return result;
	}
	
	
	
	private String reverseString(String value) {
		String result = new String();
		
		for(int i = value.length()-1; i >= 0; i--)
			result += value.charAt(i);
		
		return result;
	}
	
	private String decimalToBaseN(int decimalNumber, int base) {
		if(base < 2)
			return "-1";
		
		String result = new String();
		
		while(decimalNumber > 0) {
			result += Integer.toString(decimalNumber%base);
			decimalNumber /=  base;
		}
		
		return this.reverseString(result);
	}
	
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
}
