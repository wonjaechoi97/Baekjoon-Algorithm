package practice0226;
import java.io.*;
import java.util.*;
public class Main_bj_2116_주사위쌓기_대전_5반_최원재 {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] input = new int[N][6];
		for(int i=0; i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for(int j=0; j<6;j++) {
				input[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		int max = 0;
		for(int i=0; i<6; i++) {
			int sum = 0;
			int under;
			int top;
			if(i==0) {
				under=input[0][0];
				top = input[0][5];
			}else if(i==5) {
				under=input[0][5];
				top = input[0][0];
			}else if(i==1) {
				under=input[0][1];
				top = input[0][3];
			}else if(i==3) {
				under=input[0][3];
				top = input[0][1];
			}else if(i==2) {
				under=input[0][2];
				top = input[0][4];
			}
			else  {
				under=input[0][4];
				top = input[0][2];
			}
			for(int j=0; j<6;j++) {
				//System.out.println(input[0][j]);
				//System.out.println(under+" "+top);
				if(input[0][j]!=under&&input[0][j]!=top&&sum<input[0][j]) {
					sum = input[0][j];
					//System.out.println(j);
				}
			}
			//System.out.println(sum);
			
			for(int j=1; j<N; j++) {
				int under_idx = 0;
				int ma = 0; //옆면 중 최대 값 고르기;
				int top_idx=0;
				for(int k=0; k<6; k++) {
					if(input[j][k]==top) {
						under = top;
						under_idx=k;
					}
				}
				if(under_idx==0) {				
					top = input[j][5];
				}else if(under_idx==5) {					
					top = input[j][0];
				}else if(under_idx==1) {					
					top = input[j][3];
				}else if(under_idx==3) {					
					top = input[j][1];
				}else if(under_idx==2) {
					top = input[j][4];
				}else  {
					top = input[j][2];
				}
				for(int k=0; k<6;k++) {
					if(input[j][k]!=under&&input[j][k]!=top&&ma<input[j][k]) {
						ma = input[j][k];
					}
				}
				sum+=ma;
				//System.out.println(sum);
				
			}
			//System.out.println("----------------");
			if(sum>max)max=sum;	
		}
		
		System.out.println(max);
		br.close();

	}

}
