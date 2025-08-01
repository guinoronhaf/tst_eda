package matriz_adjacencia;

import java.util.*;

public class Main {

    public static class Edge {

	private String key;
	private int value;

	public Edge(String key, int value) {
	    this.key = key;
	    this.value = value;
	}

	public String getKey() {
	    return this.key;
	}

	public int getValue() {
	    return this.value;
	}

	public boolean keyContentEquals(String s) {

	    if (this.key.equals(s)) return true;
	
	    String aux = "";
	    int i = s.length() - 1;

	    while (i >= 0) {
		aux += s.charAt(i) + "";
		i--;
	    }

	    return this.key.equals(aux);

	}
	
	@Override
	public String toString() {
	    return "<" + this.key + ", " + this.value + ">";
	}
    
    }

    public static class MyHashTable {

	private ArrayList<Edge>[] table;

	@SuppressWarnings("unchecked")
	public MyHashTable(int capacity) {
	    this.table = new ArrayList[capacity];
	    for (int i = 0; i < this.table.length; i++)
		this.table[i] = new ArrayList<>();
	}

	public int hash(int key) {
	    return key % this.table.length;
	}

	public void put(String key, int value) {
	
	    if (this.containsKey(key)) return;

	    int keyHash = hash(Math.abs(key.hashCode()));
	    
	    this.table[keyHash].add(new Edge(key, value));

	}

	public Integer get(String key) {
		
	    int keyHash = hash(Math.abs(key.hashCode()));
	    ArrayList<Edge> edgeList = this.table[keyHash];
	    int idx = 0;
	    Integer value = null;

	    while (idx < edgeList.size()) {
		if (edgeList.get(idx).keyContentEquals(key)) {
		    value = edgeList.get(idx).getValue();
		    break;
		}
		idx++;
	    }

	    return value;

	}

	public boolean containsKey(String key) {
	    return this.get(key) != null;
	}

	@Override
	public String toString() {

	    String table = "[";
	    int idx = 0;

	    while (idx < this.table.length) {
		table += this.table[idx].toString();
		if (idx < this.table.length - 1) table += ", ";
		idx++;
	    }

	    return table + "]";

	}
     
    }

    public static void main(String[] args) {

	Scanner sc = new Scanner(System.in);

	sc.close();

    }

}
