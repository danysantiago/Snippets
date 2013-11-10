import java.util.HashSet;


public class EPI_7dot2 {

	public static void main(String[] args) {
		Node head = new Node();
		head.element = 0;
		
		Node n1 = new Node();
		n1.element = 1;
		head.next = n1;
		
		Node n2 = new Node();
		n2.element = 2;
		n1.next = n2;
		
		Node n3 = new Node();
		n3.element = 3;
		n2.next = n3;
		
		Node n4 = new Node();
		n4.element = 4;
		n3.next = n2;
		
		System.out.println(getCyclic(head));
		
	}
	
	public static Node getCyclic(Node head) {
		HashSet<Node> map = new HashSet<Node>();
		
		if(head == null) {
			return null;
		}
		
		Node curr = head;
		while(curr.next != null) {
			if(map.contains(curr)) {
				return curr;
			} else {
				map.add(curr);
			}
			curr = curr.next;
		}
		
		return null;
	}
	
	public static class Node {
		Node next;
		int element;
		
		@Override
		public String toString() {
			return "{" + element + "}";
		}
	}

}
