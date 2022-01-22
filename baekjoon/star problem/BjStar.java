package baek;

import java.util.Scanner;

public class BjStar {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//2440문제
		/*
		int N =sc.nextInt();
		
		for(int i =0 ; i<N;i++) {
			for(int j=0;j<N-i;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		sc.close();
		*/
		int N = sc.nextInt();
		for(int i =0; i<N; i++) {
			for(int x =0; x<i;x++) {
				System.out.print(" ");
			}
			for(int j=0; j<N-i;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		

	}

}
