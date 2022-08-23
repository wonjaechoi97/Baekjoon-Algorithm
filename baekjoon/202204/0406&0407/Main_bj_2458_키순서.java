package p0406;
import java.io.*;
import java.util.*;

public class Main_bj_2458_키순서 {

	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int inf = 1000;
		int[][] map = new int[N+1][N+1];
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				if(i==j)map[i][j]=0;
				else map[i][j]=inf;
			}
		}
		
		//for(int[] a : map)System.out.println(Arrays.toString(a));
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			map[a][b]=1;
		}
		//for(int[] a : map)System.out.println(Arrays.toString(a));
		
		for(int g = 1 ; g<=N; g++) {
			for(int i=1; i<=N; i++) {
				if(g==i)continue;
				for(int j=1; j<=N; j++) {
					if(g==j)continue;
					if(map[i][j]>map[i][g]+map[g][j])map[i][j]=map[i][g]+map[g][j];
				}
			}
		}
		
		//for(int[] a : map)System.out.println(Arrays.toString(a));
		int cnt = 0;
		for(int i=1; i<=N; i++) {
			int con=0;
			for(int j=1; j<=N; j++) {
				if(i==j)continue;
				if(map[i][j]!=1000||map[j][i]!=1000) {
					con++;
				}
			}
			if(con==N-1)cnt++;
		}
		System.out.println(cnt);
		br.close();
		
		
	}

}
