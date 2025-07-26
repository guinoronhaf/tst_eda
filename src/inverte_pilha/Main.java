package inverte_pilha;

import java.util.Scanner;

public class Main {

    public static class Queue {
	
	private int[] queue;
	private int head;
	private int tail;
	private int size;

	public Queue(int capacity) {
	    this.queue = new int[capacity];
	    this.head = -1;
	    this.tail = -1;
	    this.size = 0;
	}

	public boolean isEmpty() {
	    return this.head == -1;
	}

	public boolean isFull() {
	    return this.size == this.queue.length;
	}

	public void addLast(int k) {
	
	    if (this.isFull()) {
		throw new RuntimeException();
	    } else {
		this.size++;
	    }

	    if (this.isEmpty())
		this.head++;

	    this.tail = (this.tail + 1) % this.queue.length;

	    this.queue[this.tail] = k;

	}

	public int removeFirst() {

	    if (this.isEmpty()) throw new RuntimeException();

	    int value = this.queue[this.head];

	    if (this.size == 1) {
		this.head = -1;
		this.tail = -1;
	    } else {
		this.head = (this.head + 1) % this.queue.length;
	    }

	    this.size--;

	    return value;

	}

	public int size() {
	    return this.size;
	}

    }

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

	public void reverse() {
	
	    Queue aux = new Queue(this.size());

	    while (!this.isEmpty())
		aux.addLast(this.pop());

	    while (!aux.isEmpty())
		this.push(aux.removeFirst());

	}

	@Override
	public String toString() {
	
	    String stack = "";
	    Stack aux = new Stack(this.size());

	    while (!this.isEmpty()) {
		int current = this.pop();
		aux.push(current);
		stack += current;
		if (!this.isEmpty()) stack += "\n";
	    }

	    while (!aux.isEmpty()) this.push(aux.pop());

	    return stack;

	}

    }
	
    public static void main(String[] args) {

	Scanner sc = new Scanner(System.in);

	int stackSize = Integer.parseInt(sc.nextLine());

	Stack stack = new Stack(stackSize);

	String[] values = sc.nextLine().split(" ");

	for (int i = 0; i < values.length; i++)
	    stack.push(Integer.parseInt(values[i]));

	stack.reverse();

	System.out.println(stack);

	sc.close();

    }

}
