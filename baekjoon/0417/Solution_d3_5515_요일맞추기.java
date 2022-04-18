package p0417;
import java.io.*;
import java.util.*;

public class Solution_d3_5515_요일맞추기 {

	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb =new StringBuilder();
		int[] day = new int[13];
		for(int i=1; i<=12; i++) {
			day[i]=31;
		}
		day[2]=29;
		day[4]=30;
		day[6]=30;
		day[9]=30;
		day[11]=30;
		
		int[] day7 = new int[7];
		day7[0]= 3;
		day7[1]= 4;
		day7[2]= 5;
		day7[3]= 6;
		day7[4]= 0;
		day7[5]= 1;
		day7[6]= 2;
		
		int T = Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int m = Integer.parseInt(st.nextToken());
			int d=Integer.parseInt(st.nextToken());
			int sum=0;
			
			for(int i=1; i<=m-1;i++) {
				sum+=day[i];
			}
			sum+=d;
			sb.append("#").append(t).append(" ").append(day7[sum%7]).append("\n");
			
		}
		System.out.println(sb.toString());
		
		br.close();

	}

}
