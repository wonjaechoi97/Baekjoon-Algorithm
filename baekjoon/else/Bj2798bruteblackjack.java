package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Bj2798bruteblackjack {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] nums = new int[N];
		for(int i=0;i<N;i++) nums[i]=Integer.parseInt(st.nextToken());
	
		int result=-1;
		int min =Integer.MAX_VALUE;
		for(int i=0; i<N;i++) {
			for(int j=0; j<N;j++) {
				if(i==j)continue;
				for(int k=0; k<N;k++) {
					if(i==k || j==k)continue;
					int sum = nums[i]+nums[j]+nums[k];
					if(M-sum<min&&M-sum>=0) {
						min = M-sum;
						result = sum;
						
					}
				}
			}
		}
		System.out.println(result);

	}

}
