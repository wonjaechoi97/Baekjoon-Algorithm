package p0406;
import java.io.*;
import java.util.*;

public class Main_bj_2239_스도쿠 {
	static boolean complete;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int[][] map = new int[9][9];
		
		for(int i=0; i<9; i++) {
			String str = br.readLine();
			for(int j=0; j<9; j++) {
				map[i][j]=str.charAt(j)-'0';
			}
		}
		complete=false;
		solve(0, 0, map);
		for(int i=0; i<9; i++) {
			for(int j=0; j<9; j++) {
				sb.append(map[i][j]);
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
		br.close();

	}
	static void solve(int i, int j, int[][] map) {
		//System.out.println(i+" "+j);
		while(true) {
			if(j==9) {
				i++;
				j=0;
			}
			if(i==9) {
				complete=true;
				//for(int[] a : map)System.out.println(Arrays.toString(a));
				break;
			}
			if(map[i][j]==0) {
			label:for(int n=1; n<=9; n++) {
				//System.out.println(1);
					// 가로 검색
					for(int nj=0; nj<9; nj++) {
						if(map[i][nj]==n) {
							continue label;
						}
					}
					//세로 검색
					for(int ni=0; ni<9; ni++) {
						if(map[ni][j]==n) {
							continue label;
						}
					}
					int starti=0, startj=0;
					if(i<3)starti=0;
					else if(i<6)starti=3;
					else starti = 6;
					if(j<3)startj=0;
					else if(j<6)startj=3;
					else startj = 6;
					for(int ni=starti; ni<starti+3; ni++) {
						for(int nj=startj; nj<startj+3; nj++) {
							if(map[ni][nj]==n) continue label;
						}
					}
					map[i][j]=n;
					solve(i, j+1, map);
					if(complete)break;
					map[i][j]=0;
					
				}
				return;
			}else {
				j++;
			}
		}
	}

}
