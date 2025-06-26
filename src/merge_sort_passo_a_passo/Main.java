package merge_sort_passo_a_passo;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

	Scanner sc = new Scanner(System.in);

	String[] line = sc.nextLine().split(" ");
	int[] vector = new int[line.length];

	for (int i = 0; i < line.length; i++)
	    vector[i] = Integer.parseInt(line[i]);

	mergeSort(vector);
	
	sc.close();

    }

    private static int[] slice(int[] v, int ini, int fim) {

	int[] res = new int[fim - ini + 1];
	int j = 0;

	for (int i = ini; i <= fim; i++)
	    res[j++] = v[i];

	return res;

    }

    public static int[] merge(int[] a, int[] b) {

	int[] result = new int[a.length + b.length];
	int i = 0, j = 0, k = 0;

	while (i < a.length && j < b.length) {
	    if (a[i] <= b[j])
		result[k++] = a[i++];
	    else
		result[k++] = b[j++];
	}

	while (i < a.length)
	    result[k++] = a[i++];
	while (j < b.length)
	    result[k++] = b[j++];
	
	System.out.println(Arrays.toString(result));

	return result;

    }

    public static int[] mergeSort(int[] v) {

	System.out.println(Arrays.toString(v));

	if (v.length > 1) {
	    int meio = (v.length - 1) / 2;
	    int[] part1 = slice(v, 0, meio);
	    int[] part2 = slice(v, meio + 1, v.length - 1);
	    return merge(mergeSort(part1), mergeSort(part2));
	}

	return v;
	// [4, 2, 1, 3]
    
    }
}
