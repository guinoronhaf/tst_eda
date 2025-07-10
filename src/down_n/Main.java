package down_n;

import java.util.Scanner;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

	Scanner sc = new Scanner(System.in);

	String[] line = sc.nextLine().split(" ");
	int[] values = new int[line.length];

	for (int i = 0; i < line.length; i++)
	    values[i] = Integer.parseInt(line[i]);

	int k = Integer.parseInt(sc.nextLine());

	System.out.println(downN(values, k));

	sc.close();

    }

    public static String downN(int[] v, int k) {

	String res = "";
	int count = 1;

	while (count <= k) {
	    res += Integer.toString(quickSelect(v, count, 0, v.length - 1)) + " ";
	    count++;
	}

	return res.trim();

    }

    public static void swap(int[] v, int i, int j) {
	int aux = v[i];
	v[i] = v[j];
	v[j] = aux;
    }

    public static int partitioning(int[] v, int ini, int fim) {

	int pivot = v[ini];
	int i = ini + 1;
	int j = fim;

	while (i <= j) {

	    while (i <= j && v[i] <= pivot) i++;
	    while (i <= j && v[j] > pivot) j--;

	    if (i < j) swap(v, i, j);

	}

	swap(v, ini, j);

	return j;

    }

    public static int quickSelect(int[] v, int k, int ini, int fim) {

	int posPivot = partitioning(v, ini, fim);

	if (posPivot > k - 1)
	    return quickSelect(v, k, ini, posPivot - 1);
	else if (posPivot < k - 1)
	    return quickSelect(v, k, posPivot + 1, fim);

	return v[posPivot];
    
    }
 
}
