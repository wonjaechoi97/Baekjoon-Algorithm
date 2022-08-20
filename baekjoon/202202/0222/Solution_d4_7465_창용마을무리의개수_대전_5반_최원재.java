import java.io.*;
import java.util.*;

public class Solution_d4_7465_창용마을무리의개수_대전_5반_최원재 {
	static int[] parents;
	static void makeset(int N) {
		for(int i=1; i<=N;i++) {
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
		if(aRoot == bRoot) return false;
		parents[bRoot]=aRoot;
		return true;
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(); 
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T;t++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int N = Integer.parseInt(st.nextToken());//접점 수
			int M = Integer.parseInt(st.nextToken());//간선 수
			parents = new int[N+1];
			makeset(N);
			for(int m=0; m<M; m++) {
				st = new StringTokenizer(br.readLine()," ");
				union(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			for(int i=1; i<=N;i++) {
				findset(i);
			}
			
			List<Integer> result = new ArrayList<Integer>();
			result.add(parents[1]);
			here:for(int i=2; i<=N;i++) {
				for(int j=0; j<result.size();j++) {
					if(result.get(j)==parents[i]) {
						continue here;
					}
					
				}
				result.add(parents[i]);
			}
			sb.append("#").append(t).append(" ").append(result.size()).append("\n");
			//System.out.println(result.toString());
			//System.out.println(result.size());
		}
		System.out.println(sb.toString());
	}
}
