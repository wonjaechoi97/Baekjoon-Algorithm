package practice0226;
import java.io.*;
import java.util.*;
public class Main_bj_2477_참외밭_대전_5반_최원재 {
 /*
  * 1 동
  * 2 서
  * 3 남
  * 4 북 
  */
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int max_w=0;
		int max_h=0;
		int K = Integer.parseInt(br.readLine());
		int[][] input = new int[6][2];
		for(int i=0; i<6;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int dir = Integer.parseInt(st.nextToken());
			int len = Integer.parseInt(st.nextToken());
			input[i][0]=dir;
			input[i][1]=len;
			if(dir==1 || dir==2) {
				if(len>max_w)max_w=len;
			}else {
				if(len>max_h)max_h=len;
			}
					
		}
		//System.out.println(1);
		int total = max_h*max_w;
		for(int i=0; i<6;i++) {
			if(input[i][0]==1) {
				if(input[(i+2)%6][0]==input[i][0]) {
					if(input[(i+1)%6][0]==3) {
						total-=input[i][1]*input[(i+1)%6][1];
					}else {
						total-=input[(i+2)%6][1]*input[(i+1)%6][1];
					}
					break;
				}
			}else if(input[i][0]==2) {
				if(input[(i+2)%6][0]==input[i][0]) {
					if(input[(i+1)%6][0]==3) {
						total-=input[(i+2)%6][1]*input[(i+1)%6][1];
					}else {
						total-=input[i][1]*input[(i+1)%6][1];
					}
					break;
				}
			}
		}
		System.out.println(total*K);
		br.close();

	}

}
