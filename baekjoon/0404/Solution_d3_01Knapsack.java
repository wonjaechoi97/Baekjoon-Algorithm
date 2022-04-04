package p0404;
import java.io.*;
import java.util.*;

public class Solution_d3_01Knapsack {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		
		
		for(int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			int[][] thing = new int[N+1][2];
			int[][] DP = new int[N+1][K+1];
			for(int i=1; i<=N; i++) {
				st= new StringTokenizer(br.readLine(), " ");
				thing[i][0]=Integer.parseInt(st.nextToken());//부피
				thing[i][1]=Integer.parseInt(st.nextToken()); // 가치
			}
			for(int i=1; i<=N; i++) {//물건 번호
				for(int j=1; j<=K; j++) { //가방 무게
					if(j-thing[i][0]<0)DP[i][j]=DP[i-1][j];
					else {
						if(thing[i][1]+DP[i-1][j-thing[i][0]]>DP[i-1][j]) {
							DP[i][j]=thing[i][1]+DP[i-1][j-thing[i][0]];
						}else {
							DP[i][j]=DP[i-1][j];
						}
					}
					//for(int[] a: DP)System.out.println(Arrays.toString(a));
					//System.out.println("\n\n");
				}
			}
		
			sb.append("#").append(t).append(" ").append(DP[N][K]).append("\n");
		}
		System.out.println(sb.toString());
		
		
		br.close();

	}

}
