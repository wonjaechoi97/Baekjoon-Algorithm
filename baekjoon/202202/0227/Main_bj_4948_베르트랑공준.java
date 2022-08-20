package practice0227;
import java.io.*;
import java.util.*;
public class Main_bj_4948_베르트랑공준 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(true) {
			int n = Integer.parseInt(br.readLine());
			if(n==0)break;
			int count=0;
			label:for(int i=n+1; i<=2*n; i++) {
				for(int j=2;j<=Math.sqrt(i);j++) {

					if(i%j==0)continue label;
				}
				count++;
			}
			sb.append(count).append("\n");
		}
		System.out.println(sb.toString());
	}

}
