


public class EPI_7dot4 {

	public static void main(String[] args) {
		Node h1 = new Node();
		h1.element = 0;
		
		Node n1 = new Node();
		n1.element = 1;
		h1.next = n1;
		
		Node n2 = new Node();
		n2.element = 2;
		n1.next = n2;
		
		Node n3 = new Node();
		n3.element = 3;
		n2.next = n3;
		
		Node n4 = new Node();
		n4.element = 4;
		n3.next = n4;
		
		Node h2 = new Node();
		h2.element = 0;
		
		Node n21 = new Node();
		n21.element = 1;
		h2.next = n21;
		
		Node n22 = new Node();
		n22.element = 2;
		n21.next = n3;
		
		System.out.println(getOverlap(h1, h2));

	}
	
	public static Node getOverlap(Node h1, Node h2) {
		
		Node curr1 = h1;
		Node curr2 = h2;
		
		while(curr1 != null) {
			while(curr2 != null) {
				if(curr1.equals(curr2)) {
					return curr1;
				}
				
				curr2 = curr2.next;
			}
			
			
			curr1 = curr1.next;
			curr2 = h2;
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
