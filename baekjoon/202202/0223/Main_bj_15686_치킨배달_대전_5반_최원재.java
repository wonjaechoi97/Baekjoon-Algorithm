import java.io.*;
import java.util.*;

public class Main_bj_15686_치킨배달_대전_5반_최원재 {
//bfs
	static int count;
	static int[] di= new int[]  {-1,0,1,0}; //상 우 하 좌
	static int[] dj = new int[] {0,1,0,-1};
	static int[][] out;
	static int N,M;
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());//NXN 맵
		M = Integer.parseInt(st.nextToken());//남을 치킨 집 수 
		List<int[]>loc = new ArrayList<int[]>(); // 치킨집 위치 담을 리스트 
		out = new int[M][2]; // 조합을 통해 선택된 치킨집의 위치를 담을 곳
		
		int map[][] = new int[N][N];
		for(int i=0; i<N;i++) {
			st=new StringTokenizer(br.readLine()," ");
			for(int j=0; j<N; j++) {
				int a = Integer.parseInt(st.nextToken());
				if(a!=2)map[i][j]=a;
				else {
					map[i][j]=0;
					loc.add(new int[] {i,j});
					
				}
			}
		}
		//for(int[] a : map)System.out.println(Arrays.toString(a));
		choice(0, 0, loc, map, loc.size());
		//for(int[] a : map)System.out.println(Arrays.toString(a));
	
		System.out.println(min);
		br.close();

	}
	static int chidistance(int[][] map) {
		int result=0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j]==1) {
					count=0;
					bfs(map, i, j, new boolean[N][N], N);
					result+=count;
				}
			}
		}
		return result;
	}
	static void choice(int start, int cnt,   List<int[]> loc, int[][] map,int n) {//조합 M: 폐업전 전체 치킨집 수 
		if(cnt==M) {
			//치킨 위치 채우고j
			int[][] copy = new int[N][N];
			for(int i=0; i<N;i++) {
				for(int j=0;j<N;j++) {
					copy[i][j]=map[i][j];
				}
			}
			for(int i=0; i<M;i++) {
				copy[out[i][0]][out[i][1]]=2;
			}
	
			int x = chidistance(copy);//치킨 거리 구하는 함수 실행 
			if(x<min)min = x;
			return;
		}
		for(int i=start; i<n;i++) {
			out[cnt]=loc.get(i);
			choice(i+1,cnt+1, loc, map, n);
		}
	}
	static void bfs(int[][] map, int i, int j, boolean[][] v, int N) {
		Queue<int[]> q = new ArrayDeque<int[]>();
		q.offer(new int[] {i,j,0});//좌표 + 나아간 거리 
		v[i][j]=true;
		while(!q.isEmpty()) {
			
			int[] cur = q.poll();
			if(map[cur[0]][cur[1]]==2) {
				count=cur[2];
				break;
			}
			for(int d=0; d<4;d++) {
				int ni = cur[0]+di[d];
				int nj = cur[1]+dj[d];
				if(0<=ni&&ni<N&&0<=nj&&nj<N) {
					if(!v[ni][nj]) {
						q.offer(new int[] {ni,nj,cur[2]+1});
						v[ni][nj]=true;
					}
				}
			}
			
		}
		
	}

}
