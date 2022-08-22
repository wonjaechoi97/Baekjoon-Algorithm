

import java.io.*;
import java.util.*;

public class Solution_d3_1289_원재의메모리복구_대전_5반_최원재 {

	public static void main(String[] args) throws Exception{
		//System.setIn(new FileInputStream("res/input_d3_1289.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc=1; tc<=T;tc++) {
			int n=0;
			String s = sc.next();
			boolean x =true;
			int[] answer = new int[s.length()];
			int[] my = new int[s.length()];
			for(int i=0; i<s.length();i++) {
				answer[i]=s.charAt(i)-'0';
			}
			
			
				for(int i =0; i<s.length();i++) {
					if(answer[i]!=my[i]) {
						if(answer[i]==1) {
							for(int j=i;j<s.length();j++)
								my[j]=1;
							n++;
						}
						if(answer[i]==0) {
							for(int j=i;j<s.length();j++)
								my[j]=0;
							
							n++;
						}
					}
				}
				System.out.println("#"+tc+" "+n);
		}
		sc.close();
	}

}
