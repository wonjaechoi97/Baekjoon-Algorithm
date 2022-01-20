package baek;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


public class Bj15552_1 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int a=0, b=0, sum=0;
		
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i = 0; i<N;i++) {
			st = new StringTokenizer(br.readLine());
			a= Integer.parseInt(st.nextToken());
			b=Integer.parseInt(st.nextToken());
			
			sum = a+b;
			bw.write(String.valueOf(sum)+"\n");
			
		}
		br.close();
		bw.close();
		
		
	}
}
