package practice0227;
import java.io.*;
import java.util.*;

public class Main_bj_2564_경비원_대전_5반_최원재 {

	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int W = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(br.readLine());
		int[][] input = new int[N][2];
		int[] dong = new int[2];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			
			input[i][0]=Integer.parseInt(st.nextToken());
			input[i][1]=Integer.parseInt(st.nextToken());
			
		}
		st = new StringTokenizer(br.readLine()," ");
		dong[0]=Integer.parseInt(st.nextToken());
		dong[1]=Integer.parseInt(st.nextToken());
		int sum=0;
		/*
		 * 1북
		 * 2남
		 * 3서 왼
		 * 4동 오른
		 * 
		 */
	
		if(dong[0]==1) {//북 
			
			for(int i=0; i<N;i++) {
				if(input[i][0]==1) {
					sum+=Math.abs(input[i][1]-dong[1]);
				}else if(input[i][0]==2) {
					sum+=(H+Math.min(input[i][1]+dong[1],2*W-input[i][1]-dong[1]));
				}else if(input[i][0]==3) {//왼
					sum+=(input[i][1]+dong[1]);
				}else {//오
					sum+=(W-dong[1]+input[i][1]);
				}
			}
		
		}else if(dong[0]==2) {//남
			for(int i=0; i<N;i++) {
				if(input[i][0]==1) {
		
					sum+=(H+Math.min(input[i][1]+dong[1],2*W-input[i][1]-dong[1]));
				}else if(input[i][0]==2) {
					sum+=Math.abs(input[i][1]-dong[1]);
				}else if(input[i][0]==3) {
					sum+=(dong[1]+H-input[i][1]);
				}else {
					
					sum+=(W-dong[1]+H-input[i][1]);
				}
				
			}
		}else if(dong[0]==3) {//서
			for(int i=0; i<N;i++) {
				if(input[i][0]==1) {
					sum+=(dong[1]+input[i][1]);
				}else if(input[i][0]==2) {
					sum+=(H-dong[1]+input[i][1]);
				}else if(input[i][0]==3) {
					sum+=Math.abs(dong[1]-input[i][1]);
				}else {
					sum+=(W+Math.min(input[i][1]+dong[1],2*H-input[i][1]-dong[1]));
				}
			}
		}else {
			for(int i=0; i<N;i++) {
				if(input[i][0]==1) {
					sum+=(dong[1]+W-input[i][1]);
				}else if(input[i][0]==2) {
					sum+=(H-dong[1]+W-input[i][1]);
				}else if(input[i][0]==3) {
					sum+=(W+Math.min(input[i][1]+dong[1],2*H-input[i][1]-dong[1]));
				}else {
					sum+=Math.abs(dong[1]-input[i][1]);
				}
			}
		}
		System.out.println(sum);
		
		br.close();

	}

}
