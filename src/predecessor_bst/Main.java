package predecessor_bst;
    
import java.util.Scanner;
import java.util.Arrays;

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

        //isEmpty
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

        //contains
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

        //height
        public int height(Node current) {

            if (current == null)
                return -1;

            return 1 + Math.max(height(current.left), height(current.right));

        }

        public int height() {
            return this.height(this.root);
        }

        //max
        private int max(Node node) {

            Node aux = node;

            while (aux.right != null)
                aux = aux.right;

            return aux.v;

        }

        public int max() {
            return this.max(this.root);
        }

        //search
        private Node search(Node current, int k) {

            if (current == null)
                return null;
            else if (current.v == k)
                return current;
            else if (current.v > k)
                return search(current.left, k);
            else
                return search(current.right, k);

        }

        public Node search(int k) {
            return this.search(this.root, k);
        }

        //predecesssor
        public String predecessor(int k) {
    
            if (this.isEmpty()) throw new RuntimeException();

            Node node = this.search(k);

            int[] path = new int[this.height() + 1];
            int idx = 0;

            path[idx++] = node.v;

            if (node.left != null) {
                Node aux =  node.left;
                while (aux.right != null) {
                    path[idx++] = aux.v;
                    aux = aux.right;
                }
                path[idx++] = aux.v;
            } else {
                while (node.parent != null) {
                    path[idx++] = node.parent.v;
                    if (node.parent.v < k)
                        break;
                    node = node.parent;
                }
            }

            return Arrays.toString(Arrays.copyOfRange(path, 0, idx));

        }

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        BST bst = new BST();
        
        String[] line = sc.nextLine().split(" ");

        for (int i = 0; i < line.length; i++)
            bst.add(Integer.parseInt(line[i]));

        int k = Integer.parseInt(sc.nextLine());

        System.out.println(bst.predecessor(k));

        sc.close();

    }

}
