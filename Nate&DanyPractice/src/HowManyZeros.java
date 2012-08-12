import java.math.BigInteger;
import java.util.Scanner;


public class HowManyZeros {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int b = in.nextInt();
		System.out.println(n + "! at base " + b + " =\n" + factorial(n).toString(b));
		System.out.println("trailing zeros: " + countZeros(factorial(n).toString(b)));
		
		
	}
	
	public static BigInteger factorial(int n){
		BigInteger num = BigInteger.ONE;
		for(int i = 1; i <= n; i++){
			num = num.multiply(BigInteger.valueOf(i));
		}
		return num;
	}
	
	public static int countZeros(String snum){
		int sum = 0;
		int index = snum.length();
		while(snum.charAt(index - 1) == '0'){
			sum++;
			index = index - 1;
		}
		
		return sum;
	}

}
