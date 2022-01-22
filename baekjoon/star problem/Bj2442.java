package baek;

import java.util.Scanner;

public class Bj2442 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N =sc.nextInt();
		
		for(int i=0; i <N; i++) {
			for(int x=0; x<N-i-1;x++) {
				System.out.print(" ");
			}
			for(int j=0; j<=i*2; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		sc.close();

	}

}
