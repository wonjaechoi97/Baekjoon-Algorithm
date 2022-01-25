package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Bj1110 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n =Integer.parseInt(br.readLine());
		int tt=0;
		int x = n;
		while(true) {
			
			int ten = x/10;
			int one = x%10;
			x=one*10+(one+ten)%10;
			tt++;
			System.out.println(x);
			if(x==n) {
				break;
			}
		
		}
		System.out.println(tt);
		
		br.close();
	}
	

}
