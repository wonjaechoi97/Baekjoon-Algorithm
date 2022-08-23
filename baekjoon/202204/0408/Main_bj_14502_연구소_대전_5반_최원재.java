package p0408;
import java.io.*;
import java.util.*;

public class Main_bj_14502_연구소_대전_5반_최원재 {
	static class loc{
		int i; 
		int j;
		public loc(int i, int j) {
			super();
			this.i = i;
			this.j = j;
		}
		
	}
	//조합으로 풀기 
	static int[] di= {-1,0,1,0};
	static int[] dj= {0,1,0,-1};
	static int max = -1;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int N= Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0; j<M; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		
		//for(int[] a: map)System.out.println(Arrays.toString(a));
		selectlocation(N, M, map, new int[3][2], 0, 0 ,0);
		System.out.println(max);
		br.close();

	}
	
	static void selectlocation(int N, int M, int[][] map, int[][] out, int cnt,int i, int j) {
		if(cnt==3) {
			int[][] copy = new int[N][M];
			for(int ci=0; ci<N; ci++) {
				for(int cj=0; cj<M; cj++) {
					copy[ci][cj]=map[ci][cj];
				}
			}
			for(int ci=0; ci<3;ci++) {
				copy[out[ci][0]][out[ci][1]]=1;
			}
			spread(copy, N, M);
//			for(int[] a: out) System.out.println(Arrays.toString(a));
//			System.out.println();
			return;
			
		}
		int ni=i;
		int nj=j;
		while(true) {
			
			if(nj==M) {
				ni++;
				nj=0;
			}
			if(ni==N)break;
			if(map[ni][nj]!=0) {
				nj++;
				continue;
			}
			out[cnt]=new int[] {ni, nj};
			selectlocation(N, M, map, out, cnt+1, ni, nj+1);
			nj++;
		}
		
	}
	static void spread(int[][] map, int N, int M) {
		boolean[][] v = new boolean[N][M];
		int cnt=0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j]==2) {
					if(v[i][j]) continue;
					Queue<int[]> que = new ArrayDeque<int[]>();
					que.offer(new int[] {i,j});
					v[i][j]=true;
					while(!que.isEmpty()) {
						int[] cur = que.poll();
						for(int d=0; d<4;d++) {
							int ni = cur[0]+di[d];
							int nj = cur[1]+dj[d];
							if(0<=ni&&ni<N&&0<=nj&&nj<M) {
								if(v[ni][nj])continue;
								if(map[ni][nj]==0) {
									map[ni][nj]=2;
									
									que.offer(new int[] {ni, nj});
									v[ni][nj]=true;
								}
							}
						}
						
					}
				}
			}
		}
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j]==0)cnt++;
			}
		}
		//System.out.println(cnt);
		if(cnt>max)max=cnt;
	}

}
