package p0417;
import java.io.*;
import java.util.*;
public class Main_bj_12865_평범한배낭 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader( System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][] sack = new int[N+1][K+1];
		for(int i=1; i<=N;i++) {
			st = new StringTokenizer(br.readLine()," ");
			
			int w = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			for(int k=1; k<=K;k++) {
				if(w<=k) {
					if(sack[i-1][k-w]+value>sack[i-1][k])sack[i][k]=sack[i-1][k-w]+value;
					else sack[i][k] = sack[i-1][k];
				}else {
					sack[i][k] = sack[i-1][k];
				}
			}
		}
		//for(int[] a: sack)System.out.println(Arrays.toString(a));
		System.out.println(sack[N][K]);
		
		
		
		br.close();

	}

}
