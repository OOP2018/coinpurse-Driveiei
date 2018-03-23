package coinpurse;

import java.util.Stack;

public class Stackky {

	public Stackky() {
		// TODO Auto-generated constructor stub
	}
	 public static void main(String[] args) {
		Stack<String> stack = new Stack<String>();
		stack.push("s");
		stack.push("a");
		stack.push("d");
		stack.push("y");
		System.out.println(stack.peek());
		System.out.println(stack.pop());
		System.out.println(stack.peek());
		System.out.println(stack.search("a"));
		System.out.println(stack.search("s"));
		System.out.println(stack.search("d"));
		System.out.println(stack.search("y"));
	 }
}

