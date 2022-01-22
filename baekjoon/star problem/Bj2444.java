package baek;

import java.util.Scanner;

public class Bj2444 {

	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		int N = sc.nextInt();
		
		for(int i=1; i<=2*N-1;i++) {
			if(i<=N) {
			for(int x=1; x<=N-i;x++ ) {
				System.out.print(" ");
			}
			for(int j=1; j<2*i;j++) {
				System.out.print("*");
			}
			
			}else {
				for(int x=1; x<=i-N;x++) {
					System.out.print(" ");
				}
				for(int j=1; j<2*N-2*(i-N); j++) {
					System.out.print("*");
				}
			}
			System.out.println();
		}
		
		sc.close();

	}

}
