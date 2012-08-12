
public class nthFibonacci {
	
	private static final int NFIB = 45;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		long startTime = System.nanoTime();
		
		for ( int i = 0; i < NFIB; i++ ) {
            System.out.print ( nthFib(i) + ", " );
        }
        System.out.println ( nthFib(NFIB) );
        System.out.println(System.nanoTime() - startTime);
        
        startTime = System.nanoTime();
		
		for ( int i = 0; i < NFIB; i++ ) {
            System.out.print ( nthFibFormula(i) + ", " );
        }
        System.out.println ( nthFibFormula(NFIB) );
        System.out.println(System.nanoTime() - startTime);

	}

	private static int nthFib(int n) {
		if(n == 0)
			return 0;
		else if (n == 1)
			return 1;
		else
			return nthFib(n - 2) + nthFib(n - 1);
	}
	
	private static int nthFibFormula(int n) {
		double leftSide = (1+Math.sqrt(5))/2;
		double rightSide = (1-Math.sqrt(5))/2;
		leftSide = Math.pow(leftSide, n);
		rightSide = Math.pow(rightSide, n);
		
		return (int) ((1/Math.sqrt(5))*(leftSide - rightSide));
				
		
	}

}
