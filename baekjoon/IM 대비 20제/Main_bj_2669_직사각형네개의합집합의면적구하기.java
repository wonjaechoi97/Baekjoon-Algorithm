import java.io.*;
import java.util.*;
public class Main_bj_2669_직사각형네개의합집합의면적구하기 {
	static boolean[][] map = new boolean[101][101];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int t=0; t<4;t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			for(int i = y; i<y2;i++) {
				for(int j = x;j<x2; j++) {
					map[i][j]=true;
				}
			}
		}
		
		int sum=0;
		for(int i=1; i<=100;i++) {
			for(int j=1;j<=100;j++) {
				if(map[i][j])sum++;
			}
		}
		System.out.println(sum);
		br.close();

	}

}
