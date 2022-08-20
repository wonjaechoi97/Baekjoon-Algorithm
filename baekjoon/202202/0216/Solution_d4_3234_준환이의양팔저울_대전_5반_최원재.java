import java.io.*;
import java.util.*;
public class Solution_d4_3234_준환이의양팔저울_대전_5반_최원재 {
	
	static int count;
	static int sum;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T =Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T;t++) {
			int N =Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int[] input=new int[N];
			count=0;
			for(int i=0; i <N;i++) {
				input[i]=Integer.parseInt(st.nextToken());
			}
			solve(0,0,0,N, new boolean[N],input);
			System.out.println("#"+t+" "+count);
			
		}
		
	}
	
	static void solve(int lsum, int rsum, int cnt, int N, boolean[] checked,int input[]) {
		if(cnt==N) {
			count++;
			return;
		}
		
		for(int i=0; i<N;i++) {
			if(checked[i])continue;
			checked[i]=true;
			solve(lsum+input[i],rsum,cnt+1,N,checked,input);
			
			if(rsum+input[i]<=lsum) {
				solve(lsum,rsum+input[i],cnt+1,N,checked,input);
			}
			checked[i]=false;
		}
	}
}
