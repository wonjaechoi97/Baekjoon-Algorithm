package com.ssafy.pcs;

import java.io.*;
import java.util.*;
public class Solution_d4_1218_괄호짝짓기_대전_5반_최원재 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
	come: for(int i = 0 ; i<10; i++) {
			Stack<Character> stack = new Stack<>();
			int Len = Integer.parseInt(br.readLine());
			String str = br.readLine();
			for(int j=0; j<Len; j++ ) {
				char x = str.charAt(j);
				if(x=='('||x=='{'||x=='['||x=='<') {
					stack.push(x);
				}else {
					if(stack.peek()=='('&&x==')') {
						stack.pop();
					}else if(stack.peek()=='{'&&x=='}') {
						stack.pop();
					}else if(stack.peek()=='['&&x==']') {
						stack.pop();
					}else if(stack.peek()=='<'&&x=='>') {
						stack.pop();
					}else {
						sb.append("#").append((i+1)+" ").append(0).append("\n");
						continue come;
					}
				}
				
			}
			sb.append("#").append((i+1)+" ").append(1).append("\n");
		}
		sb.setLength(sb.length()-1);
		System.out.println(sb.toString());
		
		br.close();
	}

}
