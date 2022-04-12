package p0411;
import java.io.*;
import java.util.*;
public class Main_bj_17143_낚시왕 {
	static class shark{
		int i;
		int j; //좌표 
		int s; //속력
		int d; //방향 1상 2하 3우 4좌
		int z; //사이즈
		public shark(int i, int j, int s,  int d, int z) {
			this.i = i;
			this.j = j;
			this.s = s;
			this.d = d;
			this.z = z;
		}
		
	}
	static int[] di = {0,-1,1,0,0};
	static int[] dj = {0,0,0,1,-1}; 
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken()); //상어 수 
		
		shark[][][] map = new shark[R][C][2];//미래 저장
		int cnt=0;
		for(int n=0;n<M; n++) {
			st = new StringTokenizer(br.readLine()," ");
			int i = Integer.parseInt(st.nextToken())-1;
			int j = Integer.parseInt(st.nextToken())-1;
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			map[i][j][0] = new shark(i, j, s, d, z);
		
		}
//		for(int i=0; i<R; i++) {
//			for(int j=0; j<C; j++) {
//				if(map[i][j][0]!=null) {
//				System.out.print(map[i][j][0].z+" ");
//				}else {
//					System.out.print("빈 ");
//				}
//			}
//			System.out.println();
//		}
//		System.out.println();
		for(int step=0; step<C;step++) {
			for(int i=0; i<R; i++) {
				if(map[i][step][0]!=null) {
					cnt+=map[i][step][0].z;
					//System.out.println("잡았다 "+ map[i][step][0].z);
					map[i][step][0]=null;
					break;
				}
			}
		
		
		//이동,  이동한 곳에 뭐가 있을 때 크기 비교 
			for(int i=0; i<R; i++) {
				for(int j=0; j<C; j++) {
					if(map[i][j][0]!=null) {
						shark cur = map[i][j][0];
						int ni=i;
						int nj=j;
						for(int s=0; s<cur.s; s++ ) {
							ni+=di[cur.d];
							nj+=dj[cur.d];
							if(!(0<=ni&&ni<R&&0<=nj&&nj<C)) {
								ni-=di[cur.d];
								nj-=dj[cur.d];
								if(cur.d==1) {
									cur.d=2;
								}else if(cur.d==2){
									cur.d=1;
								}else if(cur.d==3) {
									cur.d=4;
								}else {
									cur.d=3;
								}
								ni+=di[cur.d];
								nj+=dj[cur.d];
							}
						}
						
						if(map[ni][nj][1]!=null) {
							if(map[ni][nj][1].z<cur.z) {
//								cur.i=ni;
//								cur.j=nj;
								map[ni][nj][1]=cur;
							}
						}else {
//							cur.i=ni;
//							cur.j=nj;
							map[ni][nj][1]=cur;
						}
					}
				}
			}
			
			//미래->현재 
			for(int i=0; i<R; i++) {
				for(int j=0; j<C; j++) {
					map[i][j][0]=map[i][j][1];
					map[i][j][1]=null;
				}
			}
//			for(int i=0; i<R; i++) {
//				for(int j=0; j<C; j++) {
//					if(map[i][j][0]!=null) {
//					System.out.print(map[i][j][0].z+" ");
//					}else {
//						System.out.print("빈 ");
//					}
//				}
//				System.out.println();
//			}
//			System.out.println();
		}
		System.out.println(cnt);
		br.close();

	}

}
