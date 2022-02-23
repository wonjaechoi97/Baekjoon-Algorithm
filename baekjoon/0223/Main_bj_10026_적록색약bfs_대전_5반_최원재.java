import java.io.*;
import java.util.*;
public class Main_bj_10026_적록색약bfs_대전_5반_최원재 {
	static boolean[][] v;
	static int[] di = new int[] {-1,0,1,0};
	static int[] dj = new int[] {0,1,0,-1};
	static int step=0;
	static int count = 0;
	static int countg = 0;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N =Integer.parseInt(br.readLine());
		char[][] map = new char[N][N];
		v=new boolean[N][N];
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			for(int j=0; j<N;j++) {
				map[i][j]=str.charAt(j);
			}
		}
		for(int i=0; i<N;i++) {
			for(int j=0; j<N; j++) {
				 step = 0;
				 bfs(map,i ,j ,N);
				 if(step>0) count++;
			}
		}
		v = new boolean[N][N];
		for(int i=0; i<N;i++) {
			for(int j=0; j<N; j++) {
				 step = 0;
				 gbfs(map,i ,j ,N);
				 if(step>0) countg++;
			}
		}
		System.out.println(count+" "+countg);
	}
	static void bfs( char[][] map,int i , int j,int N){
		if(v[i][j])return;
		step++;
		Queue<int[]> q = new ArrayDeque<int[]>();
		v[i][j]=true;
		q.offer(new int[] {i,j});
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			for(int d=0; d<4; d++) {
				int ni = cur[0]+di[d];
				int nj = cur[1]+dj[d];
				if(0<=ni&&ni<N&&0<=nj&nj<N) {
					if(map[cur[0]][cur[1]]==map[ni][nj]) {
						if(!v[ni][nj]) {
							q.add(new int[] {ni, nj});
							v[ni][nj]=true;
						}
					}
				}
			}
		}
	}
	static void gbfs(char[][] map,int i , int j,int N) {
		if(v[i][j])return;
		step++;
		Queue<int[]> q = new ArrayDeque<int[]>();
		v[i][j]=true;
		q.offer(new int[] {i,j});
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			for(int d=0; d<4; d++) {
				int ni = cur[0]+di[d];
				int nj = cur[1]+dj[d];
				if(0<=ni&&ni<N&&0<=nj&nj<N) {
					if(map[cur[0]][cur[1]]=='B') {
						if(map[ni][nj]=='B') {
							if(!v[ni][nj]) {
								q.add(new int[] {ni, nj});
								v[ni][nj]=true;
							}
						}
					}else {
						if(map[ni][nj]=='G'||map[ni][nj]=='R') {
							if(!v[ni][nj]) {
								q.add(new int[] {ni, nj});
								v[ni][nj]=true;
							}
						}
					}
				}
			}
		}
		
	}
}
