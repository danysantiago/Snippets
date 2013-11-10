import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;


public class EPI_10dot8 {

	public static void main (String[] args) {
		PriorityQueue<Integer> H = new PriorityQueue<>(32, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o1.compareTo(o2);
			}
		});
		
		PriorityQueue<Integer> L = new PriorityQueue<>(32, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o2.compareTo(o1);
			}
		});
		
		Scanner in = new Scanner(System.in);
		
		
		while(true) {
			int num = in.nextInt();
			
			if(!L.isEmpty() && num > L.peek()) {
				H.add(num);
			} else {
				L.add(num);
			}
			
			if(H.size() > L.size() + 1) {
				L.add(H.poll());
			} else if (L.size() > H.size()){
				H.add(L.poll());
			}
			
			if(H.size() == L.size()) {
				System.out.println( (H.peek() + L.peek()) * 0.5);
			} else {
				System.out.println(H.size() > L.size() ? H.peek() : L.peek());
			}
		}
	}
}
