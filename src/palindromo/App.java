public class App {

    public static void main(String[] args) {
        char[] v = { 'c', 'a', 's', 'a' };
        System.out.println("\n---------------");
        System.out.println(verificaPalindromo(v));
    }

    public static boolean verificaPalindromo(char[] v) {

        int left = 0, right = v.length - 1;

        while (right > left) {
            if (v[left] != v[right]) {
                return false;
            }
            left++;
            right--;
        }

        return true;

    }

}
