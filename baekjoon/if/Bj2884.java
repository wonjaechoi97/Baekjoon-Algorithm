package baek;

import java.util.Scanner;

public class Bj2884 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int h = sc.nextInt();
		int min = sc.nextInt();
		int nh=0;
		int nm=0;
		
		if(min-45>=0) {
			nh=h;
			nm=min-45;
		}else {
			if (h-1<0) {
				nh=23;
			}else {
			nh=h-1;
			
			}
			nm=60+min-45;
		}
		
		System.out.println(nh+" "+nm);
		
		sc.close();
	}

}
