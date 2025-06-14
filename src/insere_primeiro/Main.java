package insere_primeiro;

import java.util.Scanner;
import java.util.Arrays;

class Main {
	
    public static void main(String[] args) {
	
    	Scanner sc = new Scanner(System.in);

	String[] numbers = sc.nextLine().split(" ");

	int i = 0;

	while (i < numbers.length - 1 && Integer.parseInt(numbers[i]) > Integer.parseInt(numbers[i + 1])) {
	    String aux = numbers[i + 1];
	    numbers[i + 1] = numbers[i];
	    numbers[i] = aux;
	    i++;	
	}
	
	System.out.println(Arrays.toString(numbers));
    
    }


}
