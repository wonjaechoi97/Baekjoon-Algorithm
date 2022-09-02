package samsung01;

import java.io.*;
import java.util.*;

public class Solution_2 {
	static int[] di = {-1,0,1,0};
	static int[] dj = {0,1,0,-1};
	static int maxTotal = -1;
	static int minLength = Integer.MIN_VALUE;

	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			maxTotal = -1;
			minLength = Integer.MIN_VALUE;
			int N = Integer.parseInt(br.readLine());
			int[][] map = new int[N][N];
			for(int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine()," ");
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			solve(0, 0, N, map, 0, 0);
			sb.append("#").append(t).append(" ").append(minLength).append("\n");
		}
		System.out.println(sb.toString());
		
		br.close();

	}
	static void solve(int i, int j, int N, int[][] map,int sum, int total) {

		while(true) {

			j++;
			if(j==N) {

				j=0;
				i++;
			}
			if(i==N) {

				if(total>maxTotal) {
					maxTotal = total;
					minLength = sum;
				}else if(total==maxTotal) {
					if(sum<minLength) minLength = sum;
				}
				return;
			}
			
			if(map[i][j]==1) {
				for(int d=0; d<4; d++) {

					if(lineCheck(N, d, i, j, map)) { //선 그을 수 있다.
						int step = draw(N, d, i, j, map);// 전선 그리고 스텝 수 반환
						solve(i, j, N, map, sum+step, total+1); //total은 총 연결 전원 수
						erase(N, d, i, j, map); //복구
						
					}
				}
			}
		}
		
	}
	
	//그 라인이 비었는지 체크하는 함수
	static boolean lineCheck(int N, int dir, int i, int j, int[][] map) {
		int ni = i;
		int nj = j;
		while(true) {
			ni=ni+di[dir];
			nj=nj+dj[dir];
			if(0<=ni&&ni<N&&0<=nj&&nj<N){
				if(map[ni][nj]!=0) {
					return false;
				}
			}else {
				break;
			}
			
		}
		return true;
	}
	
	static int draw(int N, int dir, int i, int j, int[][] map ) {
		int ni = i;
		int nj = j;
		int step = 0;
		while(true) {
			ni=ni+di[dir];
			nj=nj+dj[dir];
			
			if(0<=ni&&ni<N&&0<=nj&&nj<N){
				map[ni][nj] = 2;
				step++;
			}else {
				return step;
			}
			
		}
	}
	
	static void erase(int N, int dir, int i, int j, int[][] map) {
		int ni = i;
		int nj = j;
		while(true) {
			ni=ni+di[dir];
			nj=nj+dj[dir];
			if(0<=ni&&ni<N&&0<=nj&&nj<N){
				map[ni][nj] = 0;
			}else {
				return;
			}
			
		}
	}

}
