package valor_mais_proximo_de_n;

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

	private String preOrder(Node current, String s) {
	    if (current == null)
		return "";
	    else {
		String newS = s + current.v + " ";
		return preOrder(current.right, preOrder(current.left, newS));
	    }
	}

	public String preOrder() {
	    return this.preOrder(this.root, "");
	}

	private int closestToN(Node current, int closest, int n) {


	}
 
	public int size() {
	    return this.size;
	}
    
    }
    
    public static void main(String[] args) {
	System.out.println("testando");
    }

}
