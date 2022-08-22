import java.io.*;
import java.util.*;

public class Solution_d2_2001_파리퇴치_대전_5반_최원재 {

	public static void main(String[] args) throws Exception{
		//System.setIn(new FileInputStream("res/input_d2_2001.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int x=0; x<T;x++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N=Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int[][] arr = new int[N][N];
			
			for(int i=0;i<N;i++) {
				st=new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					arr[i][j]=Integer.parseInt(st.nextToken());
					
				}
			}
			//for(int[] i : arr)System.out.println(Arrays.toString(i));
			int max=-1;
			
			for(int i=0; i<=N-M;i++) {
				for(int j=0; j<=N-M;j++) {
					int sum = 0;
					for(int ni=0; ni<M;ni++) {
						for(int nj=0; nj<M;nj++) {
							sum+=arr[i+ni][j+nj];
						}					
				}
					if(sum>=max)max=sum;
				
			}
			
		}
			System.out.println("#"+(x+1)+" "+max);

	}
	}

}
