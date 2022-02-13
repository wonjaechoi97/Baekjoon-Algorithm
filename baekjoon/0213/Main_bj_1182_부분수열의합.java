import java.io.*;
import java.util.*;
public class Main_bj_1182_부분수열의합 {
	static boolean[] visited;
	static int[] input;
	static int N;
	static int S;
	static int count=0;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(br.readLine());
		N= Integer.parseInt(st.nextToken());
		S= Integer.parseInt(st.nextToken());
		input = new int[N];
		visited = new boolean[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N;i++) {
			input[i]=Integer.parseInt(st.nextToken());
		}
		set(0);
		if(S==0)count-=1;
		System.out.println(count);
		br.close();
	}
	static void set(int cnt) {
		if(cnt==N) {
			int sum=0;
			for(int i=0;i<N;i++) {
				if(visited[i])sum+=input[i];
			}
			if(sum==S)count++;
			return;
		}
		visited[cnt]=true;
		set(cnt+1);
		visited[cnt]=false;
		set(cnt+1);
	}

}
