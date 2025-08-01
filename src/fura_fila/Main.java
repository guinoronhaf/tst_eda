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

	public void move(int currentIndex, int finalIndex) {

	    Fila aux = new Fila(this.size);
	    Fila result = new Fila(this.size);
	    int currIdx = currentIndex;
	    int finalIdx = 0;
	    int count = 0;

	    while (finalIdx < finalIndex) {
		result.addLast(this.removeFirst());
		finalIdx++;
	    }

	    while (count < currentIndex - finalIndex) {
		aux.addLast(this.removeFirst());
		count++;
	    }
		
	    result.addLast(this.removeFirst());

	    while (!aux.isEmpty())
		result.addLast(aux.removeFirst());

	    while (!this.isEmpty())
		result.addLast(this.removeFirst());

	    this.clear();

	    while (!result.isEmpty()) this.addLast(result.removeFirst());

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
	    int count = 0;

	    while (idx < this.size) {
		move(idx, count);
		System.out.println(this);
		idx++;
		count++;
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

	Scanner sc = new Scanner(System.in);

	String[] line = sc.nextLine().split(" ");

	Fila f = new Fila(line.length);

	for (int i = 0; i < line.length; i++)
	    f.addLast(Integer.parseInt(line[i]));

	Integer index = Integer.parseInt(sc.nextLine());

	f.priority(index);

	sc.close();

    }

}
