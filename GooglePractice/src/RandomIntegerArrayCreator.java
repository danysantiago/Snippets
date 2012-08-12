import java.util.Random;


public class RandomIntegerArrayCreator {
	private static final Random r = new Random();
	
	{
		r.setSeed(System.currentTimeMillis());
	}
	
	public static int[] createArray(){
		int size = Math.abs(r.nextInt());
		int[] array = new int[size];
		for(int i = 0; i < size; i++){
			array[i] = r.nextInt();
		}
		return array;
	}
	
	public static int[] createPositiveArray(int min, int max, int size){
		int[] array = new int[size];
		for(int i = 0; i < size; i++){
			array[i] = r.nextInt(max - min + 1) + min;
		}
		return array;
	}
}
