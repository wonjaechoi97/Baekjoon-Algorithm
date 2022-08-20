import java.io.*;
import java.util.*;
public class Main_bj_2839_설탕배달_대전_5반_최원재 {

	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());		
		int something = N/5;
		int a=0;
		int b=0;
		boolean pos=false;
		for(int i=something; i>=0;i--) {
			int c =N;			
			c-=5*i;			
			if(c==0) {
				a=i;
				pos =true;
				break;
			}			
				if(c%3==0) {
				a=i;
				b=c/3;
				pos =true;
				break;
			}
		}		
		if(pos) {
			System.out.println(a+b);
		}else {
			System.out.println(-1);
		}				
		br.close();
	}
}
