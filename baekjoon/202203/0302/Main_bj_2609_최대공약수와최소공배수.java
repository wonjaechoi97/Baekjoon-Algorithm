package practice0302;
import java.io.*;
import java.util.*;
public class Main_bj_2609_최대공약수와최소공배수 {

	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int a= Integer.parseInt(st.nextToken());
		int b= Integer.parseInt(st.nextToken());
		int gongbae=0;
		int gongyak=0;
		
		if(a>b) {
			for(int i=b; i>=1; i--) {
				if(a%i==0&&b%i==0) {
					gongyak = i;
					break;
				}
			}
			for(int i= a; i<100000000;i++) {
				if(i%a==0&&i%b==0) {
					gongbae = i;
					break;
				}
			}
		}else {
			for(int i=a; i>=1; i--) {
				if(a%i==0&&b%i==0) {
					gongyak = i;
					break;
				}
			}
			for(int i= b; i<100000000;i++) {
				if(i%a==0&&i%b==0) {
					gongbae = i;
					break;
				}
			}
		}
		System.out.println(gongyak);
		System.out.println(gongbae);
		br.close();

	}

}
