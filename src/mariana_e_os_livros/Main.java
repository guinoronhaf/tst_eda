package mariana_e_os_livros;

import java.util.Scanner;
import java.util.Arrays;

class Main {

    public static void main(String[] args) {

	Scanner sc = new Scanner(System.in);

	String[] books = sc.nextLine().split(",");
	
	sort(books);

    }
	
    public static void swap(String[] v, int i, int j) {
       String aux = v[i];
       v[i] = v[j];
       v[j] = aux;
    }
	
    public static void sort(String[] v) {

	System.out.println(formatArray(v));

	for (int i = 1; i < v.length; i++) {

	    int j = i; 

	    while (j > 0 && v[j - 1].compareTo(v[j]) > 0) {
		swap(v, j - 1, j);
		j--;  
	    }

	    System.out.println(formatArray(v));

	}

    }

    public static String formatArray(String[] v) {
   	
	String out = "";
	int i = 0;
	
	while (i < v.length - 1) {
	    out += v[i] + ", ";
	    i++;
	}

	return out + v[i];

    }

}
