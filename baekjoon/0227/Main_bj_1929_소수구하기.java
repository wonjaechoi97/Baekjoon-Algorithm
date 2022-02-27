package practice0227;
import java.io.*;
import java.util.*;
public class Main_bj_1929_소수구하기 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb =new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int a= Integer.parseInt(st.nextToken());
		int b= Integer.parseInt(st.nextToken());
		
		label:for(int i=a; i<=b; i++) {
			if(i==1)continue;
			for(int j=2; j <=Math.sqrt(i);j++) {
				if(i%j==0) {
					continue label;
				}
			}
			sb.append(i).append("\n");			
		}
		System.out.println(sb.toString());
		br.close();

	}

}
