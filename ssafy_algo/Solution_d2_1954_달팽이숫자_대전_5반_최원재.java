import java.io.*;
import java.util.*;

public class Solution_d2_1954_달팽이숫자_대전_5반_최원재 {

	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] di= {0,1,0,-1};
		int[] dj= {1,0,-1,0};
	
		
	
		for(int tc = 0; tc < N;tc++) {
			
			int T = sc.nextInt();
			int[][] nums = new int[T][T];
			int n = 1;
			int ni=0, nj=-1;
			int direct = 0;
		for(int i=0; i<T*T;i++) {
			
			if(ni+di[direct]>=0&&ni+di[direct]<T&&nj+dj[direct]>=0&&nj+dj[direct]<T&&nums[ni+di[direct]][nj+dj[direct]]==0) {
				ni=ni+di[direct];
				nj=nj+dj[direct];
				nums[ni][nj]=n++;
			}else {
				direct++;
				if(direct == 4) direct =0;
				ni=ni+di[direct];
				nj=nj+dj[direct];
				nums[ni][nj]=n++;
			}
			
		}
		System.out.println("#"+(tc+1));
		for(int i = 0; i<T;i++) {
			for(int j=0;j<T;j++ ) {
				System.out.print(nums[i][j]+" ");
			}
			System.out.println();
		}
		}
		sc.close();

	}
	
}
