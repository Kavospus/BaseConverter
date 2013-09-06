package fabio.converter.baseconverter;

public class Converter {
	
	public int decimalToBinary(int number) {
		String result = new String();
		
		while( number > 0 ) {
			result += Integer.toString(number%2);
			number /=  2;
		}
		
		return Integer.valueOf(this.reverseString(result));
	}
	
	public int binaryToDecimal(int number) {
		String value = new String(Integer.toString(number));
		value = this.reverseString(value);
		
		int result = 0;
		
		for(int i = 0; i < value.length(); i++) {
			System.out.println(Math.pow(2, i));
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
}
