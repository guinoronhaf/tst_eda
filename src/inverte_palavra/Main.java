package inverte_palavra;

import java.util.Scanner;

public class Main {

    public static class Pilha {

	private String[] pilha;
	private int topo;

	public Pilha(int capacidade) {
	    this.pilha = new String[capacidade];
	    this.topo = -1;
	}

	private void moveToBase(String k) {

	    if (this.isEmpty()) {
		this.push(k);
	    } else {
		String top = this.pop();
		moveToBase(k);
		this.push(top);
	    }

	}

	public boolean isEmpty() {
	    return this.topo == -1;
	}

	public boolean isFull() {
	    return this.topo == this.pilha.length - 1;
	}

	public void push(String k) {
	    if (this.isFull()) throw new RuntimeException();
	    this.pilha[++this.topo] = k;
	}

	public String peek() {
	    if (this.isEmpty()) throw new RuntimeException();
	    return this.pilha[this.topo];
	}

	public String pop() {
	    if (this.isEmpty()) throw new RuntimeException();
	    return this.pilha[this.topo--];
	}

	public void reverse() {

	    if (this.isEmpty()) return;

	    String top = this.pop();
	    reverse();
	    moveToBase(top);
	
	}

	public int size() {
	    return this.topo + 1;
	}

	@Override
	public String toString() {

	    Pilha aux = new Pilha(this.size());

	    String pilha = "";

	    while (!this.isEmpty()) {
		String current = this.pop();
		pilha += current;
		aux.push(current);
		if (!this.isEmpty()) pilha += " ";
	    }

	    while (!aux.isEmpty()) this.push(aux.pop());

	    return pilha;

	}
     
    }

    public static void main(String[] args) {

	Scanner sc = new Scanner(System.in);

	String[] line = sc.nextLine().split(" ");

	Pilha p = new Pilha(line.length);

	for (int i = 0; i < line.length; i++)
	    p.push(line[i]);

	System.out.println(p);

	sc.close();

    }

}
