package inverte_pilha_sem_fila;

import java.util.Scanner;

public class Main {
	
    public static class Pilha {
	
	private int[] pilha;
	private int topo;

	public Pilha(int capacidade) {
	    this.pilha = new int[capacidade];
	    this.topo = -1;
	}

	private void naBase(int k) {
	
	    if (this.isEmpty()) {
		this.push(k);
	    } else {
		int l = this.pop();
		naBase(k);
		this.push(l);
	    }

	}

	public boolean isEmpty() {
	    return this.topo == -1;
	}

	public boolean isFull() {
	    return this.topo == this.pilha.length - 1;
	}

	public void push(int k) {

	    if (this.isFull()) throw new RuntimeException();

	    this.pilha[++this.topo] = k;

	}

	public int peek() {

	    if (this.isEmpty()) throw new RuntimeException();

	    return this.pilha[this.topo];

	}

	public int pop() {

	    if (this.isEmpty()) throw new RuntimeException();

	    return this.pilha[this.topo--];

	}

	private void reverse() {

	    if (this.isEmpty()) return;

	    int l = this.pop();
	    reverse();
	    naBase(l);

	}

	public int size() {
	    return this.topo + 1;
	}

	@Override
	public String toString() {
	
	    String pilha = "";
	    Pilha aux = new Pilha(this.size());

	    while (!this.isEmpty()) {
		int current = this.pop();
		aux.push(current);
		pilha += current;
		if (!this.isEmpty()) pilha += "\n";
	    }

	    while (!aux.isEmpty())
		this.push(aux.pop());

	    return pilha;

	}

    }

    public static void main(String[] args) {

	Scanner sc = new Scanner(System.in);

	Integer capacity = Integer.parseInt(sc.nextLine());

	Pilha p = new Pilha(capacity);

	String[] line = sc.nextLine().split(" ");

	for (int i = 0; i < line.length; i++)
	    p.push(Integer.parseInt(line[i]));

	p.reverse();

	System.out.println(p);

	sc.close();

    }

}
