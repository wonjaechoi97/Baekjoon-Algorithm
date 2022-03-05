import java.io.*;
import java.util.*;
public class Main_bj_10163_색종이 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int[][] map = new int[1001][1001];
		int N = Integer.parseInt(br.readLine());
		int[] count = new int[N+1];
		for(int k=1; k<=N;k++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int ni, nj, w, h;			
			nj = Integer.parseInt(st.nextToken()); 
			ni = Integer.parseInt(st.nextToken()); 
			w = Integer.parseInt(st.nextToken()); 
			h = Integer.parseInt(st.nextToken()); 
			for(int i=ni; i<ni+h;i++ ) {
				for(int j=nj;j<nj+w;j++) {
					map[i][j]=k;
				}
			}			
		}
		for(int i=0; i<=1000;i++) {
			for(int j=0; j<=1000; j++) {
				for(int t=1; t<=N; t++) {
					if(map[i][j]==t)count[t]++;
				}
			}
		}
		for(int i=1; i<=N;i++) {
			sb.append(count[i]).append("\n");
		}
		System.out.println(sb.toString());
		br.close();

	}
}
