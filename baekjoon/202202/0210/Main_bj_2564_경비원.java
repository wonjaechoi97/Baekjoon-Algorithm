import java.io.*;
import java.util.*;

public class Main_bj_2564_경비원 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int w=Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(br.readLine());
		int[][] coor = new int[N][2];
		int sum =0;
		int min = Integer.MAX_VALUE;
		for(int i = 0 ; i< N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			coor[i][0]=Integer.parseInt(st.nextToken());
			coor[i][1]=Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine(), " ");
		int point =Integer.parseInt(st.nextToken());
		int len=Integer.parseInt(st.nextToken());
	
		for(int i = 0 ; i< N ; i++) {
			if(point == 1) {
				if(coor[i][0]==point)sum+=Math.abs(len-coor[i][1]);
				else if(coor[i][0]==3)sum+=(len+coor[i][1]);
				else if(coor[i][0]==4)sum+=(w-len+coor[i][1]);
				else if(coor[i][0]==2) {
					int a = len+coor[i][1]+h;
					int b = 2*w-len-coor[i][1]+h;
					min = a<=b?a:b;
					sum+=min;
				}
			}else if(point == 2 ) {
				if(coor[i][0]==point)sum+=Math.abs(len-coor[i][1]);
				else if(coor[i][0]==3)sum+=(len+h-coor[i][1]);
				else if(coor[i][0]==4)sum+=(w-len+h-coor[i][1]);
				else if(coor[i][0]==1) {
					int a = len+coor[i][1]+h;
					int b = 2*w-len-coor[i][1]+h;
					min = a<=b?a:b;
					sum+=min;
				}
			}else if(point == 3 ) {
				if(coor[i][0]==point)sum+=Math.abs(len-coor[i][1]);
				else if(coor[i][0]==1)sum+=(len+coor[i][1]);
				else if(coor[i][0]==2)sum+=(h-len+coor[i][1]);
				else if(coor[i][0]==4) {
					int a = len+coor[i][1]+w;
					int b = 2*h-len-coor[i][1]+w;
					min = a<=b?a:b;
					sum+=min;
				}
			}else  {   
				if(coor[i][0]==point)sum+=Math.abs(len-coor[i][1]);
				else if(coor[i][0]==1)sum+=(len+w-coor[i][1]);
				else if(coor[i][0]==2)sum+=(h-len+w-coor[i][1]);
				else if(coor[i][0]==3) {
					int a = len+coor[i][1]+w;
					int b = 2*h-len-coor[i][1]+w;
					min = a<=b?a:b;
					sum+=min;
			   }
		     }
			}
		System.out.println(sum);
		}
}
		
	


