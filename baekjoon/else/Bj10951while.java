package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj10951while {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String x = br.readLine();
		while(x!=null) {
			StringTokenizer st = new StringTokenizer(x);
			int A=Integer.parseInt(st.nextToken());
			int B =Integer.parseInt(st.nextToken());
			System.out.println(A+B);
			x=br.readLine();
		}
		br.close();

	}

}
