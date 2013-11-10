import java.util.HashMap;


public class EPI_6dot22 {

	public static void main(String[] args) {
		HashMap<Integer,String> keyMap = new HashMap<Integer, String>();
		keyMap.put(1, "");
		keyMap.put(2, "ABC");
		keyMap.put(3, "DEF");
		keyMap.put(4, "GHI");
		keyMap.put(5, "JKL");
		keyMap.put(6, "MNO");
		keyMap.put(7, "PQRS");
		keyMap.put(8, "TUV");
		keyMap.put(9, "WXYZ");

		printPossibleWords(keyMap, "2276696");
	}

	private static void printPossibleWords(HashMap<Integer, String> keyMap, String string) {
		String word = "";
		
		printWord(keyMap, string, 0, word);
	}

	private static void printWord(HashMap<Integer, String> keyMap, String string, int i, String word) {
		if(i == string.length()) {
			System.out.println(word);
			return;
		}
		
		String letters = keyMap.get(string.charAt(i) - '0');
		for(int j = 0; j < letters.length(); j++) {
			printWord(keyMap, string, i+1, word + letters.charAt(j));
		}
		
		
	}

}
