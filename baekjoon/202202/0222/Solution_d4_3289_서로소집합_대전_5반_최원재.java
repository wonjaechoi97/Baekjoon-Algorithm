import java.io.*;
import java.util.*;
public class Solution_d4_3289_서로소집합_대전_5반_최원재 {
	static int[] parents;
	
	static void makeset(int N) {
		for(int i =1; i<=N;i++) {
			parents[i]=i;
		}
		//System.out.println(Arrays.toString(parents));
	}
	static int findset(int a) {
		if(a==parents[a])return a;
		return parents[a]=findset(parents[a]);
	}
	static boolean union(int a, int b) {
		int aRoot = findset(a);
		int bRoot = findset(b);
		if(aRoot==bRoot)return false;
		parents[bRoot]=aRoot;
		return true;
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T;t++) {
			sb.append("#").append(t).append(" ");
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int N= Integer.parseInt(st.nextToken());//연사 수
			int M = Integer.parseInt(st.nextToken()); //숫자 수
			
			parents=new int[N+1];
			makeset(N);
			//System.out.println(Arrays.toString(parents));
			for(int m=0; m<M;m++ ) {
				st = new StringTokenizer(br.readLine()," ");
				int op = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				if(op==0) {
					union(a,b);
				}else {
										
					if(findset(a)==findset(b)){
						sb.append(1);
					}else {
						sb.append(0);
					}
				}
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
		br.close();
	}

}
