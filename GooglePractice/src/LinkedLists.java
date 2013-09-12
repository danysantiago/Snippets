import java.util.ArrayList;
import java.util.Random;

public class LinkedLists {
	
	public static Random r = new Random();

	public static void main(String[] args) {
		//Crazy way to build a LL...
		ArrayList<Node<Integer>> list = new ArrayList<Node<Integer>>();
		for(int i = 0; i < 5; i++) {
			Node<Integer> n= new Node<Integer>();
			//n.element = r.nextInt(100);
			n.element = i;
			list.add(n);
		}
		
		for(int i = 0; i < 4; i++) {
			list.get(i).next = list.get(i+1);
		}
		
		Node<Integer> head = list.get(0);
		list = null;
		
		//Done building a random LL...
		
		Node<Integer> result = nthFromLast(head, 6);
		if(result != null)
			System.out.println(result.element);
		else
			System.out.println("Out of bounds dude...");

	}
	
	public static class Node<E> {
		public Node<E> next;
		public E element;
	}

	/**
	 * 2.2 Implement an algorithm to find the nth to last element of a singly
	 * linked list.
	 */
	public static Node<Integer> nthFromLast(Node<Integer> head, int n) {		
		Node<Integer> node1 = head;
		Node<Integer> node2 = head;
		
		if(head == null) {
			return null;
		}
		
		while(node2.next != null && n > 0) {
			node2 = node2.next;
			n--;
		}
		
		if(n != 0) {
			return null;
		}
		
		while (node2.next != null) {
			node1 = node1.next;
			node2 = node2.next;
		} 
		
		return node1;
		
	}

}
