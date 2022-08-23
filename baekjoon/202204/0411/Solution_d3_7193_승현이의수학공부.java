package p0411;
import java.io.*;
import java.util.*;

public class Solution_d3_7193_승현이의수학공부 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T;t++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int N = Integer.parseInt(st.nextToken());
			String X = st.nextToken();
			int num=0;
			for(int i=0; i<X.length();i++) {
				num+=X.charAt(i)-'0';
			}
			sb.append("#").append(t).append(" ").append(num%(N-1)).append("\n");
			
		}
		
		System.out.println(sb.toString());
		
		br.close();

	}

}
