package practice0226;
import java.io.*;
import java.util.*;
public class Main_bj_2304_창고다각형_대전_5반_최원재 {
	static class comp implements Comparator<int[]>{

		@Override
		public int compare(int[] o1, int[] o2) {
			
			return o1[0]-o2[0];
		}
		
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		comp c = new comp();
		int N = Integer.parseInt(br.readLine());
		int[][] input = new int[N][2]; 
		int max=0;
		int max_idx=-1;
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			
			input[i][0]=Integer.parseInt(st.nextToken());
			input[i][1]=Integer.parseInt(st.nextToken());
					
		}
		Arrays.sort(input, c);
		//for(int[] a: input)System.out.println(Arrays.toString(a));
		for(int i=0;i<N;i++) {
			if(input[i][1]>max) {
				max=input[i][1];
				max_idx=i;
			}
		}
		int start_l	= input[0][0]; //시작 위치
		int start_h =input[0][1];  // 시작 높이
		int sum = 0;
		for(int i=1; i<=max_idx;i++) {
			if(input[i][1]>=start_h) {
				sum+=(input[i][0]-start_l)*start_h;
				start_l=input[i][0];
				start_h=input[i][1];
			}
		}
		//System.out.println(sum);
		start_l=input[N-1][0];
		start_h=input[N-1][1];
		for(int i=N-2; i>=max_idx; i--) {
			if(input[i][1]>=start_h) {
				sum+=(start_l-input[i][0])*start_h;
				start_l=input[i][0];
				start_h=input[i][1];
			}
		}
		sum+=max;
		System.out.println(sum);
		br.close();

	}

}

