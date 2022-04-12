package p0411;
import java.io.*;
import java.util.*;

public class Main_bj_1197_최소스패닝트리 {
	static class node implements Comparable<node>{
		int from;
		int to;
		int cost;
		public node(int from, int to, int cost) {
			super();
			this.from = from;
			this.to = to;
			this.cost = cost;
		}
		@Override
		public int compareTo(node o) {
			int r=this.cost-o.cost;
			return r;
		}
		
		
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		ArrayList<ArrayList<node>> g = new ArrayList<>();
		for(int i=0; i<=V;i++) {
			g.add(new ArrayList<node>());
		}
		for(int i=0;i<E; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			g.get(from).add(new node(from, to, cost));
			g.get(to).add(new node(to, from, cost));
		}
		long[] dis = new long[V+1];
		Arrays.fill(dis, Integer.MAX_VALUE);
		dis[1]=0;
		PriorityQueue<node> pq = new PriorityQueue<>();
		for(int i=0; i<g.get(1).size(); i++) {
			pq.offer(g.get(1).get(i));
			dis[g.get(1).get(i).to]=g.get(1).get(i).cost;
		}
		boolean[] v = new boolean[V+1];
		v[1]=true;
		int cnt=1;
		long sum=0;
		while(!pq.isEmpty()) {
			node cur = pq.poll();
			if(v[cur.to]) continue;
			sum+=cur.cost;
			cnt++;
			if(cnt==V)break;
			v[cur.to]=true;
			for(int i=0; i<g.get(cur.to).size();i++) {
				if(v[g.get(cur.to).get(i).to])continue;
				pq.add(g.get(cur.to).get(i));
			}
			
		}
		System.out.println(sum);
		br.close();

	}

}
