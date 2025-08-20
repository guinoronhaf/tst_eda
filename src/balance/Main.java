package balance;

import java.util.Scanner;

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
	    return search(this.root, k);
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

	//balance
	public int balance(Node node) {
	    return height(node.left) - height(node.right);
	}

	//preOrder
	private String preOrder(Node current, String s) {
	    if (current != null) {
		String newS = s + current.v + "," + balance(current) + " ";
		return preOrder(current.right, preOrder(current.left, newS));
	    }
	    return s;
	}

	public String preOrder() {
	    return this.preOrder(this.root, "");
	}

    }

    public static void main(String[] args) {
	
	Scanner sc = new Scanner(System.in);

	BST bst = new BST();

	String[] line = sc.nextLine().split(" ");

	for (int i = 0; i < line.length; i++)
	    bst.add(Integer.parseInt(line[i]));

	String bstPreOrder = bst.preOrder();

	System.out.println(bstPreOrder.substring(0, bstPreOrder.length() - 1));

	sc.close();

    }

}
