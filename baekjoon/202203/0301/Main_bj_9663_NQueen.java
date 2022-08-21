package practice0301;
import java.io.*;
import java.util.*;
public class Main_bj_9663_NQueen {
	static int count=0;
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		
		solve(N, 0, new boolean[N], new int[N]);
		System.out.println(count);
		br.close();

	}
	static void solve(int N, int cnt, boolean[] v, int[] out) {
		if(cnt==N) {
			
			count++;
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(v[i])continue;
			boolean check = false;
			for(int j=1; j<=cnt; j++) {
				if(i == out[cnt-j]-j||i == out[cnt-j]+j) {
					check=true;
					break;
				}
			}
			if(check)continue;
			v[i]=true;
			out[cnt]=i;
			solve(N, cnt+1, v, out);
			v[i]=false;
		}
	}

}
