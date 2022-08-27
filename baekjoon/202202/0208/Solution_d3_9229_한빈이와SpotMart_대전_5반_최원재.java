import java.io.*;
import java.util.*;

public class Solution_d3_9229_한빈이와SpotMart_대전_5반_최원재 {
	static int max = 0;
	static int sum = 0;
	static int [] ppo = new int[2];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int i=1; i<=T ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int snack[] = new int[N];
			st = new StringTokenizer(br.readLine());
			for(int x = 0 ; x< N ; x++) {
				snack[x] = Integer.parseInt(st.nextToken());
			}
			max = -1;
			sum = 0;
			ppop(snack, 0, 0, M);
			sb.append("#").append(i).append(" ").append(max).append("\n");
		}
		sb.setLength(sb.length()-1);
		System.out.println(sb.toString());
		br.close();
	}
	
	public static void ppop(int[] snack, int cnt,int start, int limit) {
		if(cnt==2) {
			sum=0;
			//System.out.println(Arrays.toString(ppo));
			for(int t = 0 ; t<2;t++) {
				sum+=ppo[t];
			}
			if(max<sum&&sum<=limit)max = sum;
			
			return;
		}		
		for(int i = start; i<snack.length; i++) {
			ppo[cnt]=snack[i];
			ppop(snack, cnt+1,i+1,limit);
		}	
	}
}
