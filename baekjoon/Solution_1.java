package swtest;
import java.io.*;
import java.util.*;
public class Solution_1 {

	public static void main(String[] args)  throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine()); //테케 수
		for(int t=1; t<=T;t++) {
			int N = Integer.parseInt(br.readLine());// 낙시 장소 수
			int[] map = new int[N+1];
			int[][] gate = new int[3][2];
			int cnt = 0;
			for(int i=0;i<3; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine()," ");
				gate[i][0]= Integer.parseInt(st.nextToken());//게이트 번호
				gate[i][1]=Integer.parseInt(st.nextToken());// 대기 인원 수
				//1 2 3
				
				
			}
			
			// 123  132 213 231 312 321 
			
			
			}
			System.out.println(Arrays.toString(map));
			System.out.println(cnt);
		}
		
		
		
		br.close();

	}
	static void solve(int[] order, int cnt) {
		
	}
	

}
