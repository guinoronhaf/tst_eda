package insertion_sort_recursivo;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	String[] values = sc.nextLine().split(" ");
	int[] v = new int[values.length];
	int i = 0;
	while (i < values.length) {
	    v[i] = Integer.parseInt(values[i]);
	    i++;
	}
	insertionSortRecursivo(v, 1);
    }

    private static void swap(int[] v, int i, int j) {
	int aux = v[i];
	v[i] = v[j];
	v[j] = aux;
    }

    public static void insertionSortRecursivo(int[] v, int ini) {
   	
       if (ini >= v.length) return;
	
       int j = ini;

       while (j > 0 && v[j] < v[j - 1]) {
	   swap(v, j - 1, j);
	   j--;
       }

       System.out.println(Arrays.toString(v));
	
       insertionSortRecursivo(v, ini + 1);

    }


}
