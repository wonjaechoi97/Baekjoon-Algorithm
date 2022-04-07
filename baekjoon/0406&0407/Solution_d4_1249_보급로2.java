package p0407;
import java.io.*;
import java.util.*;

public class Solution_d4_1249_보급로2 {
	static int[] di = {-1,0,1,0};
	static int[] dj = {0,1,0,-1};
	static int inf = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input (14).txt"));
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			int N = Integer.parseInt(br.readLine());
			int[][] map = new int[N][N];
			
			for(int i=0; i<N;i++) {
				String str = br.readLine();
				for(int j=0; j<N; j++) {
					map[i][j]=str.charAt(j)-'0';
					
				}
			}
			int result = dijkstra(0, 0, N, map);
			sb.append("#").append(t).append(" ").append(result).append("\n");
			
		}
		System.out.println(sb.toString());
		
		
		br.close();

	}
	
	private static int dijkstra(int starti, int startj, int N, int[][] map) {
		
		boolean[][] visited = new boolean[N][N];
		int[][] minTime = new int[N][N]; //출발지에서 자신까지의 최소 복구 시간
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				minTime[i][j]=inf;
			}
		}
		
		PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				
				return o1[2]-o2[2];
			}		
		});
		
		minTime[starti][startj]=0;
		pq.offer(new int[] {starti, startj, minTime[starti][startj]});
		int i,j,mincost,ni,nj,current[];
		while(true) {
			
			current = pq.poll();
			i=current[0];
			j=current[1];
			mincost = current[2];
			if(visited[i][j]) continue;
			visited[i][j]=true;
			if(i==N-1&&j==N-1) return mincost; //도착지라면 끝내기
			
			//현 정점의 인접정점 들여다보며 최소비용 갱신
			for(int d=0; d<4;d++) {
				ni = i+di[d];
				nj = j+dj[d];
				if(0<=ni&&ni<N&&0<=nj&&nj<N && minTime[ni][nj]>mincost+map[ni][nj]) {
					minTime[ni][nj]=mincost+map[ni][nj];
					pq.offer(new int[] {ni,nj,minTime[ni][nj]});
				}
			}
		
		}
		
		
	}

}
