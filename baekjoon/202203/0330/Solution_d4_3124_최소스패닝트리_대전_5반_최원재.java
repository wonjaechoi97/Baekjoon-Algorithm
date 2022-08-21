package practice0322;
import java.io.*;
import java.util.*;

public class Solution_d4_3124_최소스패닝트리_대전_5반_최원재 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T;t++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			
			ArrayList<ArrayList<node2>> g = new ArrayList<>();
			
			for(int i=0; i<V+1; i++) {
				g.add(new  ArrayList<node2>());
			}
			
			for(int i=0; i<E;i++) {
				st = new StringTokenizer(br.readLine()," ");
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				int cost = Integer.parseInt(st.nextToken());
				g.get(from).add(new node2(from, to, cost));
				g.get(to).add(new node2(to, from, cost));
			}
			
			boolean[] v = new boolean[V+1];
			PriorityQueue<node2> pq= new PriorityQueue<>();
			v[1]=true;
			for(int i=0; i<g.get(1).size();i++) {
				pq.add(g.get(1).get(i));
			}
			int ncount=1;
			long count =0;
			while(!pq.isEmpty()) {
				
				node2 cur = pq.poll();
				//System.out.println(cur.from + " "+cur.to);
				if(v[cur.to])continue;
				count+=cur.cost;
				v[cur.to]=true;
				ncount++;
				if(ncount==V)break;
				for(int i=0; i<g.get(cur.to).size(); i++) {
					pq.add(g.get(cur.to).get(i));
				}
				
				//System.out.println(1);
				
			}
			sb.append("#").append(t).append(" ").append(count).append("\n");
		}
		System.out.println(sb.toString());
		br.close();

	}

}
class node2 implements Comparable<node2>{
	int from;
	int to;
	int cost;
	
	public node2(int from, int to, int cost) {
		this.from = from;
		this.to = to;
		this.cost = cost;
	}

	@Override
	public int compareTo(node2 o) {
		int r = this.cost-o.cost;
		return r;
	}
}
