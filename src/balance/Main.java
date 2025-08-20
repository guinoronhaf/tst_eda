package balance;

public class Main {

    public static class Node {

        public int v;
        public Node parent;
        public Node left;
        public Node right;

        public Node(int v) {
            this.v = v;
        }

    }

    public static class BST {

        private Node root;
        private int size;

        public boolean isEmpty() {
            return this.root == null;
        }

        //add
        private void add(Node current, int k) {
    
            if (current == null) {
                this.root = new Node(k);
                return;
            }

            if (current.v > k) {
                if (current.left == null) {
                    Node newNode = new Node(k);
                    current.left = newNode;
                    newNode.parent = current;
                    return;
                }
                add(current.left, k);
            } else {
                if (current.right == null) {
                    Node newNode = new Node(k);
                    current.right = newNode;
                    newNode.parent = current;
                    return;
                }
                add(current.right, k);
            }

            this.size++;

        }

        public void add(int k) {
            this.add(this.root, k);
        }

        //height
        private int height(Node current) {
            if (current == null)
                return -1;
            return 1 + Math.max(height(current.left), height(current.right));
        }

        public int height() {
            return this.height(this.root);
        }

    }

    public static void main(String[] args) {
        System.out.println("testando");
    }

}
