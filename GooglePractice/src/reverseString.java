
public class reverseString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(reverseString("Daniel Santiago"));

	}

	private static String reverseString(String s) {
		String str = "";
		for(int i = s.length() - 1; i >= 0; i--){
			str = str + s.charAt(i);
		}
		return str;
	}

}
