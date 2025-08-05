package element_at_pilha;

import java.util.Scanner;

public class Main {

    public static class Stack {

	private int[] stack;
	private int top;

	public Stack(int capacity) {
	    this.stack = new int[capacity];
	    this.top = -1;
	}

	public boolean isEmpty() {
	    return this.top == -1;
	}

	public boolean isFull() {
	    return this.top == this.stack.length - 1;
	}

	public void push(int k) {

	    if (this.isFull()) throw new RuntimeException();

	    this.stack[++this.top] = k;

	}

	public int get(int index) {
	
	    if (index < 0 || index >= this.size()) throw new IllegalArgumentException();

	    Stack aux = new Stack(this.size());
	    int idx = 0;
	    int element = this.peek();

	    while (!this.isEmpty()) {
		int current = this.pop();
		aux.push(current);
		if (idx == index) {
		    element = current;
		    break;
		}
		idx++;
	    }

	    while (!aux.isEmpty())
		this.push(aux.pop());

	    return element;

	}

	public int peek() {

	    if (this.isEmpty()) throw new RuntimeException();

	    return this.stack[this.top];

	}

	public int pop() {

	    if (this.isEmpty()) throw new RuntimeException();

	    return this.stack[this.top--];

	}

	public int size() {
	    return this.top + 1;
	}

	@Override
	public String toString() {

	    String rep = "";
	    Stack aux = new Stack(this.size());

	    while (!this.isEmpty()) {
		int current = this.pop();
		aux.push(current);
		rep += current;
		if (!this.isEmpty()) rep += "\n";
	    }

	    while (!aux.isEmpty())
		this.push(aux.pop());

	    return rep;

	}

    }

    public static void main(String[] args) {

	Scanner sc = new Scanner(System.in);

	String[] line = sc.nextLine().split(" ");

	Stack s = new Stack(line.length);

	for (int i = line.length - 1; i >= 0; i--)
	    s.push(Integer.parseInt(line[i]));

	Integer index = Integer.parseInt(sc.nextLine());

	try {
	    System.out.println(s.get(index));
	} catch(IllegalArgumentException e) {
	    System.out.println("indice invalido");
	}

	sc.close();

    }

}
