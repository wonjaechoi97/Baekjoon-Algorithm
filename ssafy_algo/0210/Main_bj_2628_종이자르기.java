package com.ssafy.tree;
import java.io.*;
import java.util.*;
public class Main_bj_2628_종이자르기 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int W = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(br.readLine());
		int max = -1;
		List<Integer> wque = new ArrayList<Integer>();
		List<Integer> hque = new ArrayList<Integer>();
		wque.add(0);
		hque.add(0);
		for(int i =0; i<N;i++) {
			st=new StringTokenizer(br.readLine(), " ");
			if(Integer.parseInt(st.nextToken())==0) {
				wque.add(Integer.parseInt(st.nextToken()));
			}else hque.add(Integer.parseInt(st.nextToken()));
		}
		wque.add(H);
		hque.add(W);
		wque.sort(Comparator.naturalOrder());
		hque.sort(Comparator.naturalOrder());
		for(int i = 0 ; i<wque.size()-1;i++) {
			for(int j = 0 ; j<hque.size()-1;j++) {
				if((wque.get(i+1)-wque.get(i))*(hque.get(j+1)-hque.get(j))>max) {
					max = (wque.get(i+1)-wque.get(i))*(hque.get(j+1)-hque.get(j));
				}
			}
		}
		System.out.println(max);
	}
}
