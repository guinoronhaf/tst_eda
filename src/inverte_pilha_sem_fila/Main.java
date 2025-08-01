package inverte_pilha_sem_fila;

public class Main {

    public static class Stack {

        private int[] stack;
        private int top;

        public Stack(int capacity) {
            this.stack = new int[capacity];
            this.top = -1;
        }

        public boolean isEmpty() {
            return this.top == -1;
        }

        public boolean isFull() {
            return this.top == this.stack.length - 1;
        }

        public void push(int k) {

            if (this.isFull()) throw new RuntimeException();

            this.stack[++this.top] = k;

        }

        public int peek() {

            if (this.isEmpty()) throw new RuntimeException();

            return this.stack[this.top];

        }

        public int pop() {

            if (this.isEmpty()) throw new RuntimeException();

            return this.stack[this.top--];

        }

        public void reverse() {
    
            int operations = 0;

            while (operations < this.size) {
                int lastIdx = 0;
                while (lastIdx < this.size - operations) {

                }
            }

        }

        public int size() {
            return this.top + 1;
        }

        @Override
        public String toString() {

            String stack = "";
            Stack aux = new Stack(this.size());

            while (!this.isEmpty()) {
                int current = this.pop();
                aux.push(current);
                stack += current;
                if (!this.isEmpty()) stack += "\n";
            }

            while (!aux.isEmpty()) this.push(aux.pop());

            return stack;

        }
    }

    public static void main(String[] args) {

        Stack s = new Stack(3);

        s.push(1);
        s.push(2);
        s.push(4);

        System.out.println(s);

    }

}
