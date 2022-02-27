package practice0227;
import java.io.*;
import java.util.*;
public class Main_bj_2578_빙고_대전_5반_최원재 {

	public static void main(String[] args) throws Exception{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		
		int[][] bingo = new int[5][5];
		//int[][] call = new int[5][5];
		
		for(int i=0; i<5;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for(int j=0; j<5;j++) {
				bingo[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		int callcount=0;
		here:for(int i=0; i<5;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for(int j=0; j<5;j++) {
			
				callcount++;
				int num = Integer.parseInt(st.nextToken()); //부른 수
			
				label:for(int ni=0; ni<5;ni++) {					
					for(int nj=0; nj<5;nj++ ) {
						if(bingo[ni][nj]==num) {
							bingo[ni][nj]=0;
							break label;
						}
						
					}
				}
				
				//가로 체크 
				int full=0;
				for(int ni=0;ni<5;ni++) {
					int cnt=0;//5개 카운트 위해서
					for(int nj=0; nj<5;nj++) {
						if(bingo[ni][nj]==0)cnt++;
						else break;
					}
					if(cnt==5)full++;
				}
				//세로 체크
				for(int ni=0;ni<5;ni++) {
					int cnt=0;//5개 카운트 위해서
					for(int nj=0; nj<5;nj++) {
						if(bingo[nj][ni]==0)cnt++;
						else break;
					}
					if(cnt==5)full++;
				}
				//대각선 체크
				
				int cnt = 0;
				for(int t=0;t<5;t++) {
					if(bingo[t][t]==0)cnt++;
				}
				if(cnt==5)full++;
				
				cnt = 0;
				for(int t=0;t<5;t++) {
					if(bingo[4-t][t]==0)cnt++;
				}
				if(cnt==5)full++;
				if(full>=3)break here;
//				for(int[] a:bingo)System.out.println(Arrays.toString(a));
//				System.out.println("------------------------------------");
			}
		}
		System.out.println(callcount);
		
		
		br.close();

	}

}
