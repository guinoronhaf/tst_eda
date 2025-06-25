package merge_sort_passo_a_passo;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

	int[] a = {9, 1, 4, -1, 5, 9, 23, -3};
	int[] b = {3, 5, 9};
	int[] c = {1, 4, 7};
	
	int[] res = merge(b, c);

	System.out.println(Arrays.toString(res));

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

	while (i < a.length) result[k++] = a[i++];
	while (j < b.length) result[k++] = b[j++];

	return result;

    }

    public static int[] mergeSort(int[] v) {

	int meio = (v.length - 1) / 2;
	int[] comecoMeio = new int[meio + 1];
	int[] meioFinal = new int[v.length - (meio + 1)];
	for (int i = 0; i <= meio; i++)
	    comecoMeio[i] = v[i];
	for (int j = meio + 1; j <= v.length; j++)
	    meioFinal[j] = v[j];
	
	if ((comecoMeio.length + meioFinal.length) <= 2)
	    return merge(comecoMeio, meioFinal);

	mergeSort(comecoMeio);
	mergeSort(meioFinal);

    }

}
