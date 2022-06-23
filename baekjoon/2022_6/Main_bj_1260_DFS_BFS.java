package algo06;

import java.io.*;
import java.util.*;
public class Main_bj_1260_DFS_BFS {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken()); //시작 정점
		
		int[][] graph = new int[N+1][N+1];
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			graph[from][to]=graph[to][from]=1;
			
		}
		
		boolean[] visited = new boolean[N+1];
		dfs(V, visited, N, graph);
		System.out.println();
		visited = new boolean[N+1];
		bfs(graph, visited, V, N);
		
		br.close();
		

	}
	
	static void dfs(int cur, boolean[] visited, int N, int[][] graph) {
		System.out.print(cur+" ");
		visited[cur]=true;//방문 처리
		for(int i=1; i<=N; i++) {
			if(i==cur)continue;
			if(graph[cur][i]==1&&!visited[i]) {
				dfs(i, visited, N, graph);
			}
		}
	}
	
	static void bfs(int[][] graph, boolean[] visited, int V, int N) {
		Queue<Integer> que = new ArrayDeque<Integer>();
//		for(int i=1; i<=N; i++) {
//			if(graph[V][i]==1) {
//				que.offer(i);
//			}
//		}
		que.offer(V);
		
		while(!que.isEmpty()) {
			int cur = que.poll();
			if(visited[cur])continue;
			visited[cur]=true;
			System.out.print(cur+" ");
			for(int i=1; i<=N; i++) {
				if(graph[cur][i]==1&&!visited[i]) {
					que.offer(i);
				}
			}
		}
		
	}

}
