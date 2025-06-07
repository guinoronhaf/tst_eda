import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        int[] v = {};

        System.out.println("\n----------------");

        System.out.println(Arrays.toString(v));

        System.out.println("----------------");

        trocaVizinhos(v);

        System.out.println(Arrays.toString(v));

    }

    public static void trocaVizinhos(int[] v) {

        int limite = (v.length % 2 == 0) ? v.length - 1 : v.length - 2;

        for (int i = 0; i < limite; i += 2) {
            var vizinhoEsquerda = v[i];
            v[i] = v[i + 1];
            v[i + 1] = vizinhoEsquerda;
        }

    }

}
