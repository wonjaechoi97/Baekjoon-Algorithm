package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Bj11720String {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		char[] chars = br.readLine().toCharArray();
		int sum=0;
		for(int i=0;i<N;i++) {
			sum+=chars[i]-'0';
		}
		
		System.out.println(sum);
	}

}
