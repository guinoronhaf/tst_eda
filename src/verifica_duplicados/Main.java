package verifica_duplicados;

import java.util.HashSet;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
    
        Scanner sc = new Scanner(System.in);

        String[] line = sc.nextLine().split(" ");
        int[] vector = new int[line.length];

        for (int i = 0; i < line.length; i++)
            vector[i] = Integer.parseInt(line[i]);

        System.out.println(verificaDuplicados(vector));

        sc.close();

    }

    public static boolean verificaDuplicados(int[] a) {

        HashSet<Integer> mapping = new HashSet<>();

        for (int i : a) {
            if (mapping.contains(i)) return true;
            mapping.add(i);
        }

        return false;

    }

}
