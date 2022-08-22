import java.io.*;
import java.util.StringTokenizer;

public class Solution_d3_2805_농작물수확하기_대전_5반_최원재 {
	
	public static void main(String[] args)throws Exception {
		System.setIn(new FileInputStream("res/input_d3_2805.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int x=0; x<T;x++) {
			int N = Integer.parseInt(br.readLine());
			
			int[][] arr = new int[N][N];
			for(int i=0; i<N;i++) {
				String s = br.readLine();
				for(int j=0; j<N;j++) {
					arr[i][j]=s.charAt(j)-'0';
				}
			}
			int sum = 0;
			int cnt = 1;
			int j=N/2;
			
			for(int i =0;i<=N/2;i++) {
					for(int k=0; k<cnt;k++) {
						sum+=arr[i][j+k];		
					}
					cnt=cnt+2;
					j--;
			}
			cnt=1;
			j=N/2;
			for(int i=N-1;i>N/2;i--) {
				for(int k=0; k< cnt;k++) {
					sum+=arr[i][j+k];
				}
				cnt=cnt+2;
				j--; 
			   }
			
			System.out.println("#"+(x+1)+" "+sum);
		}	
	}

}
