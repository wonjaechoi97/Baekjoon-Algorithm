package p0407;
import java.io.*;
import java.util.*;

public class Solution_d4_1249_보급로_bfs {
	static int[] di = {-1,0,1,0};
	static int[] dj = {0,1,0,-1};
	static class loc {
		int i;
		int j;
		int value;
		
		public loc(int i, int j, int value) {
			this.i = i;
			this.j = j;
			this.value = value;
		}

		
	}
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input (14).txt"));
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			int N = Integer.parseInt(br.readLine());
			int[][] map = new int[N][N];
			int[][] memo = new int[N][N];
			for(int i=0; i<N; i++) {
				String str = br.readLine();
				for(int j=0; j<N; j++) {
					memo[i][j]=Integer.MAX_VALUE;
					map[i][j]=str.charAt(j)-'0';
				}
			}
			memo[0][0]=0;
			Queue<loc> que = new ArrayDeque<loc>();
			que.add(new loc(0, 0, 0));
			while(!que.isEmpty()) {
				loc cur=que.poll();
				for(int d=0; d<4;d++) {
					int ni=cur.i+di[d];
					int nj=cur.j+dj[d];
					if(0<=ni&&ni<N&&0<=nj&&nj<N) {
						if(memo[ni][nj]>cur.value+map[ni][nj]) {
							memo[ni][nj]=cur.value+map[ni][nj];
							que.offer(new loc(ni, nj, cur.value+map[ni][nj]));
						}
					}
				}
			}
			sb.append("#").append(t).append(" ").append(memo[N-1][N-1]).append("\n");
			
		}
		System.out.println(sb.toString());
		
		
		br.close();

	}

}
