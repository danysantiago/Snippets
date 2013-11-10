
public class EPI_5dot2 {

	public static void main(String[] args) {
		System.out.println(Integer.toBinaryString(swapBits(0b11001, 0, 1)));
		System.out.println(Integer.toBinaryString(swapBits(0b11001, 3, 0)));
		System.out.println(Integer.toBinaryString(swapBits(0b11001, 4, 2)));
	}
	
	public static int swapBits(int num, int i, int j) {
		int iBit = num & (1 << i);
		int jBit = num & (1 << j);
		
		if(iBit > 0) {
			num = num | (1 << j);
		} else {
			num = num & ~(1 << j);
		}
		
		if(jBit > 0) {
			num = num | (1 << i);
		} else {
			num = num & ~(1 << i);
		}
		
		return num;
	}

}
