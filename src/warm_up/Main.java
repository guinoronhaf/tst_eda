import java.util.Scanner;

class Main {

    public static void main(String[] args) {

   	Scanner sc = new Scanner(System.in);

	String res = "";
	
	int n = Integer.parseInt(sc.nextLine());
	String[] numbers = sc.nextLine().split(" ");

	for (String s : numbers) {
	    res += (Integer.parseInt(s) * n) + " ";
	}

	System.out.println(res.trim());
    
    }

}
