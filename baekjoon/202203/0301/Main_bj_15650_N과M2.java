package practice0301;
import java.io.*;
import java.util.*;
public class Main_bj_15650_N과M2 {
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st =new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		
		int M = Integer.parseInt(st.nextToken());
		
		solve(1,0,N,M, new int[M]);
		System.out.println(sb.toString());
		br.close();
	}
	
	static void solve(int start, int cnt, int N, int M, int[] out) {
		
		if(cnt==1&&out[0]>N-M+1) return;
		
		if(cnt == M) {
			for(int i=0; i<M;i++) {
				sb.append(out[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		for(int i=start;i<=N;i++) {
			out[cnt]=i;
			solve(i+1, cnt+1, N,M, out);
		}
	}

}
