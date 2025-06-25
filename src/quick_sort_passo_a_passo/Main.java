package quick_sort_passo_a_passo;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

	Scanner sc = new Scanner(System.in);

	String[] line = sc.nextLine().split(" ");
	int[] vector = new int[line.length];
	
	for (int i = 0; i < line.length; i++)
	    vector[i] = Integer.parseInt(line[i]);

	quickSort(vector, 0, vector.length - 1);

    }
	
    private static void imprimeArray(int[] v) {

	String resultado = "";

	for (int i : v) resultado += i + " ";

	resultado = resultado.trim();

	System.out.println(resultado);

    }

    private static void swap(int[] v, int i, int j) {
	int aux = v[i];
	v[i] = v[j];
	v[j] = aux;
    }

    public static int particiona(int[] v, int ini, int fim) {
	
	int pivot = v[ini];
	int i = ini;
	int j = ini + 1;

	while (j <= fim) {
	    if (v[j] <= pivot) {
		i++;
		swap(v, i, j);
	    }
	    j++;
	}

	swap(v, ini, i);

	return i;

    }

    public static void quickSort(int[] v, int ini, int fim) {

	if (ini < fim) {
	    int posPivot = particiona(v, ini, fim);
	    imprimeArray(v);
	    quickSort(v, ini, posPivot - 1);
	    quickSort(v, posPivot + 1, fim);
	}

    }

}
