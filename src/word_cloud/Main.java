package word_cloud;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static class Bucket {
	
	private String word;
	private int frequency;

	public Bucket(String word, int frequency) {
	    this.word = word;
	    this.frequency = frequency;
	}

	public String getWord() {
	    return this.word;
	}

	public int getFrequency() {
	    return this.frequency;
	}

	@Override
	public String toString() {
	    return "(" + this.word + ", " + this.frequency + ")";
	}

    }

    public static class HashTable {

	private ArrayList<Bucket>[] table;
	
	@SuppressWarnings("unchecked")
	public HashTable(int capacity) {
	    this.table = new ArrayList[capacity];
	    for (int i = 0; i < capacity; i++)
		this.table[i] = new ArrayList<>();
	}

	public int hash(int key) {
	    return key % this.table.length;
	}

	public void put(String key, int value) {

	    if (this.containsKey(key))
		this.remove(key);

	    Bucket newBucket = new Bucket(key, value);

	    int keyHash = hash(Math.abs(key.hashCode()));

	    this.table[keyHash].add(newBucket);

	}

	public boolean containsKey(String key) {
	
	    int keyHash = hash(Math.abs(key.hashCode()));
	    ArrayList<Bucket> list = this.table[keyHash];

	    for (int i = 0; i < list.size(); i++) {
		String bucketWord = list.get(i).getWord();
		if (bucketWord.equals(key)) return true;
	    }

	    return false;

	}

	public Integer get(String key) {
	
	    int keyHash = hash(Math.abs(key.hashCode()));
	    ArrayList<Bucket> list = this.table[keyHash];
	    Integer value = null;

	    for (int i = 0; i < list.size(); i++) {
		String bucketWord = list.get(i).getWord();
		if (bucketWord.equals(key)) {
		    value = list.get(i).getFrequency();
		    break;
		}
	    }

	    return value;

	}

	public Bucket remove(String key) {
	
	    int keyHash = hash(Math.abs(key.hashCode()));
	    ArrayList<Bucket> list = this.table[keyHash];
	    Bucket result = null;

	    for (int i = 0; i < list.size(); i++) {
		String bucketWord = list.get(i).getWord();
		if (bucketWord.equals(key)) {
		    result = list.get(i);
		    list.remove(i);
		    break;
		}
	    }

	    return result;

	}

	@Override
	public String toString() {
	
	    String table = "";
	    int idx = 0;

	    while (idx < this.table.length)
		table += idx + ": " + this.table[idx++] + "\n";

	    return table;

	}
    
    }

    public static class WordCloud {

	public static HashTable solver(String s) {
	
	    String[] words = s.split(" ");
	    HashTable table = new HashTable(words.length);

	    for (int i = 0; i < words.length; i++) {
		String word = words[i];
		if (table.containsKey(word)) {
		    table.put(word, table.get(word) + 1);
		} else {
		    table.put(word, 1);
		}
	    }

	    return table;

	}
    
    }

    public static void main(String[] args) {

	Scanner sc = new Scanner(System.in);

	String line = sc.nextLine();

	HashTable table = WordCloud.solver(line);

	String input = sc.nextLine();

	while (!input.equals("fim")) {
	    Integer freq = table.get(input);
	    System.out.println((freq == null) ? 0 : freq);
	    input = sc.nextLine();
	}

	sc.close();

    } 

}
