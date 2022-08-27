import java.io.*;
import java.util.*;
public class Solution_d4_1210_Ladder1_대전_5반_최원재 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_Ladder1.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int[] di = {0,0,-1};
		int[] dj = {-1,1,0};
		for(int t = 0 ; t<10;t++) {
			int[][] rad = new int[100][100]; // 100 100
			int T = Integer.parseInt(br.readLine());
			for(int a =0; a<100;a++) { // 100
				st = new StringTokenizer(br.readLine(), " ");
				for(int b = 0; b<100; b++) { // 100
					rad[a][b]=Integer.parseInt(st.nextToken());
				}
			}
			int ni=-1, nj=-1;
			for(int start=0; start<100; start++) { // 100
				if(rad[99][start]==2) { //99
					ni = 99; //99
					nj = start;
					int direct = -1;
					while(true) {
						for(int i=0; i<2;i++) {
							if(nj+dj[i]>=0&&nj+dj[i]<=99&&rad[ni+di[i]][nj+dj[i]]==1) { // <=99
								direct = i;
								while(true){
									nj+=dj[direct];					
									if(nj<0||nj>99||rad[ni][nj]!=1) {//99
										nj-=dj[direct];
										break;
									}
								}
								break;
							}
						}
						ni+=di[2];
						nj+=dj[2];
						if(ni==0)break;
					}
				}
			}
			sb.append("#").append(T).append(" ").append(nj).append("\n");
		}
		sb.setLength(sb.length()-1);
		System.out.println(sb.toString());
		br.close();
	}

}
