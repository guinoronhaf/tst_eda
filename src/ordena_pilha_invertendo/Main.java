package ordena_pilha_invertendo;

import java.util.Scanner;

public class Main {

    public static class Pilha {

	private int topo;
	private int[] pilha;

	public Pilha(int capacidade) {
	    this.topo = -1;
	    this.pilha = new int[capacidade];
	}

	public boolean isEmpty() {
	    return this.topo == -1;
	}

	public int size() {
	    return this.topo + 1;
	}

	public void push(int k) {
	    this.pilha[++this.topo] = k;
	}

	public int pop() {
	    return this.pilha[this.topo--];
	}

	public int peek() {
	    return this.pilha[this.topo];
	}

	public int indexOf(int k) {

	    Pilha auxPilha = new Pilha(this.size());
	    int auxIndex = 0;
	    int index = -1;

	    while (!this.isEmpty()) {
		int current = this.pop();
		auxPilha.push(current);
		if (current == k) {
		    index = auxIndex;
		    break;
		}
		auxIndex++;
	    }

	    while (!auxPilha.isEmpty())
		this.push(auxPilha.pop());

	    return index;

	}

	public int getMax(int index) {

	    Pilha auxPilha = new Pilha(this.size());
	    int maior = this.pop();
	    int cont = 1;
	    auxPilha.push(maior);

	    while (cont <= index) {
		int current = this.pop();
		auxPilha.push(current);
		if (current > maior)
		    maior = current;
		cont++;
	    }

	    while (!auxPilha.isEmpty())
		this.push(auxPilha.pop());

	    return maior;

	}

	public void reverse(int index) {

	    int[] auxArray = new int[index + 1];
	    int i = 0;

	    while (i <= index)
		auxArray[i++] = this.pop();

	    for (int j = 0; j < auxArray.length; j++)
		this.push(auxArray[j]);

	}

	public void sort() {

	    Pilha auxPilha = new Pilha(this.size());

	    while (!this.isEmpty()) {
		int max = this.getMax(this.size() - 1);
		int indMax = this.indexOf(max);
		this.reverse(indMax);
		int current = this.pop();
		auxPilha.push(current);
	    }

	    while (!auxPilha.isEmpty())
		this.push(auxPilha.pop());

	    this.reverse(this.size() - 1);
	
	}

	@Override
	public String toString() {

	    String rep = "";
	    Pilha auxPilha = new Pilha(this.size());

	    while (!this.isEmpty()) {
		int current = this.pop();
		auxPilha.push(current);
		rep += Integer.toString(current);
		if (!this.isEmpty())
		    rep += "\n";
	    }

	    while (!auxPilha.isEmpty())
		this.push(auxPilha.pop());

	    return rep;
	
	}
    
    }

    public static void main(String[] args) {

	Scanner sc = new Scanner(System.in);

	int capacidade = Integer.parseInt(sc.nextLine());

	String[] line = sc.nextLine().split(" ");

	Pilha pilha = new Pilha(capacidade);

	for (int i = 0; i < line.length; i++)
	    pilha.push(Integer.parseInt(line[i]));

	pilha.sort();

	System.out.println("-");

	System.out.println(pilha);

	sc.close();

    }

}
