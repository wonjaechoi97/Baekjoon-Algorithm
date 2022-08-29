package samsung01;
import java.io.*;
import java.util.*;
public class Solution_1 {
	static class house{
		int i;
		int j;
		int distance;
		public house(int i, int j, int distance) {
			super();
			this.i = i;
			this.j = j;
			this.distance = distance;
		}
		
	}
	static int minLength;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			int N = Integer.parseInt(br.readLine().trim());
			int[][] map = new int[31][31];
			house[] houses = new house[N];
			for(int n=0; n<N; n++) {
				StringTokenizer st = new StringTokenizer(br.readLine()," ");
				int i=Integer.parseInt(st.nextToken())+15;
				int j=Integer.parseInt(st.nextToken())+15;
				int distance = Integer.parseInt(st.nextToken());
				map[i][j] = distance;
				
				houses[n] = new house(i, j, distance);				
			}
			//충전소 하나
			//모든 자리 돌면서 체크
			minLength = Integer.MAX_VALUE;
			for(int i=0; i<=30; i++) {
				check : for(int j=0; j<=30; j++) {
					if(map[i][j]!=0)continue;
					int sum = 0;
					for(house ho : houses) {
						if(ho.i==i&&ho.j==j)continue check;
						//충전소와 집 간의 거리
						int dis = Math.abs(ho.i-i)+Math.abs(ho.j-j);
						if(dis<=ho.distance) {
							sum+=dis;
						}else {
							continue check;
						}
					}
					if(sum<minLength)minLength=sum;
				}
			}
			if(minLength == Integer.MAX_VALUE) {
			
				//충전소 둘
				for(int i=0; i<=30; i++) {
					for(int j=0; j<=30; j++) {
						if(map[i][j]!=0)continue;
						twoCharger(i, j, houses, map);
					}
				}
			}
			
			if(minLength == Integer.MAX_VALUE) minLength=-1;
			
			sb.append("#").append(t).append(" ").append(minLength).append("\n");
			
		}
		System.out.println(sb.toString());

	}
	
	static void twoCharger(int i, int j, house[] houses, int[][] map) {
		int ni = i;
		int nj = j;

		check : while(true) {

			nj++;
			if(nj==31) {

				nj=0;
				ni++;
			}
			if(ni==31) {
				break;
			}
			int sum = 0 ;
			if(map[ni][nj]!=0)continue;

			for(int k=0; k<houses.length; k++) {

				int dis1 = Math.abs(houses[k].i-i)+Math.abs(houses[k].j-j);
				int dis2 = Math.abs(houses[k].i-ni)+Math.abs(houses[k].j-nj);
				int dis = dis1<=dis2? dis1:dis2; 

				if(dis<=houses[k].distance) {

					sum+=dis;
				}else {
					continue check;
				}
			}
			
			if(sum<minLength) {
				minLength=sum;
			}
		}
	}
	
	

}
