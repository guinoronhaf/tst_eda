package inverte_pilha_index;

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

        public void imprimePilha() {

            Pilha auxPilha = new Pilha(this.size());

            while (!this.isEmpty()) {
                System.out.println(this.peek());
                auxPilha.push(this.pop());
            }

            while (!auxPilha.isEmpty())
                this.push(auxPilha.pop());

        }
 
    }

    public static void inverte(int capacidade, int index, int[] valores) {

	Pilha pilha = new Pilha(capacidade);
	int[] auxArray = new int[index + 1];
	int cont = 0;

	for (int i = 0; i < valores.length; i++)
	    pilha.push(valores[i]);

	while (cont <= index) {
	    auxArray[cont++] = pilha.pop();
	}

	for (int i = 0; i < auxArray.length; i++)
	    pilha.push(auxArray[i]);

	pilha.imprimePilha();

    }

    public static void main(String[] args) {

	Scanner sc = new Scanner(System.in);

	int capacidade = Integer.parseInt(sc.nextLine());

	String[] line = sc.nextLine().split(" ");
	int[] values = new int[line.length];

	for (int i = 0; i < line.length; i++)
	    values[i] = Integer.parseInt(line[i]);

	int index = Integer.parseInt(sc.nextLine());

	System.out.println("-");

	inverte(capacidade, index, values);

	sc.close();

    }

}
