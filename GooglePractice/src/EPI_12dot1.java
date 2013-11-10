
public class EPI_12dot1 {

	public static void main(String[] args) {
		System.out.println(hashFunction("Dan", 5));
		System.out.println(hashFunction("naD", 5));

	}
	
	public static int hashFunction(String word, int mod) {
		int MULT = 997;
		int hashcode = 0;
		
		for(int i = 0; i < word.length(); i++) {
			hashcode = (hashcode * 997 + word.charAt(i)) % mod;
		}
		
		return hashcode;
	}

}
