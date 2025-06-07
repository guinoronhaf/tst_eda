public class VetorCircular {

  public static void main(String[] args) {
    System.out.println(vetorCircular(new int[] { 3, 4, 2 }, 8));
  }

  public static String vetorCircular(int[] v, int qtde) {

    String res = "";
    int i = 0, cont = 0;

    while (cont < qtde) {
      res += Integer.valueOf(v[i]).toString() + " ";
      i = (i >= v.length - 1) ? i = 0 : i + 1;
      cont++;
    }

    return res;

  }

}
