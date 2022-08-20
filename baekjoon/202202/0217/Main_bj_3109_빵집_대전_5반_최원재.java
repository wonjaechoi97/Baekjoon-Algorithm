import java.io.*;
import java.util.*;
/*
 * 무조건 위에 먼저 방문해서 계속 찾기 때문에 위에 부터 찾으면 그것이 최선이 될 것 같다? 그리디 
 * 
 */
public class Main_bj_3109_빵집_대전_5반_최원재 {
	static int R;
	static int C;
	static int[] di = {-1,0,1};
	static char[][] map;
	static boolean[][] checked;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		R = Integer.parseInt(st.nextToken());
		C= Integer.parseInt(st.nextToken());
		map = new char[R][C];
		checked = new boolean[R][C];
		for(int i=0;i<R;i++) {
			String str = br.readLine();
			for(int j=0;j<C;j++) {
				map[i][j]=str.charAt(j);
				
			}
		}
		int cnt=0;
		for(int i=0; i<R;i++) {
			if(solve(i,0))cnt++;
		}
		System.out.println(cnt);

	}
	
	static boolean solve(int I, int J ) {
		for(int i=0;i<3;i++) {
			int ni = I+di[i];
			int nj= J+1;
			if(0<=ni&&ni<R&&0<=nj&&nj<C) {
				if(!checked[ni][nj]&&map[ni][nj]=='.') {
				checked[ni][nj]=true;
				if(nj==C-1) return true;
				if(solve(ni,nj))return true;
				}
			}
				
		}
		return false;
		
	}

}
