package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Bj3052 {
/*
 * for문을 두번 활용
 * 나머지가 하나 들어올 때마다 그 전까지 들어온 수와 비교할 것 
 * 그 전까지 들어온 모든 수와 다르다면 ++
 */
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] num = new int[10];
		int dif = 0;
		
		for(int i=0; i< 10;i++) {
			int x = Integer.parseInt(br.readLine());
			int t =0;
			num[i]=x%42;
			for(int k=0;k<i;k++) {
				if(num[k]!=num[i]) t++;
				
			}
			if(t==i)dif++;
			
			
			
			
		}
		System.out.println(dif);
		br.close();
	}

}
