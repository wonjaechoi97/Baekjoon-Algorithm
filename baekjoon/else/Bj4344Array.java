package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj4344Array {

	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int C = Integer.parseInt(br.readLine());
		for(int i=0;i<C;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int sum=0;
			int stu = 0;
			int N=Integer.parseInt(st.nextToken());
			int[] score = new int[N];
			
			for(int j=0; j<N;j++) {
				int x = Integer.parseInt(st.nextToken());
				score[j]=x;
				sum+=x;
			}
			double avg = (1.0*sum)/N;
			
			
			for(int k=0;k<N;k++) {
				if(score[k]>avg)stu++;
			}
			System.out.printf("%.3f%%\n",(100.0)*stu/N);
		}

	}

}
