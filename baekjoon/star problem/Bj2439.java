package baek;

import java.util.Scanner;

public class Bj2439 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N= sc.nextInt();
		
		for(int i=1;i<=N;i++) {
			for(int x=1; x<=N-i;x++) System.out.print(" ");
			for(int j =1; j<=i;j++ ) {
				System.out.print("*");
			}
			System.out.println();
		}
		sc.close();

	}

}
