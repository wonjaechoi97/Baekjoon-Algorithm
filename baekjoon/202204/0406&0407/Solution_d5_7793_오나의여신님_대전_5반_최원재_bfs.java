package p0406;

import java.io.*;
import java.util.*;

public class Solution_d5_7793_오나의여신님_대전_5반_최원재_bfs {
	
	static class loc{
		int i;
		int j;
		public loc(int i, int j) {
			this.i = i;
			this.j = j;
		}
		
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		 int[] di = {-1,0,1,0};
		 int[] dj = {0,1,0,-1};
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T;t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N=Integer.parseInt(st.nextToken());
			int M=Integer.parseInt(st.nextToken());
			char[][] map = new char[N][M];
			Queue<loc> devilq = new ArrayDeque<loc>();
			Queue<loc> syq = new ArrayDeque<loc>();
			boolean[][] vi = new boolean[N][M];
			for(int i=0; i<N; i++) {
				String str = br.readLine();
				for(int j=0; j<M; j++) {
					map[i][j]=str.charAt(j);
					if(map[i][j]=='*')devilq.offer(new loc(i, j));
					if(map[i][j]=='S') {
						syq.offer(new loc(i, j));
						vi[i][j]=true;
					}
				}
			}
			int cnt=0;
			boolean finish=false;
			loc cur;
			label : while(true) {
			//악마 이동
				
				int size =devilq.size();
				for(int i=0; i<size; i++) {
					cur = devilq.poll();
					for(int d=0; d<4; d++) {
						int ni = cur.i+di[d];
						int nj = cur.j+dj[d];
						if(0<=ni&& ni<N&&0<=nj&& nj<M) {
							if(map[ni][nj]=='.'||map[ni][nj]=='S') {
								map[ni][nj]='*';
								devilq.offer(new loc(ni, nj));
							}
						}
						
					}
				}
				size = syq.size();
				for(int i=0; i<size; i++) {
					cur = syq.poll();
					if(map[cur.i][cur.j]=='D') break label;
					
					for(int d=0; d<4; d++) {
						int ni = cur.i+di[d];
						int nj = cur.j+dj[d];
						if(0<=ni&& ni<N&&0<=nj&& nj<M) {
							if(map[ni][nj]=='.'||map[ni][nj]=='D') {
								if(map[ni][nj]!='D')map[ni][nj]='S';
								syq.offer(new loc(ni, nj));
							}
						}
					}
				}
				if(syq.isEmpty()) {
					cnt=-1;
					break;
				}
				cnt++;
			}
			
			
			if(cnt==-1)sb.append("#").append(t).append(" ").append("GAME OVER").append("\n");
			else sb.append("#").append(t).append(" ").append(cnt).append("\n");
			//System.out.println(min);
			
		}
		
		System.out.println(sb.toString());
		br.close();

	}
	
}
