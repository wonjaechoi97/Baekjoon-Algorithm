package practice0227;
import java.io.*;
import java.util.*;
public class Main_bj_2669_직사각형네개의합집합의면적구하기_대전_5반_최원재 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] map = new int[101][101];
		
		for(int i=0; i<4; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			for(int x=x1; x<x2;x++) {
				for(int y = y1; y<y2;y++) {
					map[x][y]=1;
				}
			}
			
		}
		int sum=0;
		for(int i=0; i<=100;i++) {
			for(int j=0; j<=100;j++) {
				sum+=map[i][j];
			}
		}
		System.out.println(sum);

	}

}
