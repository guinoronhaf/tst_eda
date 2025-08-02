package troca_vizinhos_linked_list;

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
	
	// mais elegante
	public void swap(int index) {
	
	    Node aux = this.head;
	    int idx = 0;
	    
	    while (idx < index) {
		aux = aux.next;
		idx++;
	    }

	    Node previous = aux.prev;
	    Node second = aux.next;
	    Node distant = second.next;

	    if (previous == null) {
		this.head = second;
		this.head.prev = null;
	    } else {
		previous.next = second;
	    }

	    if (distant == null) {
		this.tail = aux;
		this.tail.next = null;
	    } else {
		distant.prev = aux;
	    }

	    second.prev = previous;
	    second.next = aux;

	    aux.prev = second;
	    aux.next = distant;

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

	String[] values = sc.nextLine().split(" ");

	for (int i = 0; i < values.length; i++)
	    ll.addLast(Integer.parseInt(values[i]));

	Integer index = Integer.parseInt(sc.nextLine());

	ll.swap(index);

	System.out.println(ll);

	sc.close();

    }

}
