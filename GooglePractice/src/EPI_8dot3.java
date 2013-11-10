import java.util.Stack;


public class EPI_8dot3 {

	public static void main(String[] args) {
		

	}
	
	public static void printSubTree(Node n) {
		Stack<Node> s = new Stack<>();
		
		Node curr = n;
		while(!s.isEmpty() || curr != null) {
			if(curr != null) {
				s.push(curr);
				curr = curr.left;
			} else {
				curr = s.pop();
				System.out.println(curr.element);
				curr = curr.right;
			}
		}
	}
	
	public static class Node {
		Node left;
		Node right;
		int element;
	}

}
