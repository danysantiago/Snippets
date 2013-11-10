import java.util.Stack;


public class IQ_Sep23 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		boolean check;
		check = checkExpression("{ [ ( 2+3 ) * 3 ] + (3 + 5) }");
		check = checkExpression("(2+3");
		System.out.println(check);

	}
	
	public static boolean checkExpression(String s) {
	    Stack<Character> stack = new Stack<Character>();
	    
	    //Iterate trough string
	    for(int i = 0; i < s.length(); i++) {
	        char c = s.charAt(i);

	        // Opening characters
	        if(c == '(' || c == '{' || c == '[') {
	            stack.push(c);
	        } else { //Closing characters
	            if(c == ')') {
	                if(!stack.isEmpty() && stack.peek() == '(') {
	                    stack.pop();
					} else {
					    return false;
					}
	            } else if (c == '}') {
	                if(!stack.isEmpty() && stack.peek() == '{') {
	                    stack.pop();
					} else {
					    return false;
					}
	            } else if (c == ']') {
		                if(!stack.isEmpty() && stack.peek() == '[') {
		                    stack.pop();
					} else {
					    return false;
					}
	            }
	        }
	    }

	    if(!stack.isEmpty()) {
	        return false;
	    }

	    return true;
	}

}
