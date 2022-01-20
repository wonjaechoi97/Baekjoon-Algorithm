package baek;


// n이 주어지면 1부터 n까지의 합을 구하는 문제 !!
import java.util.Scanner;

public class Bj8393 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int sum = 0;
		
		for(int i =1; i<=n; i++) {
			sum+=i;
		}
		System.out.println(sum);
		sc.close();

	}

}
