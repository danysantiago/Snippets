import java.util.ArrayList;
import java.util.Collections;


public class MultiThread {
	
	public static void main(String[] args){
		long startTime;
		long stopTime;
		int[] array = RandomIntegerArrayCreator.createPositiveArray(25, 300, 100000000);
		int quarterSize = array.length/4;
		int[] q1 = createQuarter(array, 0, quarterSize);
		int[] q2 = createQuarter(array, quarterSize + 1, 2*quarterSize);
		int[] q3 = createQuarter(array, 2*quarterSize + 1, 3*quarterSize);
		int[] q4 = createQuarter(array, 3*quarterSize, array.length);
		
		findMinThread t1 = new findMinThread();
		findMinThread t2 = new findMinThread();
		findMinThread t3 = new findMinThread();
		findMinThread t4 = new findMinThread();
		t1.setArr(q1);
		t2.setArr(q2);
		t3.setArr(q3);
		t4.setArr(q4);
		
		startTime = System.nanoTime();
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		
		try {
			t1.join();
			t2.join();
			t3.join();
			t4.join();
		} catch (InterruptedException e) {
			
		}
		
		ArrayList<Integer> resultArray = new ArrayList<Integer>();
		resultArray.add(t1.getMin());
		resultArray.add(t2.getMin());
		resultArray.add(t3.getMin());
		resultArray.add(t4.getMin());
		
		System.out.println(Collections.min(resultArray));
		stopTime = System.nanoTime();
		System.out.println("Elapsed time: " + (stopTime - startTime));
		
		startTime = System.nanoTime();
		System.out.println(findMin(array));
		stopTime = System.nanoTime();
		System.out.println("Elapsed time: " + (stopTime - startTime));
		
		
	}
	
	private static int[] createQuarter(int[] array, int start, int end){
		int[] atr = new int[end-start];
		for(int i = 0; i < atr.length; i++){
			atr[i] = array[start + i];
		}
		return atr;
	}
	
	private static int findMin(int[] arr){
		int min = arr[0];
		for(int i = 0; i < arr.length; i++){
			if(arr[i] < min)
				min = arr[i];
		}
		return min;
	}

}

class findMinThread extends Thread{
	
	int[] arr;
	int min;

	@Override
	public void run() {
		min = arr[0];
		for(int i = 0; i < arr.length; i++){
			if(arr[i] < min)
				min = arr[i];
		}
		
	}

	public int getMin() {
		return min;
	}

	public void setArr(int[] arr) {
		this.arr = arr;
	}
	
	
	
}