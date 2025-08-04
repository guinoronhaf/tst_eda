package tabela_hash_open_addressing;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static class Entry {

	private Integer key;
	private String value;

	public Entry(Integer key, String value) {
	    this.key = key;
	    this.value = value;
	}

	public Integer getKey() {
	    return this.key;
	}

	public String getValue() {
	    return this.value;
	}

	@Override
	public String toString() {
	    return "<" + this.key + ", " + this.value + ">";
	}

    }

    public static class MyHashTable {

	private Entry[] table;
	private int size;

	public MyHashTable(int capacity) {
	    this.table = new Entry[capacity];
	    this.size = 0;
	}

	public boolean isFull() {
	    return this.size == this.table.length;
	}

	public int hash(int key) {
	    return key % this.table.length;
	}

	public void put(Integer key, String value) {
	
	    if (this.contains(key)) {
		this.remove(key);
	    }

	    if (this.isFull()) return;

	    int probing = 0;

	    while (true) {
		int keyHash = hash(key + probing);
		if (this.table[keyHash] == null) {
		    this.table[keyHash] = new Entry(key, value);
		    this.size++;
		    break;
		}
		probing++;
	    }

	}

	public void remove(Integer key) {

	    int probing = 0;

	    while (true) {
		int keyHash = hash(key + probing);
		if (probing >= this.table.length) {
		    break;
		} else if (this.table[keyHash] != null && this.table[keyHash].getKey().equals(key)) {
		    this.table[keyHash] = null;
		    this.size--;
		    break;
		}
		probing++;
	    }
	
	}

	public boolean contains(Integer key) {

	    int probing = 0;

	    while (true) {
		int keyHash = hash(key + probing);
		if (probing >= this.table.length) {
		    return false;
		} else if (this.table[keyHash] != null && this.table[keyHash].getKey().equals(key)) {
		    return true;
		}
		probing++;
	    }

	}

	public int[] getKeys() {

	    int[] keys = new int[this.size];

	    int keysIdx = 0;
	    int tableIdx = 0;

	    while (tableIdx < this.table.length) {
		Entry entry = this.table[tableIdx++];
		if (entry != null)
		    keys[keysIdx++] = entry.getKey();
	    }

	    Arrays.sort(keys);

	    return keys;

	}

	public String[] getValues() {

	    String[] values = new String[this.size];

	    int valuesIdx = 0;
	    int tableIdx = 0;

	    while (tableIdx < this.table.length) {
		Entry entry = this.table[tableIdx++];
		if (entry != null)
		    values[valuesIdx++] = entry.getValue();
	    }

	    Arrays.sort(values);

	    return values;
	}

	public int size() {
	    return this.size;
	}

	@Override
	public String toString() {
	    return Arrays.toString(this.table);
	}
    
    }

    public static void main(String[] args) {

	Scanner sc = new Scanner(System.in);

	Integer capacity = Integer.parseInt(sc.nextLine());

	MyHashTable table = new MyHashTable(capacity);

	String[] line = sc.nextLine().split(" ");

	while (!line[0].equals("end")) {
	    String operation = line[0];
	    if (operation.equals("put")) {
		table.put(Integer.parseInt(line[1]), line[2]);
		System.out.println(table);
	    } else if (operation.equals("remove")) {
		table.remove(Integer.parseInt(line[1]));
		System.out.println(table);
	    } else if (operation.equals("contains")) {
		System.out.println(table.contains(Integer.parseInt(line[1])));
	    } else if (operation.equals("keys")) {
		System.out.println(Arrays.toString(table.getKeys()));
	    } else {
		System.out.println(Arrays.toString(table.getValues()));
	    }
	    line = sc.nextLine().split(" ");
	}

	sc.close();

    }

}
