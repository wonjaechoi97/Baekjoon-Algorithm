package algo202304;

import java.io.*;
import java.util.*;

public class Main_codeTree_외주수익최대화하기 {

	static int max = -1;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] work = new int[n][2];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			work[i][0] = Integer.parseInt(st.nextToken());
			work[i][1] = Integer.parseInt(st.nextToken());
		}
		
		/*
		 * // for (int[] a : work) // System.out.println(Arrays.toString(a));
		 */
		int[] dp = new int[n];
		
		solve(dp, 0, 0,0, n, work);
		
		if(max ==-1)System.out.println(0);
		else System.out.println(max);
		

		br.close();
	}

	static void solve(int[] dp, int cur, int earn,int point, int n, int[][] work) {
		
		if(cur>0 && cur <=n) {
			if(earn+point>dp[cur-1]) {
				dp[cur-1]=earn+point;
				earn += point;
				if(earn>max)max = earn;
			}else {
				return;
			}
		}else if(cur>n) {
			return;
		}
		
		for(int i=cur; i<n; i++) {
			solve(dp, i+work[i][0]/*다음 위치*/, earn,work[i][1],n, work);
		}
	}

}
