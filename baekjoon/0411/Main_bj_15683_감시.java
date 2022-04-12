package p0411;
import java.io.*;
import java.util.*;
public class Main_bj_15683_감시 {
	static int[] di = {-1,0,1,0};
	static int[] dj = {0,1,0,-1};
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0; j<M ; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		solve(0, 0, N, M, map);
		System.out.println(min);
		br.close();

	}
	
	static void solve(int i, int j, int N, int M, int[][] map) {
		int[][] copy = new int[N][M];
		for(int ni=0; ni<N; ni++) {
			for(int nj=0; nj<M; nj++) {
				copy[ni][nj]=map[ni][nj];
			}
		}
		while(true) {
			if(j==M) {
				i++;
				j=0;
			}
			if(i==N)break;
			if(1<=map[i][j] && map[i][j]<=5) {
				if(map[i][j]==5) {
					draw(i, j, 0, 5, map, N, M);
					solve(i, j+1, N, M, map);
					for(int ni=0; ni<N; ni++) {
						for(int nj=0; nj<M; nj++) {
							map[ni][nj]=copy[ni][nj];
						}
					}
				}else if(map[i][j]==2){
					draw(i, j, 1, 2, map, N, M);
					solve(i, j+1, N, M, map);
					for(int ni=0; ni<N; ni++) {
						for(int nj=0; nj<M; nj++) {
							map[ni][nj]=copy[ni][nj];
						}
					}
					draw(i, j, 2, 2, map, N, M);
					solve(i, j+1, N, M, map);
					for(int ni=0; ni<N; ni++) {
						for(int nj=0; nj<M; nj++) {
							map[ni][nj]=copy[ni][nj];
						}
					}
				}else {
					for(int d=1;d<=4;d++) {
						draw(i, j, d, map[i][j], map,N, M);
						solve(i, j+1, N, M, map);
						for(int ni=0; ni<N; ni++) {
							for(int nj=0; nj<M; nj++) {
								map[ni][nj]=copy[ni][nj];
							}
						}
					}
				}
			}
			j++;
		}
		int cnt=0;
		for(int ni=0; ni<N; ni++) {
			for(int nj=0; nj<M; nj++) {
				if(map[ni][nj]==0)cnt++;
			}
		}
		if(min>cnt) {
//			for(int[]a : map) {
//				System.out.println(Arrays.toString(a));
//			}
//			System.out.println();
			min=cnt;
		}
	}
	static void draw(int i , int j, int dir, int num, int[][] map,int N, int M) {
																	
		if(num==5) {
			for(int d=0; d<4;d++) {
				straight(i, j, map, N, M, d);
			}
		}else if(num==4) {
			if(dir==1) {
				for(int d=0; d<4;d++) {
					if(d==0)continue;
					straight(i, j, map, N, M, d);
				}
			}else if(dir==2) {
				for(int d=0; d<4;d++) {
					if(d==1)continue;
					straight(i, j, map, N, M, d);
				}
			}else if(dir==3) {
				for(int d=0; d<4;d++) {
					if(d==2)continue;
					straight(i, j, map, N, M, d);
				}
			}else if(dir==4) {
				for(int d=0; d<4;d++) {
					if(d==3)continue;
					straight(i, j, map, N, M, d);
				}
			}
		}else if(num==3) {
			if(dir==1) {
				for(int d=0; d<4;d++) {
					if(d==2||d==3)continue;
					straight(i, j, map, N, M, d);
				}
			}else if(dir==2) {
				for(int d=0; d<4;d++) {
					if(d==3||d==0)continue;
					straight(i, j, map, N, M, d);
				}
			}else if(dir==3) {
				for(int d=0; d<4;d++) {
					if(d==0||d==1)continue;
					straight(i, j, map, N, M, d);
				}
			}else if(dir==4) {
				for(int d=0; d<4;d++) {
					if(d==1||d==2)continue;
					straight(i, j, map, N, M, d);
				}
			}
		}else if(num==2) {
			if(dir==1) {
				for(int d=0; d<4;d++) {
					if(d==0||d==2)continue;
					straight(i, j, map, N, M, d);
				}
			}else if(dir==2) {
				for(int d=0; d<4;d++) {
					if(d==1||d==3)continue;
					straight(i, j, map, N, M, d);
				}
			}
		}else if(num==1) {
			if(dir==1) {
				straight(i, j, map, N, M, 0);
			}else if(dir==2) {
				straight(i, j, map, N, M, 1);
			}else if(dir==3) {
				straight(i, j, map, N, M, 2);
			}else if(dir==4) {
				straight(i, j, map, N, M, 3);
			}
		}
	}
	static void straight(int i, int j, int[][] map, int N, int M, int d) {
		
			int ni=i;
			int nj=j;
			while(true) {
				ni+=di[d];
				nj+=dj[d];
				
				if(0<=ni&ni<N && 0<= nj &&  nj<M) {
					if(map[ni][nj]!=6) {//벽이 아니라면!
						if(1<=map[ni][nj]&&map[ni][nj]<=5)continue;
						map[ni][nj]=7;
					}else break;
				}else {
					break;
				}
			}
		
	}

}
