package filtra_linked_list;

import java.util.Scanner;

public class Main {

    public static class LinkedList {

	private Node head;
	private Node tail;
	private int size;

	public boolean isEmpty() {
	    return this.head == null;
	}

	public void addLast(int value) {

	    Node newNode = new Node(value);

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

	public void removeFirst() {

	    if (this.isEmpty()) return;

	    if (this.size == 1) {
		this.head = null;
		this.tail = null;
	    } else {
		this.head = this.head.next;
		this.head.prev = null;
	    }

	    this.size--;

	}

	public void removeLast() {

	    if (this.isEmpty()) return;

	    if (this.size == 1) {
		this.head = null;
		this.tail = null;
	    } else {
		this.tail = this.tail.prev;
		this.tail.next = null;
	    }

	    this.size--;

	}

	public void remove(int index) {

	    if (index < 0 || index >= this.size) return;

	    if (index == 0) {
		removeFirst();
		return;
	    }

	    if (index == this.size - 1) {
		removeLast();
		return;
	    }

	    Node aux = this.head;
	    int count = 0;

	    while (count < index) {
		aux = aux.next;
		count++;
	    }

	    aux.prev.next = aux.next;
	    aux.next.prev = aux.prev;

	    this.size--;

	}

	public boolean removeByValue(int value) {

	    int index = this.indexOf(value);

	    if (index == -1) return false;

	    this.remove(index);

	    return true;

	}

	public int indexOf(int value) {

	    Node aux = this.head;
	    int count = 0;

	    while (count < this.size) {
		if (aux.value == value) return count;
		aux = aux.next;
		count++;
	    }

	    return -1;

	}

	public boolean contains(int value) {
	    return this.indexOf(value) != -1;
	}

	public void removeWhileExists(int value) {

	    while (this.contains(value))
		this.removeByValue(value);

	}

	@Override
	public String toString() {

	    if (this.isEmpty()) return "vazia";

	    String ll = "";
	    Node aux = this.head;
	    int count = 0;

	    while (count < this.size) {
		ll += aux.value + " ";
		aux = aux.next;
		count++;
	    }

	    return ll.substring(0, ll.length() - 1);

	}

    }

    public static class Node {

	int value;
	Node next;
	Node prev;

	public Node(int value) {
	    this.value = value;
	}
    
    }

    public static void main(String[] args) {

	Scanner sc = new Scanner(System.in);

	LinkedList ll = new LinkedList();

	String[] line = sc.nextLine().split(" ");
	int value = Integer.parseInt(sc.nextLine());

	for (int i = 0; i < line.length; i++)
	    ll.addLast(Integer.parseInt(line[i]));

	ll.removeWhileExists(value);

	System.out.println(ll);

	sc.close();

    }

}
