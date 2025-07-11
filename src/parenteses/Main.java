package parenteses;

import java.util.Scanner;

public class Main {

    public static class Pilha {

        private int topo;
        private char[] pilha;

        public Pilha(int capacity) {
            this.topo = -1;
            this.pilha = new char[capacity];
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

        public void push(char k) {
            this.pilha[++this.topo] = k;
        }

        public char pop() {
            return this.pilha[this.topo--];
        }

        public char peek() {
            return this.pilha[this.topo];
        }
 
    }

    public static String parenteses(String s) {

        char[] charS = s.toCharArray();

        Pilha pilha = new Pilha(charS.length);

        for (char c : charS) {

            if (c == '(')
                pilha.push(c);
            if (c == ')') {
                if (pilha.size() == 0)
                    return "N";
                pilha.pop();
            }

        }

        if (pilha.size() == 0) return "S";

        return "N";

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        System.out.println(parenteses(s));

        sc.close();

    }

}
