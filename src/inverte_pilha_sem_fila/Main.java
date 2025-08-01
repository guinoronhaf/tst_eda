package inverte_pilha_sem_fila;

import java.util.Arrays;

public class Main {
	
    public static class Pilha {
	
	private int[] pilha;
	private int topo;

	public Pilha(int capacidade) {
	    this.pilha = new int[capacidade];
	    this.topo = -1;
	}

	private void swapTwoFirst() {

	    if (this.size() < 2) throw new RuntimeException();

	    int first = this.pop();
	    int second = this.pop();

	    this.push(first);
	    this.push(second);

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

	public void reverse(int topo) {
	}

	public int size() {
	    return this.topo + 1;
	}

	@Override
	public String toString() {
	    return Arrays.toString(this.pilha);
	}

    }

    public static void main(String[] args) {

	Pilha p = new Pilha(5);

	p.push(2);
	p.push(3);

	p.swapTwoFirst();

	System.out.println(p);

    }

}
