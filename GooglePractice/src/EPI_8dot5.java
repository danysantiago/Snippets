import java.util.ArrayList;
import java.util.Stack;


public class EPI_8dot5 {

	public static void main(String[] args) {
		ArrayList<Stack<Integer>> pegs = new ArrayList<Stack<Integer>>();
		Stack<Integer> peg1 = new Stack<Integer>();
		peg1.push(6);
		peg1.push(5);
		peg1.push(4);
		peg1.push(3);
		peg1.push(2);
		peg1.push(1);
		
		pegs.add(peg1);
		pegs.add(new Stack<Integer>());
		pegs.add(new Stack<Integer>());

		transfer(6, pegs, 0, 1, 2);
	}

	private static void transfer(int n, ArrayList<Stack<Integer>> pegs, int from, int to, int aux) {
		if(n > 0 ) {
			transfer(n-1, pegs, from, aux, to);
			pegs.get(to).push(pegs.get(from).pop());
			System.out.println("Move from p" + from + " to p" + to);
			transfer(n-1, pegs, aux, to, from);
		}
	}

}
