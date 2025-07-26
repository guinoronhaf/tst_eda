package parenteses;

import java.util.Scanner;

public class Main {

    public static class Stack {

	private String[] stack;
	private int top;

	public Stack(int capacity) {
	    this.stack = new String[capacity];
	    this.top = -1;
	}

	public boolean isEmpty() {
	    return this.top == -1;
	}

	public boolean isFull() {
	    return this.top == this.stack.length - 1;
	}

	public void push(String s) {
	
	    if (this.isFull()) throw new RuntimeException();

	    this.stack[++this.top] = s;

	}

	public String peek() {
		
	    if (this.isEmpty()) throw new RuntimeException();

	    return this.stack[this.top];

	}

	public String pop() {
		
	    if (this.isEmpty()) throw new RuntimeException();

	    return this.stack[this.top--];

	}

	public int size() {
	    return this.top + 1;
	}

    }

    public static class Solution {
	
	public static boolean validateParenthesis(String s) {

	    Stack stack = new Stack(s.length());

	    for (int i = 0; i < s.length(); i++) {
		String character = s.charAt(i) + "";
		if (character.equals("(")) {
		    stack.push(character);
		} else {
		    if (stack.isEmpty()) return false;
		    stack.pop();
		}
	    }

	    return stack.isEmpty();

	}

    }

    public static void main(String[] args) {

	Scanner sc = new Scanner(System.in);

	String s = sc.nextLine();

	if (Solution.validateParenthesis(s))
	    System.out.println("S");
	else
	    System.out.println("N");

	sc.close();

    }

}
