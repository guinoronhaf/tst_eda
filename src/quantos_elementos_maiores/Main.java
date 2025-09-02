package quantos_elementos_maiores;

import java.util.Scanner;
import java.util.Arrays;
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
	private int size;

	public boolean isEmpty() {
	    return this.root == null;
	}

	//add
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
	    this.size++;
	}

	//maioresDoQueN
	public int maioresDoQueN(int n) {

	    int count = 0;

	    if (this.isEmpty())
		return count;
	    else {

		LinkedList<Node> queue = new LinkedList<>();

		queue.addLast(this.root);

		while (!queue.isEmpty()) {
		    Node current = queue.removeFirst();
		    if (current.v > n) count ++;
		    if (current.left != null)
			queue.addLast(current.left);
		    if (current.right != null)
			queue.addLast(current.right);
		}

		return count;
	    
	    }

	}

	//preOrder
	private String preOrder(Node current, String s) {
	    if (current == null)
		return s;
	    else {
		String newS = s + current.v + " ";
		return preOrder(current.right, preOrder(current.left, newS));
	    }
	}

	public String preOrder() {
	    return this.preOrder(this.root, "");
	}

	//size
	public int size() {
	    return this.size;
	}
    
    }

    public static void main(String[] args) {

	Scanner sc = new Scanner(System.in);

	BST bst = new BST();

	String[] line = sc.nextLine().split(" ");
	int n = Integer.parseInt(sc.nextLine());

	for (int i = 0; i < line.length; i++)
	    bst.add(Integer.parseInt(line[i]));

	System.out.println(Arrays.toString(bst.preOrder().split(" ")));

	System.out.println(bst.maioresDoQueN(n));

	sc.close();

    }

}
