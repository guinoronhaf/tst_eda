package radix_dois_digitos;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
    
        Scanner sc = new Scanner(System.in);

        String[] line = sc.nextLine().split(" ");
        int[] vector = new int[line.length];

        for (int i = 0; i < line.length; i++)
            vector[i] = Integer.parseInt(line[i]);

        int digits = Integer.parseInt(sc.nextLine());

        radixSortDoisDigitos(vector, digits);

        sc.close();

    }

    public static int highestValue(int[] a, int d) {

        int mod = (int) Math.pow(10, d), divid = (int) Math.pow(10, d - 2);

        int highest = (a[0] % mod) / divid, i = 1;

        while (i < a.length) {
            if ((a[i] % mod) / divid > highest)
                highest = (a[i] % mod) / divid;
            i++;
        }

        return highest;

    }

    public static int lowestValue(int[] a, int d) {

        int mod = (int) Math.pow(10, d), divid = (int) Math.pow(10, d - 2);

        int lowest = (a[0] % mod) / divid, i = 1;

        while (i < a.length) {
            if ((a[i] % mod) / divid < lowest)
                lowest = (a[i] % mod) / divid;
            i++;
        }

        return lowest;

    }

    public static int[] adaptedCountingSort(int[] a, int d) {

        int mod = (int) Math.pow(10, d), divid = (int) Math.pow(10, d - 2);

        int highest = highestValue(a, d);
        int lowest = lowestValue(a, d);

        int[] c = new int[highest - lowest + 1];
        int[] b = new int[a.length];

        for (int i : a)
            c[((i % mod) / divid)- lowest] += 1;

        for (int i = 1; i < c.length; i++)
            c[i] = c[i] + c[i - 1];

        for (int i = a.length - 1; i >= 0; i--) {
            b[c[((a[i] % mod) / divid) - lowest] - 1] = a[i];
            c[((a[i] % mod) / divid) - lowest] -= 1;
        }

        return b;
    
    }

    public static void radixSortDoisDigitos(int[] a, int d) {

        int count = 2;

        while (count <= d) {
            a = adaptedCountingSort(a, count);
            System.out.println(Arrays.toString(a));
            count += 2;
        }
    
    }


}
