package baek;

import java.util.Scanner;

public class Bj1330 {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();
		
		if(x>y) System.out.println(">");
		else if(y>x) System.out.println("<");
		else System.out.println("==");
		sc.close();

	}
	

}
