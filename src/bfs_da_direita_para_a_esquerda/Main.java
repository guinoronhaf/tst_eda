package bfs_da_direita_para_a_esquerda;

import java.util.Scanner;
import java.util.LinkedList;

public class Main {

    public static class Node {

	 int v;
	 Node parent;
	 Node left;
	 Node right;

	 public Node(int v) {
	     this.v = v;
	 }
    
    }

    public static class BST {

	private Node root;

	public boolean isEmpty() {
	    return this.root == null;
	}

	private void add(Node current, int k) {
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
	    if (this.isEmpty())
		this.root = new Node(k);
	    else
		this.add(this.root, k);
	}

	@Override
	public String toString() {

	    if (this.isEmpty())
		return "";
	    else {

		LinkedList<Node> queue = new LinkedList<>();
		String bfs = "";

		queue.addLast(this.root);

		while (!queue.isEmpty()) {
		    Node current = queue.removeFirst();
		    bfs += current.v + " ";
		    if (current.right != null)
			queue.addLast(current.right);
		    if (current.left != null)
			queue.addLast(current.left);
		}

		return bfs.substring(0, bfs.length() - 1);

	    }

	}
    
    }

    public static void main(String[] args) {

	Scanner sc = new Scanner(System.in);

	String[] line = sc.nextLine().split(" ");

	BST bst = new BST();

	for (int i = 0; i < line.length; i++)
	    bst.add(Integer.parseInt(line[i]));

	System.out.println(bst);

	sc.close();

    }

}
