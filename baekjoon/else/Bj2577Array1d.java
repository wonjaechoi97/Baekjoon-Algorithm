package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Bj2577Array1d {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int A = Integer.parseInt(br.readLine());
		int B = Integer.parseInt(br.readLine());
		int C = Integer.parseInt(br.readLine());
		
		int num = A*B*C;
		String X = Integer.toString(num);
		
		char[] chars = X.toCharArray();
		int[] numbers = new int[10];
		for(int i=0; i<X.length();i++) {
			numbers[chars[i]-'0']++;
		}
		
		for(int i : numbers)System.out.println(i);
		br.close();

	}

}
