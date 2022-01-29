package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Bj1065function {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int num =0;
		for(int i=1; i<=N;i++) {
		
			
			if(han(i))num++;
		}
		
		System.out.println(num);
		br.close();

	}
	public static boolean han (int n) {
		if(n<100) return true;
		int o = n%10;
		n=n/10;
		int p = n%10;
		n=n/10;
		int dif= p -o;
		
		while(n!=0) {
			int q=n%10;
			if(q-p!=dif) return false;
			p=q;
			n/=10;
		}
		return true;
	}

}
