package baek;


// 구구단 출력
//단을 입력하면 구구단 출력!!
import java.util.Scanner;

public class Bj2739 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		for(int i=1; i<=9;i++) {
			System.out.println(N+" * "+i+" = "+N*i);
			
		}
		sc.close();

	}

}
