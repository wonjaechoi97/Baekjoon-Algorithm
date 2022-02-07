package com.ssafy.pcs;

import java.io.*;
import java.util.*;

public class Solution_d3_5215_햄버거먹기_대전_5반_최원재 {
	static int N;
	static int Callimit, sum_cal,sum_taste, max;
	static int[] cal;
	static int[] Taste;
	static boolean[] visited;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int i=0; i< T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			Callimit=Integer.parseInt(st.nextToken());
			visited= new boolean[N];
			
			Taste = new int[N];
			cal = new int[N];
			max = 0;
			for(int j=0; j<N; j++) {
				st = new StringTokenizer(br.readLine());
				Taste[j]=Integer.parseInt(st.nextToken());
				cal[j]=Integer.parseInt(st.nextToken());
			}
			subset(0);
			sb.append("#").append(i+1).append(" ").append(max).append("\n");
			
		}
		sb.setLength(sb.length()-1);
		System.out.println(sb.toString());
		
		br.close();

	}
	static  void subset(int cnt) {
		if(cnt == N) {
			sum_cal=0;
			sum_taste=0;
			for(int i =0 ; i<N;i++) {
				if(visited[i]==true) {
					sum_cal+=cal[i];
					sum_taste+=Taste[i];
				}
			}
			//System.out.println(sum_taste);
			if(sum_cal<=Callimit&&sum_taste>max) {
				max=sum_taste;
			}
			return;
		}
		
		visited[cnt]=true;
		subset(cnt+1);
		visited[cnt]=false;
		subset(cnt+1);
		
	}

}
