package practice0321;

import java.io.*;
import java.util.*;

public class Main_bj_2608_바이러스 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());//컴 수
		int c = Integer.parseInt(br.readLine());//연결 수
		ArrayList< ArrayList<Integer> > g = new ArrayList<>();
		for(int i=0; i<N+1;i++) {
			g.add(new ArrayList<Integer>());
		}
		
		boolean[] v = new boolean[N+1];
		for(int i=0; i<c;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int index = Integer.parseInt(st.nextToken());
			int connect = Integer.parseInt(st.nextToken());
			g.get(index).add(connect);
			g.get(connect).add(index);
		}
		Queue<Integer> que = new ArrayDeque<>();
		que.add(1);
		v[1]=true;
		int cnt=0;
		while(!que.isEmpty()) {
			int cur = que.poll();
			for(int i=0; i<g.get(cur).size(); i++) {
				if(v[g.get(cur).get(i)]) {
					continue;
				}else {
					v[g.get(cur).get(i)]=true;
					cnt++;
					que.add(g.get(cur).get(i));
					
				}
			}
		}
		
		System.out.println(cnt);
		
		
		br.close();

	}

}
