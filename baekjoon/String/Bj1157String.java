package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Bj1157String  {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();
		char[] chars = new char[26];
		boolean dupl = false;
		char max = 0;
		int max_idx = -1;
		int check = 0;
		char[] ch =  s.toCharArray();
		for(int i =0; i<ch.length;i++) {
			if(ch[i]-'a'>=0)chars[ch[i]-'a']++;
			else chars[ch[i]-'A']++;
		}
		
		for(int i=0; i<chars.length;i++) {
			if(chars[i]>=max) {
				max=chars[i];
				max_idx=i;
			}
			
		}
		
		for(int i=0; i<chars.length;i++) {
			if(chars[i]==max) check++;
		}
		
		if(check>=2) System.out.println("?");
		else System.out.println((char)('A'+max_idx));
		br.close();
	}

}
