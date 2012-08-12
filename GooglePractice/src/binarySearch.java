
public class binarySearch {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] array = {1, 3, 6, 8, 11, 13, 13, 14, 16, 18, 20};
		//System.out.println(iterBinarySearch(array, 3));
		for(int i = -3; i < 25; i++){
			int a = recSearch(array, i);
			if(a != -1)
				System.out.println(i + " found at: " + a);
			else
				System.out.println(i + " was not found.");
		}

	}

	public static int recSearch(int[] array, int i) {
		return recBinarySearch(array, i, 0, array.length - 1);
	}
	
	private static int recBinarySearch(int[] array, int n, int start, int end){
		int curlenght = end - start;
		int midIndex = (start + end)/2;
		if(curlenght == -1)
			return -1;
		if(array[midIndex] == n)
			return midIndex;
		else if(array[midIndex] > n)
			return recBinarySearch(array, n, start, midIndex - 1);
		else
			return recBinarySearch(array, n, midIndex + 1, end);
	}

	public static int iterBinarySearch(int[] array, int n) {
		int start = 0;
		int end = array.length - 1;
		int mid;
		do {
			mid = (start + end) / 2;
			if(start > end)
				return -1;
			if(array[mid] == n) 
				return mid;
			else if (array[mid] > n)
				end = mid - 1;
			else
				start = mid + 1;
		} while(true);
	}
	


}
