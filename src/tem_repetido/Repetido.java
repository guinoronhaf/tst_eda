public class Repetido {

  public static void main(String[] args) {
    System.out.println(temRepetido(new int[] { 1, 13, 3, 4, 5, 2 }));
  }

  public static boolean temRepetido(int[] v) {

    for (int i = 0; i < v.length; i++)
      for (int j = i + 1; j < v.length; j++)
        if (v[i] == v[j])
          return true;

    return false;

  }

}
