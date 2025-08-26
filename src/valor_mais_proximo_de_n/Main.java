package valor_mais_proximo_de_n;

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
        }

        public void add(int k) {
            this.add(this.root, k);
        }

        private int closerToK(Node current, int k, int n) {
            if ()
        }

        public int closerToK(int k) {
            return this.closerToK(this.root, k);
        }

        private boolean contains(Node current, int k) {
            if (current == null)
                return false;
            else if (current.v == k)
                return true;
            else if (current.v > k)
                return contains(current.left, k);
            else
                return contains(current.right, k);
        }

        public boolean contains(int k) {
            return this.contains(this.root, k);
        }

    }

    public static void main(String[] args) {
    
        BST bst = new BST();

        int[] a = new int[]{10, 8, 1, 9, 20, 18, 25};

        for (int i : a)
            bst.add(i);

        for (int i : a)
            System.out.println(bst.contains(i));

        System.out.println(bst.closerToK(23));

    }

}
