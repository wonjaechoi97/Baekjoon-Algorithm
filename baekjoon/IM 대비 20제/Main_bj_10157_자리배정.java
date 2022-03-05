import java.io.*;
import java.util.*;
public class Main_bj_10157_자리배정 {
	static final int[] di= {0,1,0,-1};
	static final int[] dj= {1,0,-1,0};
	public static void main(String[] args) throws Exception {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int C = Integer.parseInt(st.nextToken());//가로 j
		int R = Integer.parseInt(st.nextToken());// 세로 j
		int last = Integer.parseInt(br.readLine());
		int[][] map = new int[C][R];
		int ni=0, nj =0;
		int d =0;
		int cnt = 1;
		map[0][0]=1;
		while(true) {
			if(last>C*R) {
				cnt = 0;
				break;
			}
			if(cnt==last)break;
			ni+=di[d];
			nj+=dj[d];
			if(0<=ni&&ni<C&&0<=nj&&nj<R&&map[ni][nj]==0) {
				cnt++;
				map[ni][nj]=cnt;
			}else {
				ni-=di[d];
				nj-=dj[d];
				d=(d+1)%4;
			}
		}
		if(cnt==0)System.out.println(0);
		else System.out.println(ni+1+" "+(nj+1));
		br.close();

	}
}
