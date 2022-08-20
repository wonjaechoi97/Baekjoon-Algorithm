import java.io.*;
import java.util.*;
public class Solution_d4_1861_정사각형방_대전_5반_최원재2 {
	static int[] di= {-1,0,1,0};
	static int[] dj= {0,1,0,-1};
	static int max;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input (10).txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb =new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int t=1;t<=T; t++) {
			int N = Integer.parseInt(br.readLine());
			int[][] map =new int[N+1][N+1];
		
			for(int i=1; i<=N;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine()," ");
				for(int j=1; j<=N;j++) {
					map[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			int result=-1;
			int max_num=Integer.MAX_VALUE; // 최대값일 때 시작 값
			for(int i =1;i<=N;i++) {
				for(int j=1; j<=N; j++) {
					max=-1;
					
					solve(i,j, 1, map, N);
					if(max == result) {
						if(map[i][j]<max_num)max_num=map[i][j];
					}					
					
					else if(max>result) {
						result= max;
						max_num = map[i][j];
					}
				}
			}
			sb.append("#"+t).append(" ").append(max_num).append(" ").append(result).append("\n");
		}
		System.out.println(sb.toString());
		br.close();

	}
	//dfs활용
	static void solve(int i, int j, int cnt,int[][] map, int N) {
		
		if(cnt==1) {
			for(int d=0;d<4;d++) {
				if(1<=i+di[d]&&i+di[d]<=N&&1<=j+dj[d]&&j+dj[d]<=N) {
					if(map[i+di[d]][j+dj[d]]-1==map[i][j]) {
						solve(i+di[d],j+dj[d], cnt+1, map, N);
						}
				}
			}
		}
		
		else {
		for(int d=0;d<4;d++) {
			if(1<=i+di[d]&&i+di[d]<=N&&1<=j+dj[d]&&j+dj[d]<=N) {
				if(map[i+di[d]][j+dj[d]]-1==map[i][j]) {
				solve(i+di[d], j+dj[d], cnt+1, map, N);
				}
			}
		}
		}	
		if(cnt>max)max = cnt;
	
	}

}
