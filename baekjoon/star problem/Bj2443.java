package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Bj2443 {
	public static void main(String args[]) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		for(int i=0; i< N; i++) {
			for(int x =0; x<i; x++) {
				System.out.print(" ");
			}
			for(int j=0; j<N*2-1-2*i;j++) {
				System.out.print("*");
			}
			System.out.println();
			
		}
		
	}

}
