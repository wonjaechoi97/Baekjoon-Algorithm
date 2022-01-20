package baek;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Bj15552 {

	public static void main(String[] args) {
		try {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		String x = bf.readLine();
		int N = Integer.parseInt(x);
		int a=0, b=0; 
		int sum = 0;
		
		for(int i=0;i<N;i++) {
			st= new StringTokenizer(bf.readLine());
			a=Integer.parseInt(st.nextToken());
			b=Integer.parseInt(st.nextToken());
			
			sum= a+ b;
			
			bw.write(String.valueOf(sum)+"\n");
			
		}
		bf.close();
		bw.close();
		}catch (IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			
		}

	}

}
