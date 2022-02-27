package practice0226;
import java.io.*;
import java.util.*;
public class Main_bj_2491_수열_대전_5반_최원재 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int[] input = new int[N];
		int up_max=1;
		int down_max=1;
		for(int i=0; i<N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		int count=1;
		for(int i=1; i<N;i++) {
			if(input[i]>=input[i-1]) {
				count++;
				if(i==N-1)if(count>up_max)up_max=count;
			}else {
				if(count>up_max)up_max=count;
				count=1;
			}
		}
		count=1;
		for(int i=1; i<N;i++) {
			if(input[i]<=input[i-1]) {
				count++;
				if(i==N-1)if(count>up_max)up_max=count;
			}else {
				if(count>down_max)down_max=count;
				count=1;
			}
		}
		if(up_max>=down_max)System.out.println(up_max);
		else System.out.println(down_max);
		br.close();

	}

}
