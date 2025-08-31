package rotacoes;

import java.util.*;

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

    public static class AVL {

	private Node root;
	private int size;

	public boolean isEmpty() {
	    return this.root == null;
	}

	//balance
	//========================
	private int balance(Node node) {
	    return height(node.left) - height(node.right);
	}
	//========================
	
	//pending
	//========================
	private boolean isLeftPending(Node node) {
	    return balance(node) >= 2;
	}

	private boolean isRightPending(Node node) {
	    return balance(node) <= -2;
	}
	//========================
	
	//rebalance
	//========================
	private void rebalance(Node node) {
	    if (node != null) {
		if (isLeftPending(node)) {
		    int balanceLeft = balance(node.left);
		    if (balanceLeft == -1) {
			rotateLeft(node.left);
			rotateRight(node);
		    } else if (balanceLeft == 1) {
			rotateRight(node);
		    }
		} else if (isRightPending(node)) {
		    int balanceRight = balance(node.right);
		    if (balanceRight == -1) {
			rotateLeft(node);
		    } else if (balanceRight == 1) {
			rotateRight(node.right);
			rotateLeft(node);
		    }
		}
	    }
	}
	//========================
	
	//rebalanceUp
	//========================
	private void rebalanceUp(Node node) {
	    if (node == null)
		return;
	    else {
		rebalance(node);
		rebalanceUp(node.parent);
	    }
	}
	//========================
	
	//rotation
	//========================
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
	    System.out.println(Arrays.toString(this.preOrder().split(" ")));
	}

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
	    System.out.println(Arrays.toString(this.preOrder().split(" ")));
	}
	//========================

	//add
	//========================
	private void add(Node current, int k) {
	    if (current.v > k) {
		if (current.left == null) {
		    Node newNode = new Node(k);
		    current.left = newNode;
		    newNode.parent = current;
		    rebalanceUp(newNode);
		    return;
		}
		add(current.left, k);
	    } else {
		if (current.right == null) {
		    Node newNode = new Node(k);
		    current.right = newNode;
		    newNode.parent = current;
		    rebalanceUp(newNode);
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
	//========================

	//height
	//========================
	private int height(Node node) {
	    if (node == null)
		return -1;
	    return 1 + Math.max(height(node.left), height(node.right));
	}

	public int height() {
	    return this.height(this.root);
	}
	//========================
	
	//size
	//========================
	public int size() {
	    return this.size;
	}
	//========================
	
	//preOrder
	//========================
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
	//========================

	@Override
	public String toString() {
	
	    if (this.isEmpty())
		return "";
	    else {
	
		LinkedList<Node> queue = new LinkedList<>();
		String avl = "";

		queue.addLast(this.root);

		while (!queue.isEmpty()) {
		    Node current = queue.removeFirst();
		    avl += current.v + " ";
		    if (current.left != null)
			queue.addLast(current.left);
		    if (current.right != null)
			queue.addLast(current.right);
		}

		return avl.substring(0, avl.length() - 1);

	    }

	}
    
    }

    public static void main(String[] args) {

	Scanner sc = new Scanner(System.in);

	String line = sc.nextLine();
	String[] values = line.split(" ");

	AVL avl = new AVL();

	for (int i = 0; i < values.length; i++)
	    avl.add(Integer.parseInt(values[i]));

	if (avl.toString().equals(line))
	    System.out.println("balanceada");

	sc.close();

    }

}
