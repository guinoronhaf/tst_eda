package predecessor_bst;

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
    
    }

    public static void main(String[] args) {
   	System.out.println("testando");
    }

}
