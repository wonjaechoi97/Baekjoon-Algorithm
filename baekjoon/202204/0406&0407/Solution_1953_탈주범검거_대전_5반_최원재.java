package p0407;
import java.io.*;
import java.util.*;

public class Solution_1953_탈주범검거_대전_5반_최원재 {
	public static void main(String[] args)throws Exception {
		System.setIn(new FileInputStream("res/sample_input (10).txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int[] di = {-1,0,1,0};
		int[] dj= {0,1,0,-1};
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T;t++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());//위치
			int C = Integer.parseInt(st.nextToken());
			int L = Integer.parseInt(st.nextToken()); //시간
			int[][] map = new int[N][M];
			boolean[][] visited = new boolean[N][M];
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine()," ");
				for(int j=0; j<M; j++) {
					map[i][j]=Integer.parseInt(st.nextToken());
					
				}
			}
			Queue<int[]> que = new ArrayDeque<int[]>();
			que.add(new int[] {R, C, 1});
			visited[R][C]=true;
			int cnt=1;
			while(!que.isEmpty()) {
				int[] cur =  que.poll();
				if(cur[2]==L)break;
				int shape = map[cur[0]][cur[1]];
				if(shape==1) {//상하좌우
					for(int d=0; d<4; d++) {
						int ni=cur[0]+di[d];
						int nj= cur[1]+dj[d];
						if(0<=ni&&ni<N&&0<=nj&&nj<M&&!visited[ni][nj] &&map[ni][nj]!=0) {
							if(d==0&&!(map[ni][nj]==1||map[ni][nj]==2||map[ni][nj]==5||map[ni][nj]==6))continue;
							if(d==1&&!(map[ni][nj]==1||map[ni][nj]==3||map[ni][nj]==6||map[ni][nj]==7))continue;
							if(d==2&&!(map[ni][nj]==1||map[ni][nj]==2||map[ni][nj]==4||map[ni][nj]==7))continue;
							if(d==3&&!(map[ni][nj]==1||map[ni][nj]==3||map[ni][nj]==4||map[ni][nj]==5))continue;
							que.offer(new int[] {ni,nj,cur[2]+1});
							visited[ni][nj]=true;
							cnt++;
						}
					}
						
				}else if(shape==2) {//상하  //상우하좌
					for(int d=0; d<4; d++) {
						if(d==1||d==3)continue;
						int ni=cur[0]+di[d];
						int nj= cur[1]+dj[d];
						if(0<=ni&&ni<N&&0<=nj&&nj<M&&!visited[ni][nj]&&map[ni][nj]!=0) {
							if(d==0&&!(map[ni][nj]==1||map[ni][nj]==2||map[ni][nj]==5||map[ni][nj]==6))continue;
							if(d==2&&!(map[ni][nj]==1||map[ni][nj]==2||map[ni][nj]==4||map[ni][nj]==7))continue;							
							que.offer(new int[] {ni,nj,cur[2]+1});
							visited[ni][nj]=true;
							cnt++;
						}
					}
					
				}else if(shape==3) { //좌우 //상우하좌
					for(int d=0; d<4; d++) {
						if(d==0||d==2)continue;
						int ni=cur[0]+di[d];
						int nj= cur[1]+dj[d];
						if(0<=ni&&ni<N&&0<=nj&&nj<M&&!visited[ni][nj]&&map[ni][nj]!=0) {						
							if(d==1&&!(map[ni][nj]==1||map[ni][nj]==3||map[ni][nj]==6||map[ni][nj]==7))continue;							
							if(d==3&&!(map[ni][nj]==1||map[ni][nj]==3||map[ni][nj]==4||map[ni][nj]==5))continue;
							que.offer(new int[] {ni,nj,cur[2]+1});
							visited[ni][nj]=true;
							cnt++;
						}
					}
				}else if(shape==4) {//상우//상우하좌
					for(int d=0; d<4; d++) {
						if(d==2||d==3)continue;
						int ni=cur[0]+di[d];
						int nj= cur[1]+dj[d];
						if(0<=ni&&ni<N&&0<=nj&&nj<M&&!visited[ni][nj]&&map[ni][nj]!=0) {
							if(d==0&&!(map[ni][nj]==1||map[ni][nj]==2||map[ni][nj]==5||map[ni][nj]==6))continue;
							if(d==1&&!(map[ni][nj]==1||map[ni][nj]==3||map[ni][nj]==6||map[ni][nj]==7))continue;
							
							que.offer(new int[] {ni,nj,cur[2]+1});
							visited[ni][nj]=true;
							cnt++;
						}
					}
					
				}else if(shape==5) {//하우 //상우하좌
					for(int d=0; d<4; d++) {
						if(d==0||d==3)continue;
						int ni=cur[0]+di[d];
						int nj= cur[1]+dj[d];
						if(0<=ni&&ni<N&&0<=nj&&nj<M&&!visited[ni][nj]&&map[ni][nj]!=0) {
							
							if(d==1&&!(map[ni][nj]==1||map[ni][nj]==3||map[ni][nj]==6||map[ni][nj]==7))continue;
							if(d==2&&!(map[ni][nj]==1||map[ni][nj]==2||map[ni][nj]==4||map[ni][nj]==7))continue;
							
							que.offer(new int[] {ni,nj,cur[2]+1});
							visited[ni][nj]=true;
							cnt++;
						}
					}
				}else if(shape==6) { // 하좌 //상우하좌
					for(int d=0; d<4; d++) {
						if(d==0||d==1)continue;
						int ni=cur[0]+di[d];
						int nj= cur[1]+dj[d];
						if(0<=ni&&ni<N&&0<=nj&&nj<M&&!visited[ni][nj]&&map[ni][nj]!=0) {
//							
							if(d==2&&!(map[ni][nj]==1||map[ni][nj]==2||map[ni][nj]==4||map[ni][nj]==7))continue;
							if(d==3&&!(map[ni][nj]==1||map[ni][nj]==3||map[ni][nj]==4||map[ni][nj]==5))continue;
							que.offer(new int[] {ni,nj,cur[2]+1});
							visited[ni][nj]=true;
							cnt++;
						}
					}
				}else if(shape==7) { //상좌 //상우하좌
					for(int d=0; d<4; d++) {
						if(d==1||d==2)continue;
						int ni=cur[0]+di[d];
						int nj= cur[1]+dj[d];
						if(0<=ni&&ni<N&&0<=nj&&nj<M&&!visited[ni][nj]&&map[ni][nj]!=0) {
							if(d==0&&!(map[ni][nj]==1||map[ni][nj]==2||map[ni][nj]==5||map[ni][nj]==6))continue;
//							
							if(d==3&&!(map[ni][nj]==1||map[ni][nj]==3||map[ni][nj]==4||map[ni][nj]==5))continue;
							que.offer(new int[] {ni,nj,cur[2]+1});
							visited[ni][nj]=true;
							cnt++;
						}
					}
				}
			}
	
			sb.append("#").append(t).append(" ").append(cnt).append("\n");
		
		}
		System.out.println(sb.toString());
		br.close();
	}
}
