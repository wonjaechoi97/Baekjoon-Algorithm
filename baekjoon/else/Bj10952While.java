package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj10952While {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			String s = br.readLine();
			StringTokenizer st = new StringTokenizer(s);
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int result = A+B;
			if(A==0&B==0)break;
			System.out.println(result);
		}
		
	

	}

}
