package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Bj10809 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		
		int[] alpha = {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,
				-1,-1,-1,-1,-1,-1,-1};
		
		for(int i=0;i<input.length();i++) {
			if(alpha[input.charAt(i)-'a']==-1) {
			alpha[input.charAt(i)-'a']=i;
			}
		}
		for(int i=0; i<alpha.length;i++) {
			System.out.print(alpha[i]+" ");
		}
		
		
		}
		
		
		
		

	

}
