package practice0226;
import java.io.*;
import java.util.*;
public class Main_bj_14888_연산자끼워넣기2 {
	static int min = Integer.MAX_VALUE;
	static int max = Integer.MIN_VALUE;
	static int[] res;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[] nums = new int[N];
		int[] op = new int[N-1];
		res = new int[N-1];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<N;i++) {
			nums[i]= Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		int cnt=0;
		for(int i=0; i<4;i++) {
			int li = Integer.parseInt(st.nextToken());
			for(int j=0;j<li;j++) {
				op[cnt]=i;
				cnt++;
			}
		}
		solve(N, new boolean[N-1], 0, op, nums,nums[0]);
		sb.append(max).append("\n").append(min);
		System.out.println(sb.toString());
		br.close();

	}
		static void solve(int N,boolean[] v, int count,int[] op, int[] nums, int sum  ) {//연산자 수는 N-1이다 기억!!
			if(count==N-1) {
				
				if(sum<min)min = sum;
				if(sum>max)max = sum;
				return;
			}			
			for(int i=0; i<N-1;i++) {
				if(v[i])continue;
				v[i]=true;
				res[count]=op[i];
				int a = 0;
				if(op[i]==0) {
					a= sum+nums[count+1];
				}else if(op[i]==1) {
					a= sum-nums[count+1];
				}else if(op[i]==2) {
					a= sum*nums[count+1];
				}else {
					a= sum/nums[count+1];
				}
				solve(N, v, count+1, op, nums, a);
				v[i]=false;
			}
			
		}		
}
