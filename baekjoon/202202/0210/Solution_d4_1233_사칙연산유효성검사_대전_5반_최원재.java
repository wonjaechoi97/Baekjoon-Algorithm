package com.ssafy.tree;
import java.io.*;
import java.util.*;
public class Solution_d4_1233_사칙연산유효성검사_대전_5반_최원재 {

	public static void main(String[] args)throws Exception {
		//System.setIn(new FileInputStream("res/input (8).txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String val;
		
		for(int i = 1 ; i<= 10; i++) {
			int N = Integer.parseInt(br.readLine());
			int res = 1;
			for(int j=0; j<N;j++) {
				StringTokenizer st1 = new StringTokenizer(br.readLine()," ");
				st1.nextToken();
				val = st1.nextToken();
				if(!st1.hasMoreTokens()) {
					if(val.equals("+")||val.equals("/")||val.equals("*")||val.equals("-")) {
						res = 0;
						
					}
				}
			}
			sb.append("#").append(i).append(" ").append(res).append("\n");
		}
		System.out.println(sb.toString());
		br.close();
	}

}
