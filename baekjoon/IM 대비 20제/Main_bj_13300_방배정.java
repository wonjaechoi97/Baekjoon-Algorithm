import java.io.*;
import java.util.*;
public class Main_bj_13300_방배정 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N =Integer.parseInt(st.nextToken());
		int K =Integer.parseInt(st.nextToken());
		int[][] student = new int[7][2];
		for(int i =0;i<N;i++) {
			st = new StringTokenizer(br.readLine()," ");
			int gen = Integer.parseInt(st.nextToken());
			int gra = Integer.parseInt(st.nextToken());
			student[gra][gen]++;
		}
		int sum=0;
		for(int i=1; i<=6;i++) {
			for(int j=0;j<=1;j++) {
				int ex = student[i][j]/K;
				if(ex*K<student[i][j])sum+=(ex+1);
				else sum+=ex;
			}
		}
		System.out.println(sum);
		br.close();
	}
}
