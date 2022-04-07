package p0406;
import java.io.*;
import java.util.*;
public class Main_bj_11404_플로이드 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb= new StringBuilder();
		int n= Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		int[][] map = new int[n+1][n+1];
		int inf = 100000001;
		for(int i=1;i<=n; i++) {
			for(int j=1; j<=n ;j++) {
				if(i==j)continue;
				map[i][j]=inf;
			}
		}
		for(int i=0; i<m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost= Integer.parseInt(st.nextToken());
			if(map[from][to]>cost)map[from][to]=cost;
//			for(int[] a:map )System.out.println(Arrays.toString(a));
//			System.out.println();
		}
//		for(int[] a:map )System.out.println(Arrays.toString(a));
		//System.out.println();
		for(int g=1; g<=n; g++) {
			for(int i=1; i<=n; i++) {
				if(i==g)continue;
				for(int j=1; j<=n; j++) {
					if(i==j||g==j)continue;
					if(map[i][j]>map[i][g]+map[g][j])map[i][j]=map[i][g]+map[g][j];
				}
			}
		}
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				if(map[i][j]==inf)sb.append(0).append(" ");
				else sb.append(map[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
		br.close();

	}

}
