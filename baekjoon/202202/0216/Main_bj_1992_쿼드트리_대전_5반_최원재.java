import java.io.*;
import java.util.*;
public class Main_bj_1992_쿼드트리_대전_5반_최원재 {
	static int[][] map;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		//System.out.println(N);
		map = new int[N][N];
		for(int i=0; i<N; i++) {
			String line = br.readLine();
			for(int j=0; j<N;j++) {
				map[i][j]=line.charAt(j)-'0';
			}
		}
		solve(N,0,0);
		System.out.println(sb.toString());
		br.close();

	}
	static void solve(int size, int x, int y) {
		if(size==2) {
			int start = map[x][y];
			
			if(start==map[x][y+1]&&start==map[x+1][y+1]&start==map[x+1][y]) {
				sb.append(start);
			}else {
				sb.append("(").append(map[x][y]).append(map[x][y+1]).append(map[x+1][y]).append(map[x+1][y+1]).append(")");
			}
			return;
		}
		int start = map[x][y];
		boolean check = true;
		first : for(int i=x;i<x+size;i++) {
					for(int j=y;j<y+size;j++) {
						if(start!=map[i][j]) {
							check = false;
							break first;
						}
					}
				}
		if(check) {
			sb.append(start);
		}else {
			sb.append("(");
			solve(size/2,x,y);
			solve(size/2,x,y+size/2);
			solve(size/2,x+size/2,y);
			solve(size/2,x+size/2,y+size/2);
			sb.append(")");
		}
	}
}
