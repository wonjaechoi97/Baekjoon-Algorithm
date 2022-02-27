package practice0227;
import java.io.*;
import java.util.*;
public class Main_bj_10163_색종이_대전_5반_최원재 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int[][] map = new int[1001][1001];
		
		int N = Integer.parseInt(br.readLine());
		int count[] = new int[N+1];
		for(int t=1; t<=N;t++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int w= Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			for(int i=x; i<x+w;i++) {
				for(int j=y; j<y+h; j++) {
					map[i][j]=t;
				}
			}
			
		}
	

			for(int i=0;i<1001; i++) {
				for(int j=0; j<1001; j++) {
					count[map[i][j]]++;
						
					}
				}
		
		for(int i=1;i<=N;i++) {
			sb.append(count[i]).append("\n");
		}
		System.out.println(sb.toString());
		
		br.close();				
	}
}
