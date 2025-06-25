package estatistica_de_ordem;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	
	Scanner sc = new Scanner(System.in);

	String[] line = sc.nextLine().split(" ");
	int[] vector = new int[line.length];

	for (int i = 0; i < line.length; i++)
	    vector[i] = Integer.parseInt(line[i]);

	System.out.println(estatisticaDeOrdem(vector));

    }

    private static void swap(int[] v, int i, int j) {
	int aux = v[i];
	v[i] = v[j];
	v[j] = aux;
    }

    public static int estatisticaDeOrdem(int[] v) {
	
	int ini = 0;
	int fim = v.length - 1;

	int pivot = v[ini];
	int i = ini + 1;
	int j = fim;

	while (i <= j) {

	    while (i <= j && v[i] <= pivot) i++;
	    while (i <= j && v[j] > pivot) j--;

	    if (i < j) swap(v, i, j);
	
	}

	swap(v, ini, j);

	return j + 1;
    
    }
}
