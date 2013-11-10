public class ArraysStrings {

	public static void main(String[] args) {
		System.out.println(uniqueString("ab c !~"));
		System.out.println(isRotation("waterbottle", "erbottlewat"));
		System.out.println(isRotation("waterbottle", "erbotlewat"));

	}

	/**
	 * 1.1 Implement an algorithm to determine if a string has all unique
	 * characters. What if you can not use additional data structures?
	 */
	public static boolean uniqueString(String s) {
		boolean[] map = new boolean[126 - 32 + 1];
		for (int i = 0; i < s.length(); i++) {
			if (map[s.charAt(i) - 32]) {
				return false;
			} else {
				if (s.charAt(i) != ' ')
					map[s.charAt(i) - 32] = true;
			}
		}
		return true;

	}

	/**
	 * 1.8 Assume you have a method isSubstring which checks if one word is a
	 * substring of another. Given two strings, s1 and s2, write code to check
	 * if s2 is a rotation of s1 using only one call to isSubstring (i.e.,
	 * “waterbottle” is a rotation of “erbottlewat”).
	 */
	public static boolean isRotation(String s1, String s2) {
		if (s1.length() == s2.length()) {
			s1 += s1;
			return isSubtring(s1, s2);
		} else {
			return false;
		}
	}

	private static boolean isSubtring(String s1, String s2) {
		return s1.contains(s2);
	}

}
