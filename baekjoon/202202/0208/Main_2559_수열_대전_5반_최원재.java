import java.io.*;
import java.util.*;

public class Main_2559_수열_대전_5반_최원재 {

	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int max = -1001;
		
		int N = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i =0;i<N;i++ ) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		
		for(int i=0; i<=N-t;i++) {
			int sum = 0;
			for(int x = i; x<i+t;x++ ) {
				sum+=arr[x];
			}
			if(sum>max) max =sum;
		}
		System.out.println(max);
	}

}
