package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj1546Array {

	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N =Integer.parseInt(br.readLine());
		double[] score = new double[N];
		double max = -1;
		double total=0;
		double avg;
		String S = br.readLine();
		StringTokenizer st = new StringTokenizer(S);
		for(int i=0;i<N;i++) {
			
			score[i]=Double.parseDouble(st.nextToken());
			if(score[i]>max)max = score[i];
		}
		
		for(int i=0; i<N;i++) {
			score[i]=(score[i]/max)*100;
			total+=score[i];
		}
		
		avg=total/N;
		
		System.out.println(avg);

	}

}
