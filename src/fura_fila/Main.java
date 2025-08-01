package fura_fila;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
    public static class Fila {
	
	private int[] fila;
	private int head;
	private int last;
	private int size;

	public Fila(int capacidade) {
	    this.fila = new int[capacidade];
	    this.head = -1;
	    this.last = -1;
	    this.size = 0;
	}

	private void clear() {
	    this.head = -1;
	    this.last = -1;
	    this.size = 0;
	}

	private void moveToHead(int index) {
	
	    if (index < 0 || index >= this.size) throw new RuntimeException();

	    Fila aux = new Fila(this.size);
	    Fila result = new Fila(this.size);
	    int count = 0;

	    while (count < index) {
		aux.addLast(this.removeFirst());
		count++;
	    }

	    result.addLast(this.removeFirst());

	    while (!aux.isEmpty())
		result.addLast(aux.removeFirst());

	    while (!this.isEmpty())
		result.addLast(this.removeFirst());

	    this.clear();

	    while (!result.isEmpty())
		this.addLast(result.removeFirst());

	}
 
	public boolean isEmpty() {
	    return this.head == -1;
	}

	public boolean isFull() {
	    return this.size == this.fila.length;
	}

	public void addLast(int k) {

	    if (this.isFull())
		throw new RuntimeException();
	    else if (this.isEmpty())
		this.head++;

	    this.last = (this.last + 1) % this.fila.length;

	    this.fila[last] = k;

	    this.size++;

	}

	public int removeFirst() {

	    if (this.isEmpty()) throw new RuntimeException();

	    int value = this.fila[this.head];

	    if (this.size == 1) {
		this.head = -1;
		this.last = -1;
	    } else {
		this.head = (this.head + 1) % this.fila.length;
	    }

	    this.size--;

	    return value;

	}

	public int getFirst() {
	
	    if (this.isEmpty()) throw new RuntimeException();

	    return this.fila[this.head];

	}

	public void priority(int index) {
	
	    int idx = index;

	    while (idx < this.size) {
		this.moveToHead(idx);
		System.out.println(this.toString());
		idx++;
	    }

	}

	public int size() {
	    return this.size;
	}

	@Override
	public String toString() {
	    return Arrays.toString(this.fila);
	}

    }

    public static void main(String[] args) {

	Fila f = new Fila(9);

	f.addLast(0);
	f.addLast(1);
	f.addLast(2);
	f.addLast(3);
	f.addLast(4);
	f.addLast(5);
	f.addLast(6);
	f.addLast(7);
	f.addLast(8);

	f.priority(4);

    }

}
