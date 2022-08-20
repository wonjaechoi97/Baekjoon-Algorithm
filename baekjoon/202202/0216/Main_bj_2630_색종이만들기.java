import java.io.*;
import java.util.*;

public class Main_bj_2630_색종이만들기 {
	static int white;
	static int blue;
	static int[][] map;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for(int j=0; j<N;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}	
		white=0;
		blue=0;
		solve(N,0,0);
		sb.append(white).append("\n").append(blue);
		System.out.println(sb.toString());
		br.close();
	}
	public static void solve(int size, int x, int y) {
		if(size==1) {
			if(map[x][y]==0)white++;
			else blue++;
			return;
		}
		boolean check =true;
		int start = map[x][y];
	
 back : for(int i=x; i<x+size;i++) {
			for(int j=y;j<y+size;j++) {
				if(start!=map[i][j]) {
					check = false;
					break back;
				}
			}
		}
		if(check) {
			if(start==0)white++;
			else blue++;
		}else {
			solve(size/2, x,y);
			solve(size/2, x+size/2,y);
			solve(size/2, x,y+size/2);
			solve(size/2, x+size/2,y+size/2);
		}
	}
}
