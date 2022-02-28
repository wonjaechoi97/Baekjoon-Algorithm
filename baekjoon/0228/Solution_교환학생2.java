package practice0228;
import java.io.*;
import java.util.*;
public class Solution_교환학생2 {

	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T;t++) {
			int N = Integer.parseInt(br.readLine());
			int[] day = new int[7];
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for(int i=0; i<7;i++) {
				
				day[i]= Integer.parseInt(st.nextToken());
				
			}
			
			
			int cnt = 0;
			int start_day=0;
			int min = Integer.MAX_VALUE;
			int days=1;
		for(int d =0; d<7;d++) {
			if(day[d]==0)continue;
			days = 1;
		
			cnt=0;
			start_day=d;
			while(true) {
				if(day[start_day%7]==1)cnt++;
				
				if(cnt==N)break;
				start_day++;
				days++;
				
				
			}
			if(days<min)min=days;
		}
			
			sb.append("#").append(t).append(" ").append(min).append("\n");
			
		}
		System.out.println(sb.toString());
		br.close();

	}

}
