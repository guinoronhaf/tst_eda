package is_heap;

import java.util.Scanner;

public class Main {

    public static class Heap {

	private int[] heap;
	private int tail;

	public Heap(int[] heap) {
	    this.heap = heap;
	    this.tail = this.heap.length - 1;
	}

	private boolean isValidIndex(int index) {
	    return index >= 0 && index <= this.tail;
	}

	private int parent(int index) {
	    return Math.floorDiv(index - 1, 2);
	}

	public boolean isHeap() {
	
	    int idx = 1;

	    while (idx <= this.tail) {
		int idxParent = this.parent(idx);
		if (this.isValidIndex(idxParent) && this.heap[idxParent] < this.heap[idx])
		    return false;
		idx++;
	    }

	    return true;

	}
    
    }

    public static void main(String[] args) {

	Scanner sc = new Scanner(System.in);

	String[] line = sc.nextLine().split(" ");
	int[] values = new int[line.length];

	for (int i = 0; i < line.length; i++)
	    values[i] = Integer.parseInt(line[i]);

	Heap h = new Heap(values);

	System.out.println(h.isHeap());

	sc.close();

    }

}
