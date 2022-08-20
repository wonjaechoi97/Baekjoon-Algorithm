import java.io.*;
import java.util.*;

public class Main_bj_1753_최단경로 {
	static class Node{
		int vertex, cost;
		Node link;
		public Node(int vertex, int cost, Node link) {	
			this.vertex = vertex;
			this.cost = cost;
			this.link = link;
		}		
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		StringBuilder sb= new StringBuilder();
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		int start = Integer.parseInt(br.readLine());
		Node[] g = new Node[V];
		int[] distance = new int[V];
		for(int i=0; i<V;i++)distance[i] = Integer.MAX_VALUE;
		boolean[] v = new boolean[V];
		
		
		for(int t=0; t<E; t++) {
			st=new StringTokenizer(br.readLine()," ");
			int from = Integer.parseInt(st.nextToken())-1;
			int to = Integer.parseInt(st.nextToken())-1;
			int cost = Integer.parseInt(st.nextToken());
			g[from] = new Node(to,cost,g[from]);//gfrom은 원래 헤드가 제일 앞에 있던에 링크
			
			
		}
		//for(int[] a: g)System.out.println(Arrays.toString(a));
		//distance[0]=-1;
		distance[start-1]=0;//시작점 0
		//System.out.println(Arrays.toString(distance));
		//System.out.println(Arrays.toString(v));
		for(int i=0; i<V;i++) {
			int min = Integer.MAX_VALUE;
			int current = start-1;
			for(int j=0; j<V;j++) {
				if(!v[j]&&min>distance[j]) {
					min = distance[j];
					current = j; // 방문 하지 않은 것 중 가장 작은 정점 찾기 
				}
			}
			v[current] = true;
			if(current == V)break;
			
			for(Node j =g[current]; j!=null;j=j.link) {
	         //  current에서 갈 수 있는 정점의 현재까지 최단 거리 > current까지 최단 거리 + current에서 그정점까지 가는 거리 
				if(!v[j.vertex]&&distance[j.vertex]>distance[current]+j.cost) {
					distance[j.vertex]=distance[current]+j.cost;
				}
				
			}
		}
		for(int i=0; i<V;i++) {
			if(distance[i]==Integer.MAX_VALUE)sb.append("INF").append("\n");
			else sb.append(distance[i]).append("\n");
		}
		System.out.println(sb.toString());
		
		br.close();
	}
}
