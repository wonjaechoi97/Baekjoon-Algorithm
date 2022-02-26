package practice0226;
import java.io.*;
import java.util.*;
public class Solution_d1_2072_홀수만더하기 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int sum = 0;
			for(int i=0; i<10;i++) {
				int n = Integer.parseInt(st.nextToken());
				if(n%2==1)sum+=n;
			}
			sb.append("#").append(t).append(" ").append(sum).append("\n");
		}	
		System.out.println(sb.toString());		
		br.close();
	}
}
