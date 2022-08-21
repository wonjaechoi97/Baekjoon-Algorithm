package p0331;
import java.io.*;
import java.util.*;
public class Main_bj_2667_단지번호붙이기 {
	static int cnt;
	static int[] di = {-1,0,1,0};
	static int[] dj = {0,1,0,-1};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		int[][] map = new int[N][N];
		boolean[][] v = new boolean[N][N];
		
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			for(int j=0; j<N; j++) {
				map[i][j]=str.charAt(j)-'0';
			}
		}
		for(int i=0; i<N; i++) {
			
			for(int j=0; j<N; j++) {
				cnt=0;
				if(map[i][j]==1&&!v[i][j]) {
					v[i][j]=true;
					solve(map, i, j, v, N);
					
					pq.add(cnt);
				}
			}
		}
		sb.append(pq.size()).append("\n");
		while(!pq.isEmpty()) {
			sb.append(pq.poll()).append("\n");
		}
		System.out.println(sb.toString());
		br.close();

	}
	static void solve(int[][] map, int i, int j, boolean[][] v,int N) {
		cnt++;
		for(int d=0; d<4; d++) {
			int ni=i+di[d];
			int nj=j+dj[d];
			if(0<=ni&&ni<N && 0<=nj&& nj<N) {
				if(map[ni][nj]==1&&!v[ni][nj]) {
					v[ni][nj]=true;
					solve(map, ni, nj, v, N);
				}
			}
			
		}
	}

}
