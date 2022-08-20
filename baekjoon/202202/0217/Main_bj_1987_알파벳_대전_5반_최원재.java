import java.io.*;
import java.util.*;
public class Main_bj_1987_알파벳_대전_5반_최원재 {
	static int di[]= {-1,0,1,0};
	static int dj[]= {0,1,0,-1};
	static int max = -1;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int R= Integer.parseInt(st.nextToken());
		int C= Integer.parseInt(st.nextToken());
		char[][] map = new char[R][C];
		for(int i=0;i<R;i++) {
			String str=br.readLine();
			for(int j=0; j<C; j++) {
				map[i][j]=str.charAt(j);
			}
		}
		boolean[] checked= new boolean[26];// 알파벳 지났는지 체크;
		
	
		//for(char[] a: map)System.out.println(Arrays.toString(a));
		solve(0,0,R,C,1,checked, map);
		System.out.println(max);
	}
	
	static void solve(int i, int j, int R, int C, int cnt, boolean[] checked, char[][] map) {
		if(checked[map[i][j]-'A'])return;
		checked[map[i][j]-'A']= true;
		for(int d=0; d<=3; d++) {
			if(0<=i+di[d]&&i+di[d]<R&&0<=j+dj[d]&&j+dj[d]<C) {
				solve(i+di[d],j+dj[d],R,C,cnt+1,checked, map);
			}
		}
		checked[map[i][j]-'A']= false;
		if(cnt>max)max = cnt;
	}

}
