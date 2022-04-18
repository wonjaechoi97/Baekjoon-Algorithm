package p0417;
import java.io.*;
import java.util.*;

public class Main_bj_9148_신나는함수실행2 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb= new StringBuilder();
		int[][][] dp = new int[21][21][21];
		

		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			int c=Integer.parseInt(st.nextToken());
			if(a==-1&&b==-1&&c==-1) {
				break;
			}
			boolean[][][] v = new boolean[21][21][21];
			int result = solve(dp, a, b, c, v);
			sb.append("w("+a+", "+b+", "+c+") ="+" "+result).append("\n");
			
		}
		System.out.println(sb.toString());
		br.close();

	}
	static int solve(int[][][] dp, int a, int b, int c, boolean[][][] v) {
		if(a<=0 || b<=0||c<=0) {
			return 1;
		}else if(a>20||b>20||c>20) {
			return solve(dp, 20, 20, 20, v);
		}
		if(v[a][b][c]) {
			return dp[a][b][c];
		}
		if(a<b&&b<c) {
			v[a][b][c]=true;
			dp[a][b][c]=solve(dp, a, b, c-1, v)+solve(dp, a, b-1, c-1, v)-solve(dp, a, b-1, c, v);
			return dp[a][b][c];
		}else {
			v[a][b][c]=true;
			dp[a][b][c]=solve(dp, a-1, b, c, v)+solve(dp, a-1, b-1, c, v)+solve(dp, a-1, b, c-1, v)-solve(dp, a-1, b-1, c-1, v);
			return dp[a][b][c];
		}
	}

}
