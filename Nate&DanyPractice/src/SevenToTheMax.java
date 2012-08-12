import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;


public class SevenToTheMax {


	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		String expression1 = in.nextLine();
		String expression2 = in.nextLine();
		
		
		if(!validateInput(expression1) || !validateInput(expression2)){
			System.out.println("INVALID");
			System.exit(0);
		}
		
		int comp = calcExpression(expression1).compareTo(calcExpression(expression2));
		if(comp == 0){
			System.out.println("EQUAL");
		} else if(comp > 0){
			System.out.println("FIRST");
		} else {
			System.out.println("SECOND");
		}

	}
	
	public static boolean validateInput(String s){
		String sParts[];
		
		if(s.length() < 2 || s.length() > 10)
			return false;
		
		if(s.charAt(0) != '7' || s.charAt(s.length() - 1) != '7')
			return false;
		
		sParts = s.split("7");
		for(int i=1; i < sParts.length;i++)
			if(!sParts[i].matches("[\\^\\*\\+]"))
				return false;
		
		sParts = s.split("[\\^\\*\\+]");
		for(int i=1; i < sParts.length;i++)
			if(!sParts[i].matches("7"))
				return false;
		
		return true;
		
	}
	
	public static BigInteger calcExpression(String s){
		BigInteger num;
		
		ArrayList<String> sParts = new ArrayList<String>();
		for(int  i=0; i<s.length(); i++)
			sParts.add("" + s.charAt(i));
		
		for(int  i=0; i<sParts.size(); i++){
			if(sParts.get(i).equals("^")){
				num = new BigInteger(sParts.get(i-1));
				num = num.pow(Integer.parseInt(sParts.get(i+1)));
				sParts.remove(i+1);
				sParts.remove(i);
				sParts.set(i-1, num.toString());
				i=0;
			}	
		}
		
		for(int  i=0; i<sParts.size(); i++){
			if(sParts.get(i).equals("*")){
				num = new BigInteger(sParts.get(i-1));
				num = num.multiply(new BigInteger(sParts.get(i+1)));
				sParts.remove(i+1);
				sParts.remove(i);
				sParts.set(i-1, num.toString());
				i=0;
			}	
		}
		
		for(int  i=0; i<sParts.size(); i++){
			if(sParts.get(i).equals("+")){
				num = new BigInteger(sParts.get(i-1));
				num = num.add(new BigInteger(sParts.get(i+1)));
				sParts.remove(i+1);
				sParts.remove(i);
				sParts.set(i-1, num.toString());
				i=0;
			}	
		}
		
		return new BigInteger(sParts.get(0));
	}
	
}
