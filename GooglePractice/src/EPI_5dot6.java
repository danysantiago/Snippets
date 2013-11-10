
public class EPI_5dot6 {

	public static void main(String[] args) {
		System.out.println(toInteger("123"));
		System.out.println(toInteger("-123"));
		//System.out.println(toInteger("123z!"));
		System.out.println(mtoString(123));
		System.out.println(mtoString(-123));
	}
	
	public static int toInteger(String s) {
		boolean isNegative = s.charAt(0) == '-';
		int num = 0;
		
		int i = isNegative ? 1 : 0;
		for(; i < s.length(); i++) {
			int digit = s.charAt(i) - '0';
			if(digit < 0 || digit > 9) {
				throw new NumberFormatException("Invalid digit " + s.charAt(i));
			} else {
				num += digit;
				if(i < s.length()-1) {
					num = num*10;
				}
			}
		}
		
		if(isNegative) {
			num = num*-1;
		}
		
		return num;
	}
	
	public static String mtoString(int n) {
		String s = "";
		boolean isNegative = n < 0;
		
		if(isNegative) {
			n = n*-1;
		}
		
		while(n > 0) {
			s = n % 10 + s;
			n = n / 10;
		}
		
		if(isNegative) {
			s = "-" + s;
		}
		
		return s;
	}

}
