package fila_linked_list;

import java.util.Scanner;

public class Main {

    public static class Node {
	
	private int value;
	private Node prev;
	private Node next;

	public Node(int value) {
	    this.value = value;
	}

    }

    public static class LinkedList {
	
	private Node head;
	private Node tail;
	private int size;

	public LinkedList() {
	    this.head = null;
	    this.tail = null;
	    this.size = 0;
	}

	public boolean isEmpty() {
	    return this.head == null;
	}

	private void addLast(Node node, int k) {
	
	    if (node.next == null) {
		Node newNode = new Node(k);
		newNode.prev = node;
		node.next = newNode;
		this.tail = newNode;
	    } else {
		addLast(node.next, k);
	    }

	}

	public void addLast(int k) {
	
	    if (this.isEmpty()) {
		Node newNode = new Node(k);
		this.head = newNode;
		this.tail = newNode;
	    } else {
		addLast(this.head, k);
	    }

	    this.size++;

	}

	public Integer getFirst() {

	    if (this.isEmpty()) return null;

	    return this.head.value;

	}

	public boolean removeFirst() {
		
	    if (this.isEmpty()) return false;

	    if (this.head.next == null) {
		this.head = null;
		this.tail = null;
	    } else {
		this.head = this.head.next;
		this.head.prev = null;
	    }

	    this.size--;

	    return true;

	}

	private int indexOf(Node node, int k) {
	    if (node == null) return -this.size - 1;
	    else if (node.value == k) return 0;
	    else return 1 + indexOf(node.next, k);
	}

	public int indexOf(int k) {
	    return indexOf(this.head, k);
	}

	public int size() {
	    return this.size;
	}

	private String toString(Node node) {
	    if (node.next == null) return Integer.toString(node.value);
	    else return node.value + " " + toString(node.next);
	}

	@Override
	public String toString() {
	    return toString(this.head);
	}

    }

    public static class Queue {
	
	private LinkedList queue;

	public Queue() {
	    this.queue = new LinkedList();
	}

	public boolean isEmpty() {
	    return this.queue.isEmpty();
	}

	public void addLast(int k) {
	    this.queue.addLast(k);
	}

	public String getFirst() {

	    if (this.queue.getFirst() == null) return "empty";

	    return this.queue.getFirst() + "";

	}

	public boolean removeFirst() {
	    return this.queue.removeFirst();
	}

	public int indexOf(int k) {
	    return this.queue.indexOf(k);
	}

	public int size() {
	    return this.queue.size();
	}

	@Override
	public String toString() {
	
	    if (this.isEmpty()) return "empty";

	    return this.queue.toString();

	}

    }
	
    public static void main(String[] args) {
	
	Scanner sc = new Scanner(System.in);

	Queue q = new Queue();

	String line = sc.nextLine();

	while (!line.equals("end")) {

	    if (line.equals("print"))
		System.out.println(q);
	    else if (line.equals("element"))
		System.out.println(q.getFirst());
	    else if (line.equals("remove")) {
		if (!q.removeFirst())
		    System.out.println("empty");
	    }
	    else {
		String[] lineSplit = line.split(" ");
		int value = Integer.parseInt(lineSplit[1]);
		if (lineSplit[0].equals("add"))
		    q.addLast(value);
		else
		    System.out.println(q.indexOf(value));
	    }

	    line = sc.nextLine();

	}

	sc.close();

    }

}
