package notacao_polonesa_reversa;

import java.util.Scanner;

public class Main {

    public static class Stack {

	private double[] stack;
	private int top;

	public Stack(int capacity) {
	    this.stack = new double[capacity];
	    this.top = -1;
	}

	public boolean isEmpty() {
	    return this.top == -1;
	}

	public boolean isFull() {
	    return this.top == this.stack.length - 1;
	}

	public void push(double k) {

	    if (this.isFull()) throw new RuntimeException();

	    this.stack[++this.top] = k;

	}

	public double peek() {

	    if (this.isEmpty()) throw new RuntimeException();

	    return this.stack[this.top];

	}

	public double pop() {

	    if (this.isEmpty()) throw new RuntimeException();

	    return this.stack[this.top--];

	}

	public int size() {
	    return this.top + 1;
	}
    
    }

    public static class Solver {

	public static double reversePolish(String[] s) {
	
	    Stack stack = new Stack(s.length);
	    double result = 0.0;

	    for (int i = 0; i < s.length; i++) {

		String symbol = s[i];

		if (symbol.equals("+")) {
		    double last = stack.pop();
		    stack.push(stack.pop() + last);
		} else if (symbol.equals("-")) {
		    double last = stack.pop();
		    stack.push(stack.pop() - last);
		} else if (symbol.equals("*")) {
		    double last = stack.pop();
		    stack.push(stack.pop() * last);
		} else if (symbol.equals("/")) {
		    double last = stack.pop();
		    stack.push(stack.pop() / last);
		} else {
		    stack.push(Double.parseDouble(symbol));
		}

	    }

	    return stack.peek();

	}
    
    }

    public static void main(String[] args) {

	Scanner sc = new Scanner(System.in);

	String[] line = sc.nextLine().split(" ");

	System.out.println(Solver.reversePolish(line));

	sc.close();

    }

}
