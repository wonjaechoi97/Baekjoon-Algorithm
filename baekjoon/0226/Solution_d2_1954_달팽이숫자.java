package practice0226;
import java.io.*;
import java.util.*;
public class Solution_d2_1954_달팽이숫자 {
	static int[] di= {0,1,0,-1}; // 우하좌상
	static int[] dj= {1,0,-1,0}; // 우하좌상
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			int N =Integer.parseInt(br.readLine());
			int[][] map = new int[N][N];
			int i =0, j =0;
			int d = 0;
			map[0][0]=1;
			for(int x =2; x<=N*N;x++) {
				int ni = i +di[d];
				int nj = j + dj[d];
				if(0<=ni&ni<N&&0<=nj&&nj<N&&map[ni][nj]==0) {
					i=ni;
					j=nj;
					map[ni][nj]=x;
				}else {
					d=(d+1)%4;
					i +=di[d];
					j +=dj[d];
					map[i][j]=x;
				}
			}
			sb.append("#").append(t).append("\n");
			for(int a=0 ; a<N; a++) {
				for(int b=0; b<N;b++) {
					sb.append(map[a][b]).append(" ");
				}
				sb.append("\n");
			}
			
		}
		
		System.out.println(sb.toString());
		br.close();

	}

}
