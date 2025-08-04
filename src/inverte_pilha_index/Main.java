package inverte_pilha_index;

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
	
	    if (this.isFull()) throw new RuntimeException();

	    if (this.isEmpty())
		this.head++;

	    this.tail = (this.tail + 1) % this.queue.length;

	    this.queue[this.tail] = k;

	    this.size++;

	}

	public int getFirst() {
	
	    if (this.isEmpty()) throw new RuntimeException();

	    return this.queue[this.head];

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

	public void reverseUntil(int index) {
	
	    int idx = 0;
	    Queue aux = new Queue(index + 1);

	    while (idx <= index) {
		aux.addLast(this.pop());
		idx++;
	    }

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

	    while (!aux.isEmpty())
		this.push(aux.pop());

	    return stack;

	}


    }

    public static void main(String[] args) {

	Scanner sc = new Scanner(System.in);

	Integer capacity = Integer.parseInt(sc.nextLine());

	Stack s = new Stack(capacity);

	String[] line = sc.nextLine().split(" ");

	for (int i = 0; i < line.length; i++)
	    s.push(Integer.parseInt(line[i]));

	Integer index = Integer.parseInt(sc.nextLine());

	System.out.println("-");

	s.reverseUntil(index);

	System.out.println(s);

	sc.close();

    }

}
