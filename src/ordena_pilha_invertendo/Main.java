package ordena_pilha_invertendo;

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

	public void push(int k) {
	    this.pilha[++this.topo] = k;
	}

	public int pop() {
	    return this.pilha[this.topo--];
	}

	public int peek() {
	    return this.pilha[this.topo];
	}

	public int size() {
	    return this.topo + 1;
	}

	public int max(int index) {

	    Pilha auxPilha = new Pilha(this.size());
	    int cont = 0;
	    int maior = this.peek();

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

	public void inverte(int index) {
	
	}

	public void imprimePilha() {

	    Pilha auxPilha = new Pilha(this.size());

	    while (!this.isEmpty()) {
		int current = this.pop();
		auxPilha.push(current);
		System.out.println(current);
	    }

	    while (!auxPilha.isEmpty())
		this.push(auxPilha.pop());

	}
    
    }

    public static void ordena(Pilha p) {
	
	Pilha resPilha = new Pilha(p.size());
	int i = 1;

	while (i <= p.size()) {
	    Pilha auxPilha = new Pilha(p.size());
	    int max = p.max(p.size() - 1);
	    resPilha.push(max);
	    while (!p.isEmpty()) {
		int current = p.pop();
		if (current != max)
		    auxPilha.push(current);
	    }
	    p = auxPilha;
	    i++;
	}

	resPilha.imprimePilha();

	// 1 2 24 8 -1
    
    }

    public static void main(String[] args) {

	Pilha p = new Pilha(5);

	p.push(1);
	p.push(2);
	p.push(24);
	p.push(8);
	p.push(-1);

	ordena(p);

    }


}
