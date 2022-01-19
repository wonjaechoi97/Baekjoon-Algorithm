package baek;

import java.util.Scanner;

public class Bj2588 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int hundred = B/100;
		int ten = (B-hundred*100)/10;
		int one = B-100*hundred-10*ten;
		
		System.out.println(A*one);
		System.out.println(A*ten);
		System.out.println(A*hundred);
		System.out.println(A*100*hundred+A*10*ten+A*one);
		sc.close();

	}
	// package 빼기
	// class명은 항상 Main!!

}
