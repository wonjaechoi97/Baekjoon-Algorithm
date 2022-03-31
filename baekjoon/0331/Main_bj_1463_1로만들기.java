package p0331;
import java.io.*;
import java.util.*;
public class Main_bj_1463_1로만들기 {
	static int[] mincal;
	static int min;
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		mincal=new int[N+1];
		for(int i=2; i<=N; i++) {
			min = Integer.MAX_VALUE;
			solve(i, 0);
			mincal[i]=min;
		}
		System.out.println(mincal[N]);		
		br.close();
	}
	static void solve( int n, int count) {
		if(n==1) {
			if(min>count)min=count;
			return;
		}
		if(mincal[n]!=0) {
			solve(1, mincal[n]+count);
			return;
		}
		if(n%3==0) {
			solve(n/3, count+1);
		}
		if(n%2==0) {
			solve(n/2, count+1);
		}
		solve(n-1, count+1);	
	}
}
