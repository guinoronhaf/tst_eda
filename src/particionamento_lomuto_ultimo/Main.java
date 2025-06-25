package particionamento_lomuto_ultimo;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	
	Scanner sc = new Scanner(System.in);
	
	String[] line = sc.nextLine().split(" ");
	int[] vector = new int[line.length];

	for (int i = 0; i < line.length; i++)
	    vector[i] = Integer.parseInt(line[i]);

	particionamentoLomutoPeloUltimo(vector);

	System.out.println(Arrays.toString(vector));

    }

    private static void swap(int[] v, int i, int j) {
	int aux = v[i];
	v[i] = v[j];
	v[j] = aux;
    }

    public static void particionamentoLomutoPeloUltimo(int[] v) {
   	
	int ini = 0;
	int fim = v.length - 1;

	int pivot = v[fim];
	int i = fim - 1;
	int j = fim - 1;

	while (j >= 0) {
	    if (v[j] > pivot) {
		swap(v, j, i);
		i--;
		System.out.println(Arrays.toString(v));
	    }
	    j--;
	}
	
	i++;
	swap(v, i, fim);

	System.out.println(Arrays.toString(v));

    }

}
