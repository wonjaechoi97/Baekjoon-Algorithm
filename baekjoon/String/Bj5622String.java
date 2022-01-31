package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Bj5622String {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		String[] dial= {"ABC","DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ"};
		
		char[] chars = s.toCharArray();
		int sum = 0;
		for(int i =0; i<chars.length;i++) {
			for(int j=0;j<dial.length;j++) {
				if(dial[j].contains(Character.toString(chars[i]))) {
					sum+=j+3;
				}
			}
		}
		
		System.out.println(sum);

	}

}
