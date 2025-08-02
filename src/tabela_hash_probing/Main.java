package tabela_hash_probing;

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
	public boolean equals(Object o) {
	    if (o == null) return false;
	    if (!(o instanceof Entry)) return false;
	    Entry oEntry = (Entry) o;
	    return (this.key.equals(oEntry.key)) && (this.value.equals(oEntry.value));
	}

	@Override
	public String toString() {
	    return "<" + this.key + ", " + this.value + ">";
	}
    
    }

    public static class MyHashTable {
	
	private Entry[] table;

	private final Entry DELETED_ENTRY = new Entry(-1, "");

	public MyHashTable(int capacity) {
	    this.table = new Entry[capacity];
	}

	public int hash(int key) {
	    return key % this.table.length;
	}

	public boolean containsKey(int key) {
	
	    int probing = 0;

	    while (true) {
		int keyHash = hash(key + probing);
		if (this.table[keyHash] == null || probing >= this.table.length) {
		    return false;
		} else if (this.table[keyHash].getKey().equals(key)) {
		    return true;
		}
		probing++;
	    }

	}

	@Override
	public String toString() {
	    return Arrays.toString(this.table);
	}

    }

    public static void main(String[] args) {
	
	MyHashTable h = new MyHashTable(5);

	System.out.println(h);

    }

}
