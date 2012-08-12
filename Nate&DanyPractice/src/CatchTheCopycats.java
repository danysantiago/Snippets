import java.util.ArrayList;
import java.util.Scanner;


public class CatchTheCopycats {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int sourceSize1;
		ArrayList<String> sourceCode1 = new ArrayList<String>();
		int sourceSize2;
		ArrayList<String> sourceCode2 = new ArrayList<String>();
		
		sourceSize1 = in.nextInt();
		in.nextLine();
		for(int i=0; i<sourceSize1; i++){
			sourceCode1.add(in.nextLine());
		}
		
		sourceSize2 = in.nextInt();
		in.nextLine();
		for(int i=0; i<sourceSize2; i++){
			sourceCode2.add(in.nextLine());
		}
		
		trimCode(sourceCode1);
		trimCode(sourceCode2);
		
		if(compareSources(sourceCode1, sourceCode2)){
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}

	}

	private static void trimCode(ArrayList<String> code) {
		
		for(int i=0; i < code.size(); i++){
			code.set(i, code.get(i).split("[//]")[0]);
			code.set(i, code.get(i).trim());
		}
		
		for(int i=0; i < code.size(); i++){
			if(code.get(i).isEmpty()){
				code.remove(i);
				i--;
			}
		}
		
	}
	
	private static boolean compareSources(ArrayList<String> sourceCode1, ArrayList<String> sourceCode2) {
		if(sourceCode1.size() != sourceCode2.size())
			return false;
		for(int i=0; i < sourceCode1.size(); i++){
			if(!sourceCode1.get(i).equals(sourceCode2.get(i)))
				return false;
		}
		return true;
	}

}
