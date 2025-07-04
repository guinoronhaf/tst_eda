package counting_sort_passo_a_passo;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] line = sc.nextLine().split(" ");
        int[] v = new int[line.length];

        for (int i = 0; i < line.length; i++)
            v[i] = Integer.parseInt(line[i]);

        int k = Integer.parseInt(sc.nextLine());

        countingSort(v, k);

        sc.close();

    }

    private static String formataArray(int[] v) {

        String res = "";

        for (int i : v)
            res += Integer.toString(i) + " ";

        return res.trim();

    }

    public static void countingSort(int[] v, int k) {

        int[] c = new int[k + 1];
        int[] b = new int[v.length];

        for (int i : v) {
            c[i] += 1;
            System.out.println(formataArray(c));
        }

        for (int i = 1; i < c.length; i++)
            c[i] += c[i - 1];
    
        System.out.print("Cumulativa do vetor de contagem - ");
        System.out.println(formataArray(c));

        for (int i = v.length - 1; i >= 0; i--) {
            b[c[v[i]] - 1] = v[i];
            c[v[i]] -= 1;
        }

        System.out.println(formataArray(c));

        System.out.println(formataArray(b));

    }

}
