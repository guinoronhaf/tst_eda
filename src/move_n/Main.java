package move_n;

import java.util.Scanner;
import java.util.Arrays;

public class Main {
	
    public static void main(String[] args) {

	Scanner sc = new Scanner(System.in);

	String[] line = sc.nextLine().split(" ");
	int[] values = new int[line.length];

	for (int i = 0; i < line.length; i++)
	    values[i] = Integer.parseInt(line[i]);

	moveN(values);

	sc.close();

    }

    public static void swap(int[] v, int i, int j) {
	int aux = v[i];
	v[i] = v[j];
	v[j] = aux;
    }

    public static void insereOrdenado(int[] v, int pos) {

	int i = pos;

	while (i > 0 && v[i] < v[i - 1]) {
	    swap(v, i - 1, i);
	    System.out.println(Arrays.toString(v));
	    i--;
	}

    }

    public static int quebraOrdem(int[] v) {

	for (int i = v.length - 1; i > 0; i--)
	    if (v[i] < v[i - 1])
		return i;

	return 0;

    }

    public static void moveN(int[] v) {

	int i = quebraOrdem(v);

	while (i <= v.length - 1) {
	    insereOrdenado(v, i);
	    i++;
	}

    }

}
