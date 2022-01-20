package baek;


// 입력 된 두 수의 합을 구하는 문제 간다히 for문을 사용하여 해결!
import java.util.Scanner;

public class Bj10950 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int A=0, B=0;
		
		for(int i=0; i<T;i++) {
			A=sc.nextInt();
			B=sc.nextInt();
			System.out.println(A+B);
		}
		sc.close();

	}

}
