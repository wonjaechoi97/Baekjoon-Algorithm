package practice0226;
import java.io.*;
import java.util.*;
public class Main_bj_2563_색종이_대전_5반_최원재 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int [][] map = new int[101][101];
		for(int t=0; t<N;t++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int x= Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			for(int i=x; i<x+10; i++) {
				for(int j=y; j<y+10; j++) {
					map[i][j]=1;
				}
			}
		}
		int sum = 0;
		for(int i=0; i<=100; i++) {
			for(int j=0; j<=100;j++) {
				sum+=map[i][j];
			}
		}
		System.out.println(sum);
		br.close();

	}

}
