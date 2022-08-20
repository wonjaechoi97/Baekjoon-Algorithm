import java.io.*;
import java.util.*;
public class Main_bj_10870_피보나치수5 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		if(N==1) {
			System.out.println(1);
		}else if(N==0) {
			System.out.println(0);
		}
		else{pibonaci(0,1,2,N);}
		br.close();

	}
	public static void pibonaci(int a, int b,int cnt, int N) {
		if(cnt == N) {
			System.out.println(a+b);
			return;
		}
		pibonaci(b, a+b, cnt+1, N);
	}
}
