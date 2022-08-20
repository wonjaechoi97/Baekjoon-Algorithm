import java.io.*;
import java.util.*;

public class Solution_d5_1247_최적경로_대전_5반_최원재 {
	static boolean[][] checked = new boolean[101][101];
	static int[][] visit;
	static int N;
	static int min ;
	static int home_i;
	static int home_j;
	
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_1247.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());//테케 수
		
		
		for(int t=1; t<=T;t++) {
			N = Integer.parseInt(br.readLine());//고객 수
			visit = new int[N][2];// 방문 할 집 좌표 저장용
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int com_i = Integer.parseInt(st.nextToken());
			int com_j = Integer.parseInt(st.nextToken());
			home_i = Integer.parseInt(st.nextToken());
			home_j = Integer.parseInt(st.nextToken());
			for(int i=0; i<N;i++) {
				
				visit[i][0]=Integer.parseInt(st.nextToken());
				visit[i][1]=Integer.parseInt(st.nextToken());
			}
			min = Integer.MAX_VALUE;
			solve(0,0,com_i,com_j);
			
			sb.append("#"+t+" ").append(min).append("\n");
		}
		System.out.println(sb.toString());
		
		br.close();
		

	}
	
	static void solve(int sum, int cnt, int ni, int nj) {
		if(sum>min)return;
		if(cnt==N) {
			sum+=Math.abs(home_i-ni)+Math.abs(home_j-nj);
			if(sum<min)min=sum;
			return;
		}
		
		for(int i=0;i<N;i++) {
			if(checked[visit[i][0]][visit[i][1]])continue;
			checked[visit[i][0]][visit[i][1]] = true;
			solve(sum+Math.abs(visit[i][0]-ni)+Math.abs(visit[i][1]-nj), cnt+1, visit[i][0], visit[i][1]);
			checked[visit[i][0]][visit[i][1]] = false;						
		}
	}
}
