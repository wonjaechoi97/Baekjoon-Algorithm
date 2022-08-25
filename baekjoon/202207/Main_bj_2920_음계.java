package p07;

import java.io.*;
import java.util.*;

public class Main_bj_2920_음계 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int start = Integer.parseInt(st.nextToken());
		
		int result = 0;
		
		if(start==1) {
			result = 1;
			for(int i=1; i<8; i++) {
				int n = Integer.parseInt(st.nextToken());
				if(n>start) {
					start = n;
				}else {
					result = 3;
					break;
				}
			}
		}else if(start ==8) {
			result = 2;
			for(int i=1; i<8; i++) {
				int n = Integer.parseInt(st.nextToken());
				if(n<start) {
					start = n;
				}else {
					result = 3;
					break;
				}
			}
		}else {
			result = 3;
		}
		
		if(result==1) {
			System.out.println("ascending");
		}else if(result==2) {
			System.out.println("descending");
		}else {
			System.out.println("mixed");
		}
		
		br.close();

	}

}
