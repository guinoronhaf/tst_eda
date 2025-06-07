public class Divisivel {

  public static void main(String[] args) {
    System.out.println(verificaDivisivel(new int[] { 5, 13, 3, 4, 8 }));
  }

  public static boolean verificaDivisivel(int[] v) {

    for (int i = 0; i < v.length; i++)
      for (int j = i + 1; j < v.length; j++)
        if ((v[i] % v[j] == 0) || (v[j] % v[i] == 0))
          return true;

    return false;

  }

}
