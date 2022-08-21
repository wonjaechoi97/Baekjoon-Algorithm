package p0331;
import java.io.*;
import java.util.*;
public class Main_bj_1149_RGB거리_대전_5반_최원재 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int min = Integer.MAX_VALUE;
		int[][] dp = new int[N+1][3];

		 
		for(int i=1; i<=N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for(int j=0; j<3; j++) {
				dp[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		for(int i=1; i<=N;i++) {
			for(int j=0; j<3; j++) {
				if(j==0) {
					dp[i][j]+=dp[i-1][1]<dp[i-1][2]?dp[i-1][1]:dp[i-1][2];
				}else if(j==1) {
					dp[i][j]+=dp[i-1][0]<dp[i-1][2]?dp[i-1][0]:dp[i-1][2];
				}else {
					dp[i][j]+=dp[i-1][0]<dp[i-1][1]?dp[i-1][0]:dp[i-1][1];
				}
			}
		}
		for(int j=0; j<3; j++) {
			if(dp[N][j]<min)min=dp[N][j];
		}
		System.out.println(min);
		br.close();

	}

}
