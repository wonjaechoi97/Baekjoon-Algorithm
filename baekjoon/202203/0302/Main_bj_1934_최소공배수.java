package practice0302;
import java.io.*;
import java.util.*;
public class Main_bj_1934_최소공배수 {
	static int bae = 0;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		for(int t=0; t<N ;t++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int ba=0;
			if(a>b) {
				ba =GCD(a,b);
			}else {
				ba = GCD(b,a);
			}
			sb.append(a*b/ba).append("\n");
		}
		System.out.println(sb.toString());
		
		
		br.close();

	}
	static int GCD(int a , int b) {
		while(b>0) {
			int tmp = b;
			b= a%b;
			a=tmp;
		}
		return a;
	
	}

}
