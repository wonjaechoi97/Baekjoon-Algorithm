import java.io.*;
import java.util.*;
public class Main_bj_10026_적록색약_대전_5반_최원재 {
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
				 dfs(map,i ,j ,N);
				 if(step>0) count++;
			}
		}
		v = new boolean[N][N];
		for(int i=0; i<N;i++) {
			for(int j=0; j<N; j++) {
				 step = 0;
				 gdfs(map,i ,j ,N);
				 if(step>0) countg++;
			}
		}
		System.out.println(count+" "+countg);
	}
	static void dfs( char[][] map,int i , int j,int N){
		if(v[i][j])return;
		v[i][j]=true;
		step++;
		for(int d=0; d<4;d++) {
			int ni = i + di[d];
			int nj = j+ dj[d];
			if(0<=ni&&ni<N&&0<=nj&nj<N) {
				if(map[i][j]==map[ni][nj]) {
				dfs(map, ni, nj, N);
				}
			}
		}
	}
	static void gdfs(char[][] map,int i , int j,int N) {
		if(v[i][j])return;
		v[i][j]=true;
		step++;
		for(int d=0; d<4;d++) {
			int ni = i + di[d];
			int nj = j+ dj[d];
			if(0<=ni&&ni<N&&0<=nj&nj<N) {
				if(map[i][j]=='B') {
					if(map[ni][nj]=='B') {
						gdfs(map, ni, nj, N);
					}
				}else {//즉 R G인 경우
					if(map[ni][nj]=='R'||map[ni][nj]=='G') {
						gdfs(map, ni, nj, N);
					}
				}
			}
		}
	}

}
