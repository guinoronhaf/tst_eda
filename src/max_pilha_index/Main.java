package max_pilha_index;

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

	public boolean isFull() {
	    return this.topo == this.pilha.length - 1;
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

    }

    public static int maxPilhaIndex(int[] valores, int index) {

	Pilha pilha = new Pilha(valores.length);
	Pilha auxPilha = new Pilha(valores.length);

	for (int i = 0; i < valores.length; i++)
	    pilha.push(valores[i]);

	int maior = pilha.pop();
	int cont = 1;
	auxPilha.push(maior);

	while (cont <= index) {
	    int current = pilha.pop();
	    auxPilha.push(current);
	    if (current > maior)
		maior = current;
	    cont++;
	}

	while (!auxPilha.isEmpty())
	    pilha.push(auxPilha.pop());

	return maior;

    }

    public static void main(String[] args) {

	Scanner sc = new Scanner(System.in);

	String[] line = sc.nextLine().split(" ");
	int[] values = new int[line.length];

	for (int i = 0; i < line.length; i++)
	    values[i] = Integer.parseInt(line[i]);

	int index = Integer.parseInt(sc.nextLine());

	System.out.println(maxPilhaIndex(values, index));

	sc.close();

    }

}
