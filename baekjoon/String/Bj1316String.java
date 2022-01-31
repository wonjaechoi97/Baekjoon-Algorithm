package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Bj1316String {
//문자가 들어오고 처음부터 탐색 만약 자신이 아닌 다른 문자가 들어올 시 그 뒤르 탐색 
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] check = new int[N];
		int sum = 0;
	come : for(int i = 0 ; i< N; i++) {
			String S= br.readLine();
			char[] charr=S.toCharArray(); 
			for(int j =0; j<26;j++) {
				for(int k=0; k<charr.length; k++) {
					char x = charr[k];
					for(int t =k+1; t<charr.length; t++) {
						if(charr[t]==x&&charr[t-1]!=x) {
							continue come;
						}
					}
				}
			}
			check[i]=1;
			
		}
		
		for(int i=0; i<N;i++) {
			if(check[i]==1)sum++;
		}
		
		System.out.println(sum);

	}

}
