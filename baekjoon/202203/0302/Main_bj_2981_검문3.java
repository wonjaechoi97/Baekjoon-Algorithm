package practice0302;
import java.io.*;
import java.util.*;
public class Main_bj_2981_검문3 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N  = Integer.parseInt(br.readLine());
		int[] num = new int[N];
		for(int i=0; i<N;i++) {
			
			num[i]= Integer.parseInt(br.readLine());

			
		}
		
		
		int gcdin = Math.abs(num[1]-num[0]);
		
		for(int i=2; i<N; i++) {
			gcdin = gcd(gcdin, Math.abs(num[i]-num[i-1]));
		}
		for(int i=2; i<=gcdin;i++) {
			if(gcdin%i ==0)sb.append(i).append(" ");
		}
		System.out.println(sb.toString());
		br.close();

	}
	static int gcd(int a, int b) {
		while(b!=0) {
			int tmp = a%b;
			a=b;
			b=tmp;
		}
		return a;
	}

}
