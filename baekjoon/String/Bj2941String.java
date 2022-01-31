package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Bj2941String {

	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		String s1=s;
		String[] str = {"c=","c-","dz=","d-","lj","nj","s=","z="};
		int b = 0;
		int count=0;
	come : while(true) {
		for(int i=0; i<str.length;i++) {
			if(s.contains(str[i])) {
				count++;
				s=s.replaceFirst(str[i], " ");
				if(i==2)b+=3;
				else b+=2;
				continue come;
			}
			
		}
		break;
		
	}
		
		count = count +s1.length()-b;
		System.out.println(count);
		
	
	}
}
