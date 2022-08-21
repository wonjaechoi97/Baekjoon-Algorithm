package practice0322;
import java.io.*;
import java.util.*;

public class Solution_d4_3124_최소스패닝트리_대전_5반_최원재2 {
	static class Edge implements Comparable<Edge>{
		int from;
		int to;
		int cost;
		
		public Edge(int from, int to, int cost) {
			this.from = from;
			this.to = to;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge o) {
			int r = this.cost-o.cost;
			return r;
		}
	}
	static int V; 
	static int[] parents;
	static Edge[] edgelist;
	
	static void makeSet() {
		parents = new int[V+1];
		
		for(int i=1; i<V+1; i++) {
			parents[i]=i;
		}
	}
	
	static int findset(int a) {
		if(a==parents[a])return a;
		return parents[a]=findset(parents[a]);
	}
	
	static boolean union(int a, int b) {
		int aRoot = findset(a);
		int bRoot = findset(b);
		if(aRoot==bRoot) return false;// 순환 고리 생성 
		
		parents[bRoot] = aRoot;
		return true;
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T;t++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			edgelist = new Edge[E];
			for(int i=0; i<E; i++) {
				st = new StringTokenizer(br.readLine()," ");
				int from = Integer.parseInt(st.nextToken());		
				int to = Integer.parseInt(st.nextToken());
				int cost = Integer.parseInt(st.nextToken());
				edgelist[i]=new Edge(from, to, cost);
			}
			
			Arrays.sort(edgelist); //정렬을 시키기 때문에 가장 짧은 것 부터 뽑는다.
			makeSet();
			long result =0;
			int cnt=0;
			for(Edge e : edgelist) {
				if(union(e.from, e.to)) {
					result+=e.cost;
					if(++cnt==V-1)break;
				}
				
			}
			sb.append("#").append(t).append(" ").append(result).append("\n");
			
			
		}
		System.out.println(sb.toString());
		br.close();

	}

}

