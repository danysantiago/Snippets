
public class multiplicationTable {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		printTable(12);
	}

	private static void printTable(int n) {
		int i;
		int j;
		for(i = 1; i <= n; i++){
			for(j = 1; j <= n; j++)
				System.out.print(String.format("%4d",i*j));
			System.out.println();
		}
		
	}

}
