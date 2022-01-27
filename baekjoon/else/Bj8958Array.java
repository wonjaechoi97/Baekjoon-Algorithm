package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Bj8958Array {
/*
 * 문자열을 입력 받는다. 받은 후 char 배열에 넣고 
 * 이 배열과 같은 크기의 배열을 넣어서 뒤와 비교해서 1씩 늘린다. 자신이 O이고 그 전이 1이면 자신은 2 자신이 o고 그 전이 0이면 1
 */
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N =Integer.parseInt(br.readLine());
		
		for(int i = 0 ; i<N; i++) {
			int sum=0;
			String s = br.readLine();
			char[] chars = s.toCharArray();
			int[] num = new int[chars.length];
			for(int j=0;j<num.length;j++) {
				if(j==0) {
					if(chars[j]=='O') {
						num[j]=1;
					}else num[j]=0;
				}else {
					if(chars[j]=='O') {
						num[j]=num[j-1]+1;
					}else num[j]=0;
				}
				
			}
			for(int j=0; j<num.length;j++) {
				sum+=num[j];
			}
			System.out.println(sum);
		}

	}

}
