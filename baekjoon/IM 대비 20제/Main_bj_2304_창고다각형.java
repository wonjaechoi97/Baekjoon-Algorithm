import java.io.*;
import java.util.*;
public class Main_bj_2304_창고다각형 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N =Integer.parseInt(br.readLine());
		int[][] list = new int[N][2];
		int max=-1;
		int max_idx=-1;
		for(int i=0; i<N;i++ ) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			list[i]=new int[] {Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()) };			
		}
		Arrays.sort(list, Comparator.comparingInt(o1->o1[0]));
//		for(int[] a:list)System.out.println(Arrays.toString(a));
		for(int i=0; i<N;i++) {
			if(list[i][1]>max) {
				max=list[i][1];
				max_idx=i;
			}
		}
		int h=list[0][1];
		int left = list[0][0];
		int sum=0;
		for(int i=1; i<=max_idx;i++) {
			if(h<=list[i][1]) {
				sum+=(list[i][0]-left)*h;
				h=list[i][1];
				left=list[i][0];
			}
		}
		//우측부터
		h=list[N-1][1];
		int right = list[N-1][0];
		for(int i=N-2;i>=max_idx;i--) {
			if(h<=list[i][1]) {
				sum+=(right-list[i][0])*h;
				h=list[i][1];
				right = list[i][0];
			}
		}
		sum+=list[max_idx][1];
		System.out.println(sum);
	}
}
