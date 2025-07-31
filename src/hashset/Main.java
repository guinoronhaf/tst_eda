package hashset;

import java.util.Scanner;
import java.util.Arrays;

public class Main {

    public static class HashSet {

	private Integer[] set;
	private int size;

	public HashSet(int capacity) {
	    this.set = new Integer[capacity];
	    this.size = 0;
	}

	public boolean isFull() {
	    return this.size == this.set.length;
	}

	public int hash(int key) {
	    return key % this.set.length;
	}

	public int putProbing(int key) {

	    int keyHash = hash(key);
	    int count = 0;

	    while (this.set[keyHash] != null) {
		count++;
		keyHash = hash(key + count);
	    }

	    return keyHash;
	
	}

	public void put(Integer key) {

	    if (this.isFull()) return;

	    if (this.contains(key)) return;

	    int finalHash = putProbing(key);

	    this.set[finalHash] = key;

	    this.size++;

	}

	public boolean contains(Integer key) {
	
	    int keyHash = hash(key);
	    int probCount = 0;
	    int count = 0;

	    while (count < this.set.length) {
		if (key.equals(this.set[keyHash])) return true;
		probCount++;
		keyHash = hash(key + probCount);
		count++;
	    }

	    return false;

	}

	public Integer remove(Integer key) {
	
	    int keyHash = hash(key);
	    int probCount = 0;
	    int count = 0;
	    Integer result = null;

	    while (count < this.set.length) {
		if (key.equals(this.set[keyHash])) {
		    result = this.set[keyHash];
		    this.set[keyHash] = null;
		    this.size--;
		    break;
		}
		probCount++;
		keyHash = hash(key + probCount);
		count++;
	    }

	    return result;

	}

	@Override
	public String toString() {
	    return Arrays.toString(this.set);
	}

    }

    public static void main(String[] args) {

	Scanner sc = new Scanner(System.in);

	Integer capacity = Integer.parseInt(sc.nextLine());

	HashSet set = new HashSet(capacity);

	String[] input = sc.nextLine().split(" ");

	while (!input[0].equals("end")) {
	    String operation = input[0];
	    Integer value = Integer.parseInt(input[1]);
	    if (operation.equals("put")) {
		set.put(value);
		System.out.println(set);
	    } else if (operation.equals("contains")) {
		System.out.println(set.contains(value));
	    } else {
		set.remove(value);
		System.out.println(set);
	    }
	    input = sc.nextLine().split(" ");
	}

	sc.close();

    }

}
