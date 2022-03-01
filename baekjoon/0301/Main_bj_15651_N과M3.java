package practice0301;
import java.io.*;
import java.util.*;
public class Main_bj_15651_N과M3 {
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st =new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		
		int M = Integer.parseInt(st.nextToken());
		
		solve(0,N,M, new int[M]);
		System.out.println(sb.toString());
		br.close();
	}
	
	static void solve(int cnt, int N, int M, int[] out) {
		
		if(cnt == M) {
			for(int i=0; i<M;i++) {
				sb.append(out[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		for(int i=1;i<=N;i++) {
			out[cnt]=i;
			solve(cnt+1, N,M, out);
		}
	}

}
