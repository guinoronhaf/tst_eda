package build_heap;

public class Main {

    public static class Heap {

        private int[] heap;
        private int tail;

        public Heap(int capacity) {
            this.heap = new int[capacity];
            this.tail = -1;
        }

        public boolean isEmpty() {
            return this.tail == -1;
        }

        private int left(int index) {
            return 2 * index + 1;
        }

        private int right(int index) {
            return 2 * (index + 1);
        }

        private int parent(int index) {
                                                                                                                                      }

    }

    public static void main(String[] args) {
        System.out.println("testando");
    }


}
