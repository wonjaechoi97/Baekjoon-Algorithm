package com.ssafy.tree;
import java.io.*;
import java.util.*;
public class Main_bj_2563_색종이_대전_5반_최원재 {

	public static void main(String[] args)  throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		int[][] map = new int [100][100];
		int[][] input = new int[N][2];
		
		for(int i = 0 ; i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			input[i][0]=a;
			input[i][1]=b;
		}
		for(int x=0; x<N; x++) {
			for(int i=0; i<10; i++) {
				for(int j=0; j<10;j++) {
					map[input[x][0]+i][input[x][1]+j]=1;
				}
			}
		}
		
		int cnt =0;
		for(int i =0;i<100;i++) {
			for(int j=0; j<100; j++) {
				cnt+=map[i][j];
			}
		}
		System.out.println(cnt);
	}
}
