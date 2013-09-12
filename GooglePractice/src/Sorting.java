import java.util.Arrays;


public class Sorting {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] array1 = RandomIntegerArrayCreator.createPositiveArray(0, 50, 100);
		int[] array2 = array1.clone();
		int[] array3 = array2.clone();
		int[] array4 = array3.clone();
		long startTime;
		long stopTime;

		startTime = System.nanoTime();
		bubbleSort(array1);
		stopTime = System.nanoTime();
		System.out.println("BubblueSort, Elapsed time: " + (stopTime - startTime));
		printArray(array1);
		
		startTime = System.nanoTime();
		array2 = mergeSort(array2);
		stopTime = System.nanoTime();
		System.out.println("MergeSort, Elapsed time: " + (stopTime - startTime));
		printArray(array2);
		
		startTime = System.nanoTime();
		quickSort(array3);
		stopTime = System.nanoTime();
		System.out.println("QuickSort, Elapsed time: " + (stopTime - startTime));
		printArray(array3);
		
		startTime = System.nanoTime();
		Arrays.sort(array4);
		stopTime = System.nanoTime();
		System.out.println("Arrays.sort(), Elapsed time: " + (stopTime - startTime));
		printArray(array4);
		
	}
	
	public static void printArray(int[] array){
		for(int i : array)
			System.out.print(i + " ");
		System.out.println();
	}
	
	public static void bubbleSort(int[] array){
		for(int i = 0; i < array.length; i++){
			for(int j = i + 1; j < array.length; j++){
				if(array[i] > array[j]){
					swap(array, i, j);
				}
			}
		}
	}
	
	private static void swap(int[] array, int a, int b){
		int temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}
	
	public static int[] mergeSort(int[] array){
		if(array.length <= 1)
			return array;
		int[] left = new int[array.length/2];
		int[] right = new int[array.length/2 + array.length%2];
		for(int i = 0; i < left.length; i++)
			left[i] = array[i];
		for(int i = 0; i < right.length; i++)
			right[i] = array[array.length/2 + i];	
		
		left = mergeSort(left);
		right = mergeSort(right);
		return merge(left, right);
	}

	private static int[] merge(int[] left, int[] right) {
		int[] result = new int[left.length + right.length];
		int leftIndex = 0;
		int rightIndex = 0;
		int resultIndex = 0;
		while(leftIndex < left.length && rightIndex < right.length){
			if(left[leftIndex] <= right[rightIndex])
				result[resultIndex++] = left[leftIndex++];
			else
				result[resultIndex++] = right[rightIndex++];
		}
		
		while(leftIndex < left.length)
			result[resultIndex++] = left[leftIndex++];
		while(rightIndex < right.length)
			result[resultIndex++] = right[rightIndex++];
		
		return result;
	}
	
	public static void quickSort(int[] array){
		recQuickSort(array, 0, array.length - 1);
	}

	private static void recQuickSort(int[] array, int leftIndex, int rightIndex) {
		if(leftIndex < rightIndex){
			int pivotIndex = (leftIndex + rightIndex) / 2; //There are many other ways to select a pivot.
			pivotIndex = partition(array, leftIndex, rightIndex, pivotIndex);
			recQuickSort(array, leftIndex, pivotIndex - 1);
			recQuickSort(array, pivotIndex + 1, rightIndex);
		}
	}

	private static int partition(int[] array, int leftIndex, int rightIndex, int pivotIndex) {
		swap(array, pivotIndex, rightIndex);
		pivotIndex = leftIndex;
		for(int i = leftIndex; i < rightIndex; i++){
			if(array[i] < array[rightIndex])
				swap(array, i, pivotIndex++);
		}
		swap(array, pivotIndex, rightIndex);
		return pivotIndex;
	}

}
