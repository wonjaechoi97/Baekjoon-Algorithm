package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Bj10818 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int[] a = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i =0 ; i< N ; i++) {
			a[i]= Integer.parseInt(st.nextToken());
			
		}
		
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		
		for(int i =0 ; i< a.length; i++) {
			if(max<a[i])max=a[i];
			if(min>a[i])min = a[i];			
			
		}
		
		System.out.println(min+" "+max);
		br.close();
		
	}

}
