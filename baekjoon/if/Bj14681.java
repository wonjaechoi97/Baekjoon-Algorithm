package baek;

import java.util.Scanner;

public class Bj14681 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();
		int re = 0;
		
		if(x>0) {
			if(y>0) re =1;
			else re = 4;
		}else {
			if(y>0) re =2;
			else re = 3;
		}
		
		System.out.println(re);
		
		sc.close();

	}

}
