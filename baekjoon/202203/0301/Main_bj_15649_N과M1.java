package practice0228;
import java.io.*;
import java.util.*;
public class Main_bj_15649_N과M1 {
	static int[] out;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		out = new int[M];
		permutation(N,M, 0, new boolean[N+1]);
		
		System.out.println(sb.toString());
		br.close();

	}
	static void permutation(int N, int M, int cnt, boolean[] v) {
		if(cnt == M) {
			for(int i=0; i<M;i++) {
				sb.append(out[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		
		for(int i=1; i<=N;i++) {
			if(v[i])continue;
			v[i]=true;
			out[cnt]=i;
			permutation(N, M, cnt+1, v);
			v[i]=false;
		}
	}

}
