package tabela_hash_chaining;
	
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    public static class Pair {
	
	private Integer key;
	private String value;

	public Pair(Integer key, String value) {
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
	    if (!(o instanceof Pair)) return false;
	    Pair oPair = (Pair) o;
	    return this.key.equals(oPair.key);
	}

	@Override
	public int hashCode() {
	    return Objects.hash(this.key);
	}

	@Override
	public String toString() {
	    return "<" + this.key + ", " + this.value + ">";
	}

    }

    public static class MyHashTable {

	private ArrayList<Pair>[] table;
	private int size;

	@SuppressWarnings("unchecked")
	public MyHashTable(int capacity) {
	    this.table = new ArrayList[capacity];
	    for (int i = 0; i < this.table.length; i++)
		this.table[i] = new ArrayList<>();
	    this.size = 0;
	}

	private String pairListToString(int index) {

	    ArrayList<Pair> pairList = this.table[index];
	    String list = "[";
	    int idx = 0;

	    while (idx < pairList.size()) {
		list += pairList.get(idx).toString();
		if (idx < pairList.size() - 1) list += ", ";
		idx++;
	    }

	    list += "]";

	    return list;

	}

	private void setPair(Pair pair) {

	    int keyHash = hash(pair.getKey());
	    int key = pair.getKey();

	    if (this.containsKey(key)) {
		ArrayList<Pair> list = this.table[keyHash];
		for (int i = 0; i < list.size(); i++) {
		    Pair currentPair = list.get(i);
		    if (currentPair.getKey().equals(key)) {
			list.set(i, pair);
		    }
		}
	    } else {
		this.table[keyHash].add(pair);
	    }

	}
 
	public int hash(Integer key) {
	    return key % this.table.length;
	}

	public void put(Integer key, String value) {

	    Pair newPair = new Pair(key, value);

	    if (this.containsKey(key)) {
		this.setPair(newPair);
	    } else {
		int keyHash = hash(key);
		this.table[keyHash].add(newPair);
		this.size++;
	    }

	}

	public boolean containsKey(Integer key) {

	    int keyHash = hash(key);

	    ArrayList<Pair> list = this.table[keyHash];

	    for (int i = 0; i < list.size(); i++) {
		Pair currentPair = list.get(i);
		if (currentPair.getKey().equals(key))
		    return true;
	    }

	    return false;


	}

	public boolean remove(Integer key) {

	    int keyHash = hash(key);
	    ArrayList<Pair> list = this.table[keyHash];

	    for (int i = 0; i < list.size(); i++) {
		Pair currentPair = list.get(i);
		if (currentPair.getKey().equals(key)) {
		    list.remove(i);
		    this.size--;
		    return true;
		}
	    }

	    return false;

	}

	public int[] getKeys() {

	    int[] keys = new int[this.size];
	    int keysIdx = 0;
	    int tableIdx = 0;

	    while (tableIdx < this.table.length) {
		ArrayList<Pair> list = this.table[tableIdx++];
		int listIdx = 0;
		while (listIdx < list.size()) {
		    keys[keysIdx++] = list.get(listIdx).getKey();
		    listIdx++;
		}
	    }

	    Arrays.sort(keys);

	    return keys;

	}

	public String[] getValues() {

	    String[] values = new String[this.size];
	    int valuesIdx = 0;
	    int tableIdx = 0;

	    while (tableIdx < this.table.length) {
		ArrayList<Pair> list = this.table[tableIdx++];
		int listIdx = 0;
		while (listIdx < list.size()) {
		    values[valuesIdx++] = list.get(listIdx).getValue();
		    listIdx++;
		}
	    }

	    Arrays.sort(values);

	    return values;

	}

	public int size() {
	    return this.size;
	}

	@Override
	public String toString() {

	    String table = "[";
	    int idx = 0;

	    while (idx < this.table.length) {
		table += pairListToString(idx);
		if (idx < this.table.length - 1) table += ", ";
		idx++;
	    }

	    table += "]";

	    return table;

	}

    }

    public static void main(String[] args) {

	Scanner sc = new Scanner(System.in);

	int tableCapacity = Integer.parseInt(sc.nextLine());
	
	MyHashTable h = new MyHashTable(tableCapacity);

	String[] line = sc.nextLine().split(" ");

	while (!line[0].equals("end")) {
	    String operation = line[0];
	    if (operation.equals("put")) {
		Integer key = Integer.parseInt(line[1]);
		String value = line[2];
		h.put(key, value);
		System.out.println(h);
	    } else if (operation.equals("remove")) {
		Integer key = Integer.parseInt(line[1]);
		h.remove(key);
		System.out.println(h);
	    } else if (operation.equals("keys")) {
		String keys = Arrays.toString(h.getKeys());
		System.out.println(keys);
	    } else {
		String values = Arrays.toString(h.getValues());
		System.out.println(values);
	    }
	    line = sc.nextLine().split(" ");
	}
 
	sc.close();

    }

}
