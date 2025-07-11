package inverte_pilha_index;

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

    public static void inverte(int capacidade, int[] valores) {
    }

    public static void main(String[] args) {

        Pilha p = new Pilha(5);

        p.push(10);
        p.push(20);
        p.push(30);
        p.push(40);
        p.push(50);

        p.imprimePilha();

    }

}
