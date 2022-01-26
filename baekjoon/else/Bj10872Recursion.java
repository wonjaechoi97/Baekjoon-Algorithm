package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Bj10872Recursion {

	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int i = Integer.parseInt(br.readLine());
		
		System.out.println(multi(i));
		
		br.close();
		

	}
	public static int multi(int i) {
		if(i==0)return 1;
		return multi(i-1)*i;
	}

}
