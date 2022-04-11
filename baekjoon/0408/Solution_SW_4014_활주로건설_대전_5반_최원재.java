package p0408;
import java.io.*;
import java.util.*;
public class Solution_SW_4014_활주로건설_대전_5반_최원재 {

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/sample_input (11).txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1;t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int N = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			
			int[][] map = new int[N][N];
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine()," ");
				for(int j=0; j<N; j++) {
					map[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			boolean[] rowcheck= new boolean[N];
			boolean[] columncheck = new boolean[N];
			//가로 탐색 
			label:for(int i=0; i<N; i++) {
				boolean[] landcheck = new boolean[N];
				for(int j=1; j<N; j++) {
					if(map[i][j-1]<map[i][j]) {
						//오른쪽이 크다 
						int ni = i;
						int nj = j;
						//좌측 탐색 
						for(int dx = 0; dx<x;dx++) {
							nj-=1;
							if(0<=nj&& nj<N&&map[ni][nj]==map[i][j]-1&&!landcheck[nj]) { //격자 내, 높은 곳 보다 1 작다, 아직 사용하지 않는 곳 
								landcheck[nj]=true;
							}else {
								rowcheck[i]=false;
								continue label;
							}
						}
						//우측탐색
					}else if(map[i][j-1]>map[i][j]) {
						int ni=i;
						int nj=j;
						for(int dx=0; dx<x;dx++) {
							if(0<=nj&& nj<N&&map[ni][nj]==map[i][j-1]-1&&!landcheck[nj]) {
								landcheck[nj]=true;
							}else {
								rowcheck[i]=false;
								continue label;
							}
							nj+=1;
						}
					}
				}
				rowcheck[i]=true;
			}
			
			//세로 탐색
			label:for(int j=0; j<N; j++) {
				boolean[] landcheck = new boolean[N];
				for(int i=1; i<N; i++) {
					if(map[i-1][j]<map[i][j]) {
						//아래가 크다 
						int ni = i;
						int nj = j;
						//위 탐색 
						for(int dx = 0; dx<x;dx++) {
							ni-=1;
							if(0<=ni&& ni<N&&map[ni][nj]==map[i][j]-1&&!landcheck[ni]) { //격자 내, 높은 곳 보다 1 작다, 아직 사용하지 않는 곳 
								landcheck[ni]=true;
							}else {
								columncheck[j]=false;
								continue label;
							}
						}
						//위 탐색 
					}else if(map[i-1][j]>map[i][j]) {
						int ni=i;
						int nj=j;
						for(int dx=0; dx<x;dx++) {
							if(0<=ni&& ni<N&&map[ni][nj]==map[i-1][j]-1&&!landcheck[ni]) {
								landcheck[ni]=true;
							}else {
								columncheck[j]=false;
								continue label;
							}
							ni+=1;
						}
					}
				}
				columncheck[j]=true;
			}
			int cnt=0;
			for(int i=0; i<N; i++) {
				if(columncheck[i]) {
					cnt++;
					//System.out.println("가 : "+i);
				}
				
				if(rowcheck[i]) {
					cnt++;
					//System.out.println("세 : "+i);
				}
			}
			sb.append("#").append(t).append(" ").append(cnt).append("\n");
		}		
		System.out.println(sb.toString());		
		br.close();
	}
}
