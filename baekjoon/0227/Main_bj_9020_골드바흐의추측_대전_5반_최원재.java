package practice0227;
import java.io.*;
import java.util.*;
public class Main_bj_9020_골드바흐의추측_대전_5반_최원재 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0; t<T;t++) {
			int a=0;
			int b=0;
			int min=Integer.MAX_VALUE;
			int N = Integer.parseInt(br.readLine());
			label:for(int n=2; n<=N/2;n++ ) {
				for(int i=2;i<=Math.sqrt(n);i++) {
					if(n%i==0) {
						
						continue label;
					}
				}				
				for(int i=2;i<=Math.sqrt(N-n);i++) {
					if((N-n)%i==0) {
						//System.out.println(i);
						continue label;
					}
				}					
				if(Math.abs(N-2*n)<min) {
					min =Math.abs(N-2*n); 
					a=n;
					b=N-n;
				}				
			}
			sb.append(a).append(" ").append(b).append("\n");			
		}
		System.out.println(sb.toString());	
		br.close();
	}
}
