package practice0226;
import java.io.*;
import java.util.*;
public class Main_bj_2559_수열_대전_5반_최원재 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] num = new int[N];
		st=new StringTokenizer(br.readLine()," ");
		for(int i=0; i<N;i++) {
			num[i]=Integer.parseInt(st.nextToken());
		}
		int max=Integer.MIN_VALUE;
		int sum = 0;
		for(int i=0; i<=N-K;i++) {
			sum=0;
			for(int j=0; j<K;j++) {
				sum+=num[i+j];
			}
			if(sum>max)max=sum;
		}
		System.out.println(max);
		br.close();

	}

}
