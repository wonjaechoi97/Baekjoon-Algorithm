package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Bj2231brute {
/*1부터 숫자를 올린다,
 * %를 활용해서 각 숫자에 더해주도록 한다. 
 */
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String S = br.readLine();
		int len = S.length();
		int N = Integer.parseInt(S);
		boolean k = true;
		for(int i = 1;i<N;i++ ) {
			int sum = 0;
			int x=i;
			for(int t=(int)Math.pow(10, len-1); t>=1;t=t/10) {
				sum=sum+x/t;
				x=x-(x/t)*t;
				
			}
			//System.out.println(i+" "+(sum+i));
			if(sum+i==N) {
				System.out.println(i);
				k=false;
				break;
			}
			
		}
		if(k) System.out.println(0);
		br.close();
	}

}
