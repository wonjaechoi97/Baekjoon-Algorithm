import java.io.*;
import java.util.*;

public class Main_bj_10974_모든순열 {
	static boolean[] visited;
	static int[] output;
	static int N;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N =Integer.parseInt(br.readLine());
		visited = new boolean[N+1];
		output=new int[N];
		permutaion(0);
		br.close();
		System.out.println(sb.toString());
	}
	static void permutaion(int cnt) {
		
		if(cnt==N) {
			for(int i=0; i<N;i++) {
				sb.append(output[i]).append(" ");				
			}
			sb.append("\n");
			return;
		}
		for(int i=1; i<=N;i++) {
			if(visited[i])continue;
			visited[i]=true;
			output[cnt]=i;
			permutaion(cnt+1);
			visited[i]=false;
		}
	}

}
