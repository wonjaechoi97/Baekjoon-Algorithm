import java.io.*;
import java.util.*;
public class Main_bj_2775_부녀회장이될테야 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		int[][] building = new int[15][15];
		for(int i=1;i<=14;i++ ) {
			building[0][i]=i;
		}
		for(int i= 1;i<=14;i++) {
			
			for(int j=1;j<=14;j++) {
				for(int k=1;k<=j;k++) {
					building[i][j]+=building[i-1][k];
				}
			}
			
		}
		for(int i=0;i<T;i++) {
			int k = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());
			sb.append(building[k][n]).append("\n");
		}
		System.out.println(sb.toString());
		br.close();

	}

}
