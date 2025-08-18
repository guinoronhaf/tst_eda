package conta_nos_internos;

import java.util.Scanner;
import java.util.LinkedList;

public class Main {

    public static class Node {

        public int v;
        public Node parent;
        public Node left;
        public Node right;

        public Node(int v) {
            this.v = v;
        }

        public boolean isLeaf() {
            return (this.left == null) && (this.right == null);
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

        //nosInternos
        public int nosInternosBFS() {

            if (this.isEmpty())
                return 0;

            LinkedList<Node> queue = new LinkedList<>();
            int count = 0;

            queue.addLast(this.root);

            while (!queue.isEmpty()) {
                Node node = queue.removeFirst();
                if (!node.isLeaf()) count++;
                if (node.left != null)
                    queue.addLast(node.left);
                if (node.right != null)
                    queue.addLast(node.right);
            }

            return count;

        }
 
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        BST bst = new BST();

        String[] line = sc.nextLine().split(" ");

        for (int i = 0; i < line.length; i++)
            bst.add(Integer.parseInt(line[i]));

        System.out.println(bst.nosInternosBFS());

        sc.close();

    }

}
