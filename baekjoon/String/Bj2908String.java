package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj2908String {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input = br.readLine();
		
		StringTokenizer st = new StringTokenizer(input);
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int a = 0;
		int b = 0;
		int ww=100;
		
		for(int i=0; i<3;i++) {
			a=a+(A%10)*ww;
			b=b+(B%10)*ww;
			A=A/10;
			B=B/10;
			ww=ww/10;
		}
		
		if(a>b) System.out.println(a);
		else System.out.println(b);
		
		
		br.close();

	}

}
