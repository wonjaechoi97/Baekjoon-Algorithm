package com.ssafy.tree;
/*
 * 링크드 리스트를 사용해서
 * 총 사이즈 제거된 위치를 갱신해서 n번째를 계속 제거하자.
 * 길이가 주어진 수 보다 작으면 순서대로 제거
 */
import java.io.*;
import java.util.*;
public class Main_bj_1158_요세푸스_대전_5반_최원재 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		List<Integer> list = new LinkedList<Integer>();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		for(int i = 1 ; i<=N ;i++) {
			list.add(i);
		}
		int index = 0;
		sb.append("<");
		while(!list.isEmpty()) {
			int size = list.size();
			index=(index+K-1)%size;		
			sb.append(list.remove(index)).append(", ");	
		}
		sb.setLength(sb.length()-2);
		sb.append(">");
		System.out.println(sb.toString());
		br.close();
	}
}
