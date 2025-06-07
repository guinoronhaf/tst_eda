import java.util.Arrays;

public class BubbleSort {

  public static void main(String[] args) {
    int[] v = { 5, 13, 3, 4, 8 };
    System.out.println("\n---------------");
    System.out.println(Arrays.toString(v));
    System.out.println("---------------");
    bubbleSort(v);
    System.out.println(Arrays.toString(v));
  }

  public static void bubbleStep(int[] v, int inicio) {
    for (int i = 0; i < v.length - 1; i++) {
      if (v[i] > v[i + 1]) {
        var atual = v[i];
        v[i] = v[i + 1];
        v[i + 1] = atual;
      }
    }
  }

  public static int[] bubbleSort(int[] v) {
    for (int i = 0; i < v.length; i++) {
      bubbleStep(v, i);
    }
    return v;
  }

}
