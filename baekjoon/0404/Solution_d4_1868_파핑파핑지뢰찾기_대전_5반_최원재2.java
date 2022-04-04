package p0404;

import java.io.*;
import java.util.*;

public class Solution_d4_1868_파핑파핑지뢰찾기_대전_5반_최원재2  {
	static int[] di = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dj = {0, 1, 1, 1, 0, -1, -1, -1};//상 우상 우 우하 하 좌하 좌 좌상 
	public static void main(String[] args) throws Exception{
		
		//System.setIn(new FileInputStream("res/input.txt"));
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T= Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			int click=0;
			int N = Integer.parseInt(br.readLine());
			char[][] map = new char[N][N];
			for(int i=0; i<N; i++) {
				String str = br.readLine();
				for(int j=0; j<N; j++)
					map[i][j] = str.charAt(j);
			}
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(map[i][j]=='.') {
						int zcnt=0;
						for(int d=0; d<8; d++) {
							int ni=i+di[d];
							int nj=j+dj[d];
							if(0<=ni&&ni<N && 0<=nj&& nj<N) {
								if(map[ni][nj]=='*')zcnt++;
							}
							
						}
						if(zcnt==0) {
							makenumber(i, j, N, map);
							click++;
						}
					}
				}
			}
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(map[i][j]=='.') {
						makenumber(i, j, N, map);
						click++;
					}
				}
			}
		
			sb.append("#"+t+" ").append(click).append("\n");
			
			//System.out.println("------------------------------------------");
		}
		System.out.println(sb.toString());
		
		br.close();

	}
	
	static void makenumber(int ni, int nj, int N, char[][] map) {
		//System.out.println(ni+" "+nj);
		int zcnt = 0;
		//0일 때 아닐 때 체크 
		for(int d=0; d<8; d++) {
			int xi = ni+di[d];
			int xj = nj+dj[d];
			
			if(0<=xi&&xi<N && 0<=xj&& xj<N) {
				if(map[xi][xj]=='*')zcnt++;
			}
		}
		if(zcnt==0) {
			map[ni][nj]='0';
			for(int d=0; d<8; d++) {
				int xi = ni+di[d];
				int xj = nj+dj[d];
				
				if(0<=xi&&xi<N && 0<=xj&& xj<N && map[xi][xj]=='.') {
					makenumber(xi, xj, N, map);
				}
				
			}
		}else {
			map[ni][nj]=(char)('0'+zcnt);
			return;
		}
		
	}

}
