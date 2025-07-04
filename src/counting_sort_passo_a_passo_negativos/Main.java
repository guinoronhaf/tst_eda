package counting_sort_passo_a_passo_negativos;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] line = sc.nextLine().split(" ");
        int[] v = new int[line.length];

        for (int i = 0; i < line.length; i++)
            v[i] = Integer.parseInt(line[i]);

        int max = Integer.parseInt(sc.nextLine());
        int min = Integer.parseInt(sc.nextLine());

        countingSort(v, max, min);

        sc.close();

    }

    public static void countingSort(int[] v, int max, int min) {

        int[] c = new int[max - min + 1];
        int[] b = new int[v.length];

        for (int i : v) {
            c[i - min] += 1;
            System.out.println(Arrays.toString(c));
        }

        for (int i = 1; i < c.length; i++)
            c[i] += c[i - 1];
    
        System.out.print("Cumulativa do vetor de contagem - ");
        System.out.println(Arrays.toString(c));

        for (int i = v.length - 1; i >= 0; i--) {
            b[c[v[i] - min] - 1] = v[i];
            c[v[i] - min] -= 1;
        }

        System.out.println(Arrays.toString(c));

        System.out.println(Arrays.toString(b));

    }

}
