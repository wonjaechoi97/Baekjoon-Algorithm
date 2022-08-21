package practice0301;
import java.io.*;
import java.util.*;
public class Main_bj_2580_스도쿠 {
	static int count = 0;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] map = new int[9][9];
		
		for(int i=0; i<9;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for(int j=0; j<9; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		solve(0,0,map, new boolean[10]);
		System.out.println(sb.toString());
	}

	/*
	 * 방문은 booelan[] v = new boolean[9+1]; 1~9 
	 */
	static void solve(int ni, int nj, int[][] map, boolean[] v) {
		if(count == 1)return;
		for(int i=ni; i<9; i++ ) {
			for(int j=0; j<9; j++) {
				if(map[i][j]!=0)continue;
				//가로 탐색
				int gi = i;
				
				for(int gj=0; gj<9;gj++) {
					v[map[gi][gj]]=true;
				}
				//세로 탐색
				int sj=j;
				for(int si=0; si<9; si++ ) {
					v[map[si][sj]] = true;
				}
				
				//사각형 탐색 
				int qi = i-i%3;
				int qj = j-j%3;
				for(int di =qi; di<qi+3;di++) {
					for(int dj = qj; dj<qj+3;dj++) {
						v[map[di][dj]]=true;
					}
				}
				boolean check =true;
				for(int c=1; c<=9; c++) {
					if(!v[c]) {
						check=false; // 만약 방문하지 않은 숫자가 하나라도 존재한다면 check = false 후 break;
						break;
					}
				}
				if(check) {
					//System.out.println("빠꾸");
					return; //만약 방문하지 않은 숫자가 하나도 없다면 잘 못 된 것이기 때문에 리턴 
				}
				for(int c =1 ; c<=9 ; c++) {
					if(v[c])continue;
					map[i][j]=c;

					solve(i,j,map,new boolean[10]);
					map[i][j]=0;
				}
				return;
			}
		}
		count++;
		if(count==1) {
			for(int i=0; i<9; i++) {
				for(int j=0; j<9;j++) {
					sb.append(map[i][j]).append(" ");
				}
				sb.append("\n");
			}
		}
		return;
		}
}
