package com.ssafy.pcs;
import java.io.*;
import java.util.*;
public class Main_bj_2493_탑_대전_5반_최원재 {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		int[] tow = new int[N];
		int[] check = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		Stack<int[]> stack = new Stack<>();
		Stack<Integer> indexstack = new Stack<>();
		for(int i=1;i<=N;i++) {
			int input =Integer.parseInt(st.nextToken());
			while(!stack.empty()) {
				if(input<=stack.peek()[1]) {
					sb.append(stack.peek()[0]).append(" ");
					break;
				}else {
					
					stack.pop(); // top에 있는게 새로 들어온 것보다 작아서 고려할 가치가 없다.
				}
			
			}
			if(stack.isEmpty()) {
				sb.append("0 ");//
			}
			stack.push(new int[] {i,input});
		}
		
		
		sb.setLength(sb.length()-1);
		System.out.println(sb.toString());
		br.close();
	}

}
