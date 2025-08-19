package build_heap;

import java.util.Scanner;
import java.util.Arrays;

public class Main {

    public static class Heap {

	private int[] heap;
	private int tail;

	public Heap(int[] heap) {
	    this.heap = heap;
	    this.tail = this.heap.length - 1;
	    this.buildHeap();
	}

	private void swap(int i, int j) {
	    int aux = this.heap[i];
	    this.heap[i] = this.heap[j];
	    this.heap[j] = aux;
	}

	private boolean isValidIndex(int index) {
	    return index >= 0 && index <= this.tail;
	}

	private int maxIndex(int index, int left, int right) {
	    if (this.heap[index] > this.heap[left]) {
		if (this.isValidIndex(right)) {
		    if (this.heap[index] < this.heap[right])
			return right;
		}
		return index;
	    } else {
		if (this.isValidIndex(right)) {
		    if (this.heap[left] < this.heap[right])
			return right;
		}
		return left;
	    }
	}

	private void heapify(int index) {
	
	    if (isLeaf(index) || !isValidIndex(index)) return;

	    int indexMax = this.maxIndex(index, left(index), right(index));

	    if (indexMax != index) {
		swap(index, indexMax);
		heapify(indexMax);
	    }

	}

	private boolean isLeaf(int index) {
	    return index > parent(tail) && index <= tail;
	}

	public boolean isEmpty() {
	    return this.tail == -1;
	}

	public boolean isFull() {
	    return this.tail == this.heap.length - 1;
	}

	public int left(int index) {
	    return 2 * index + 1;
	}

	public int right(int index) {
	    return 2 * (index + 1);
	}

	public int parent(int index) {
	    return Math.floorDiv(index - 1, 2);
	}

	public void add(int k) {
	
	    if (this.isFull()) throw new RuntimeException();

	    this.heap[++this.tail] = k;

	    int i = this.tail;

	    while (i > 0 && this.heap[parent(i)] < this.heap[i]) {
		swap(parent(i), i);
		i = parent(i);
	    }

	}

	public void buildHeap() {
	
	    int lastLeafParent = parent(this.tail);

	    for (int i = lastLeafParent; i >= 0; i--)
		this.heapify(i);

	}

	public int size() {
	    return this.tail + 1;
	}
	
	@Override
	public String toString() {
	    return Arrays.toString(this.heap);
	}
    
    }

    public static void main(String[] args) {

	Scanner sc = new Scanner(System.in);

	String[] line = sc.nextLine().split(" ");
	int[] values = new int[line.length];

	for (int i = 0; i < line.length; i++)
	    values[i] = Integer.parseInt(line[i]);

	Heap h = new Heap(values);

	System.out.println(h);

	sc.close();

    }

}
