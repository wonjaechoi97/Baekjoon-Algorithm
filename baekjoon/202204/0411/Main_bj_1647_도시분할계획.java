package p0411;
import java.io.*;
import java.util.*;

public class Main_bj_1647_도시분할계획 {
	
	static class node implements Comparable<node>{
		int node;
		int cost;
		public node(int node, int cost) {
			
			this.node = node;
			this.cost = cost;
		}
		@Override
		public int compareTo(node o) {
			// TODO Auto-generated method stub
			return this.cost-o.cost;
		}
		
	}
	
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		ArrayList<ArrayList<node>> g = new ArrayList<>();
		for(int i=0; i<N+1;i++) {
			g.add(new ArrayList<node>());
		}
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			g.get(from).add(new node(to, cost));
			g.get(to).add(new node(from, cost));
		}
		PriorityQueue<node> pq = new PriorityQueue<>();
		int sum=0;
		int[] dis = new int[N+1];
		int max=-1;
		
		Arrays.fill(dis, -1);
		pq.add(new node(1, 0));
		int cnt=0;
		while(!pq.isEmpty()) {
			node cur =pq.poll();
			if(dis[cur.node]!=-1)continue;
			dis[cur.node]=cur.cost;
			cnt++;
			if(cur.cost>max)max=cur.cost;
			sum+=cur.cost;
			if(cnt==N)break;
			for(int i=0; i<g.get(cur.node).size();i++) {
				if(dis[g.get(cur.node).get(i).node]!=-1)continue;
				pq.offer(g.get(cur.node).get(i));
			}
		}
		//System.out.println(Arrays.toString(dis));
		System.out.println(sum-max);
		br.close();

	}

}
