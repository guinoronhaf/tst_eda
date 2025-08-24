package rotacoes;

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
    
    }

    public static class AVL {
	
	private Node root;
	private int size;

	//rotate_right
	private void rotateRight(Node node) {
	    node.left.parent = node.parent;
	    if (node.parent == null)
		this.root = node.left;
	    else if (node.parent.v > node.left.v)
		node.parent.left = node.left;
	    else
		node.parent.right = node.left;
	    node.parent = node.left;
	    node.left = node.parent.right;
	    node.parent.right = node;
	    if (node.left != null)
		node.left.parent = node;
	    System.out.println("rot_dir(" + node.v + ")");
	}

	//rotate_left
	private void rotateLeft(Node node) {
	    node.right.parent = node.parent;
	    if (node.parent == null)
		this.root = node.right;
	    else if (node.parent.v > node.right.v)
		node.parent.left = node.right;
	    else
		node.parent.right = node.right;
	    node.parent = node.right;
	    node.right = node.parent.left;
	    node.parent.left = node;
	    if (node.right != null)
		node.right.parent = node;
	    System.out.println("rot_esq(" + node.v + ")");
	}
	
	//balance
	public int balance(Node node) {
	    if (node == null)
		throw new IllegalArgumentException();
	    return height(node.left) - height(node.right);
	}

	//check_balance
	private void checkBalance(Node node) {

	    Node parentNode = node.parent;

	    if (parentNode != null) {

		int parentBalance = balance(parentNode);

		if (parentBalance >= 2) {
		    if (balance(node) >= 1)
			this.rotateRight(parentNode);
		    else if (balance(node) <= -1) {
			this.rotateLeft(node);
			this.rotateRight(parentNode);
		    }
		} else if (parentBalance <= -2) {
		    if (balance(node) <= -1)
			this.rotateLeft(parentNode);
		    else if (balance(node) >= 1) {
			this.rotateRight(node);
			this.rotateLeft(parentNode);
		    }
		}

		checkBalance(parentNode);
	    
	    } else {
		System.out.println("balanceada");
	    }

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
		    checkBalance(newNode);
		    return;
		}
		add(current.left, k);
	    } else {
		if (current.right == null) {
		    Node newNode = new Node(k);
		    current.right = newNode;
		    newNode.parent = current;
		    checkBalance(newNode);
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

	//preOrder
	private String preOrder(Node current, String s) {
	    if (current != null) {
		String newS = s += current.v + ", ";
		return preOrder(current.right, preOrder(current.left, newS));
	    }
	    return s;
	}

	public String preOrder() {
	    String s = preOrder(this.root, "[");
	    return s.substring(0, s.length() - 2) + "]";
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

	//bfs
	public void bfs() {
	
	    LinkedList<Node> queue = new LinkedList<>();

	    queue.addLast(this.root);

	    while (!queue.isEmpty()) {
		Node current = queue.removeFirst();
		System.out.print(current.v + "-");
		if (current.left != null)
		    queue.addLast(current.left);
		if (current.right != null)
		    queue.addLast(current.right);
	    }

	}

    }

    public static void main(String[] args) {

	AVL avl = new AVL();

	avl.add(10);
	avl.add(8);
	avl.add(12);

	System.out.println(avl.preOrder());

    }

}
