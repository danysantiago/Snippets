
public class EPI_11dot3 {
	
	public static void main(String[] args) {
		int[] arr = {-14, -10, 2, 108, 108, 243, 285, 285, 285, 401};
		
		System.out.println(printIndexEqValue(arr));
	}

	private static int printIndexEqValue(int[] arr) {
		int start = 0;
		int end = arr.length - 1;
		int mid;
		
		while (end > start) {
			mid = (start + end) / 2;
			
			if(arr[mid] == mid) {
				return mid;
			} else if (arr[mid] > mid) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		
		return -1;
	}

}
