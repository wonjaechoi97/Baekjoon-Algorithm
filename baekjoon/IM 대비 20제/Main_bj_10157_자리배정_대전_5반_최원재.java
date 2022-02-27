package practice0227;
import java.io.*;
import java.util.*;
public class Main_bj_10157_자리배정_대전_5반_최원재 {
	//우하좌상
	static int[] di= {0,1,0,-1};
	static int[] dj= {1,0,-1,0};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int I= Integer.parseInt(st.nextToken());
		int J =Integer.parseInt(st.nextToken());
		int map[][] = new int[I][J];
		int N = Integer.parseInt(br.readLine());
		int d=0;
		int i =0;
		int j=0;
		int cnt=2;
		map[0][0]=1;
		while(true){
			int ni = i+di[d];
			int nj = j+dj[d];
			if(0<=ni&&ni<I&&0<=nj&&nj<J&&map[ni][nj]==0) {
				map[ni][nj]=cnt;
				i = ni;
				j = nj;
			}else {
				d=(d+1)%4;
				ni = i+di[d];
				nj = j+dj[d];
				map[ni][nj]=cnt;
				i = ni;
				j = nj;
			}
			cnt++;
			if(cnt>I*J)break;
		}
		label:for(int x=0; x<I;x++) {
			for(int y=0; y<J; y++) {
				if(map[x][y]==N) {
					sb.append(x+1).append(" ").append(y+1);
					break label;
				}
			}
		}
		if(sb.length()==0)System.out.println(0);
		else System.out.println(sb.toString());
		
		br.close();

	}

}
