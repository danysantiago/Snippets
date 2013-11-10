
public class EPI_5dot5 {

	public static void main(String[] args) {
		char[] set = {'A', 'B', 'C'};
		superSet(set);
	}
	
	public static void superSet(char[] set) {
		int words = 1 << set.length;
		for(int i = 0; i < words; i++) {
			StringBuilder sb = new StringBuilder("{");
			for(int j = 0; j < set.length; j++) {
				if((i & (1 << j)) > 0) {
					sb.append(set[j] + ",");
				}
			}
			
			if(sb.length() > 1)
				sb.setCharAt(sb.length()-1, '}');
			else 
				sb.append('}');
			System.out.println(sb.toString());
		}
	}

}
