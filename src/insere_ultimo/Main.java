package insere_ultimo;

import java.util.Scanner;
import java.util.Arrays;

class Main {
	
    public static void main(String[] args) {

	Scanner sc = new Scanner(System.in);
	
	String[] numbers = sc.nextLine().split(" ");

	int i = numbers.length - 1;

	while (i > 0 && Integer.parseInt(numbers[i - 1]) > Integer.parseInt(numbers[i])) {
	    String aux = numbers[i - 1];
	    numbers[i - 1] = numbers[i];
	    numbers[i] = aux;
	    i--;
	}

	System.out.println(Arrays.toString(numbers));
    
    }

}

