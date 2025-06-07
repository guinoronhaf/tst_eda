public class Primo {

  public static void main(String[] args) {
    System.out.println(ePrimo(15));
  }

  public static boolean ePrimo(int n) {

    int nSqrt = (int) Math.sqrt(n);

    for (int i = 2; i <= nSqrt; i++) {
      if (n % i == 0)
        return false;
    }

    return true;

  }

}
