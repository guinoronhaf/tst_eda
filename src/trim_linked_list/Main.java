package trim_linked_list;

import java.util.Scanner;

public class Main {

    public static class Node {

	public int value;
	public Node prev;
	public Node next;

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

	public void addLast(int k) {

	    Node newNode = new Node(k);

	    if (this.isEmpty()) {
		this.head = newNode;
		this.tail = newNode;
	    } else {
		newNode.prev = this.tail;
		this.tail.next = newNode;
		this.tail = this.tail.next;
	    }

	    this.size++;

	}

	public int removeFirst() {
	
	    if (this.isEmpty()) throw new RuntimeException();

	    int value = this.head.value;

	    if (this.head.next == null) {
		this.head = null;
		this.tail = null;
	    } else {
		this.head = this.head.next;
		this.head.prev = null;
	    }

	    this.size--;

	    return value;

	}

	public int removeLast() {
	
	    if (this.isEmpty()) throw new RuntimeException();

	    int value = this.tail.value;

	    if (this.head.next == null) {
		this.head = null;
		this.tail = null;
	    } else {
		this.tail = this.tail.prev;
		this.tail.next = null;
	    }

	    this.size--;

	    return value;

	}

	public void trim(int rep) {
	
	    if (this.isEmpty()) throw new RuntimeException();

	    int count = 0;

	    while (count < rep) {
		this.removeFirst();
		if (!this.isEmpty()) this.removeLast();
		count++;
	    }

	}

	public int size() {
	    return this.size;
	}

	@Override
	public String toString() {
	   
	    String ll = "";
	    Node aux = this.head;

	    while (aux != null) {
		ll += aux.value;
		if (aux.next != null) ll += " ";
		aux = aux.next;
	    }

	    return ll;

	}
    
    }

    public static void main(String[] args) {

	Scanner sc = new Scanner(System.in);

	LinkedList ll = new LinkedList();

	String[] line = sc.nextLine().split(" ");

	for (int i = 0; i < line.length; i++)
	    ll.addLast(Integer.parseInt(line[i]));

	Integer index = Integer.parseInt(sc.nextLine());

	ll.trim(index);

	if (ll.isEmpty())
	    System.out.println("vazia");
	else
	    System.out.println(ll);

	sc.close();

    }

}
