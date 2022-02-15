import java.io.*;
import java.util.*;
	
public class Main_bj_11047_동전0 {

	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N=Integer.parseInt(st.nextToken());
		int K=Integer.parseInt(st.nextToken());
		int[] coin = new int[N];
		for(int i=0;i<N;i++) {
			coin[i]=Integer.parseInt(br.readLine());
		}
		int sum =0;
		for(int i=N-1;i>=0;i--) {			
			sum+=K/coin[i];
			K%=coin[i];
			if(K==0)break;
		}
		System.out.println(sum);
		br.close();
	}
}
