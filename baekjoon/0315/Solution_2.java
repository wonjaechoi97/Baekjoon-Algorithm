package swtest;
import java.io.*;
import java.util.*;
public class Solution_2 {
	//삼성소프트웨어 역량 테스트 문제 헌터
	static int min;
	public static void main(String[] args)  throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			int N = Integer.parseInt(br.readLine());
			min = Integer.MAX_VALUE;
			boolean[] kill =new boolean[5];
			boolean[] visit = new boolean[5]; 
			int[][][] map = new int[N][N][2];//집, 몬스터 번호
			for(int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine()," ");
				for(int j=0; j<N; j++) {
					int n = Integer.parseInt(st.nextToken());
					if(n==0) {
						continue;
					}else if(n<0) {
						visit[-n]=true;
						map[i][j][0]=-n;
					}else {
						kill[n]=true;
						map[i][j][1]=n;
					}
				}
			}
			
			solve(N, 0, 0, map, kill, visit, 0);
			sb.append("#"+t+" ").append(min).append("\n");
			
		}
		System.out.println(sb.toString());
		 br.close();
		
	}
	static void solve(int N,  int hi, int hj, int[][][]map, boolean[] kill, boolean[] visit, int cnt) {
		//죽이면 kill에 false
		//방문하면 visit에 false
		if(cnt>min)return;
		for(int i =0 ; i<N; i++ ) {
			for(int j = 0 ; j<N; j++) {
				
				// 방문 가능한 집이 있다면
				if(map[i][j][0]!=0) {
					
					if(!kill[map[i][j][0]]) { //요청 몬스터를 죽였다면?
						//System.out.println(i+" "+j+" "+"방가");
						int x = map[i][j][0];
						visit[x]=false; // 방문 처리 
						map[i][j][0]=0; // 방문 할 것 없어짐 
						
						if(checkvisit(visit)) { //모두 죽이고 방문 했다면
							if((cnt+lencheck(i, j, hi, hj))<min){
								min = cnt+lencheck(i, j, hi, hj);
								//System.out.println("도착------------------------------------------"+cnt+lencheck(i, j, hi, hj));
								
							}
							//원상 복구 
							visit[x]=true; 
							map[i][j][0]=x;
							return;
						}else {//아직 죽일 게 남았다면?
							//방문 하자
							//System.out.println(i+" "+j+" "+"방문함");
							solve(N, i, j, map, kill, visit, cnt+lencheck(i, j, hi, hj));
							
							//안할래
							//System.out.println(i+" "+j+" "+"방문안함");
							visit[x]=true; 
							map[i][j][0]=x;
						}
					}
				
				}else if(map[i][j][1]!=0) { //몬스터가 있다면 
					//죽일래
					int x = map[i][j][1];
					kill[x]=false; //죽임
					map[i][j][1]=0;//몬 사라짐
					//System.out.println(i+" "+j+" "+"죽임");
					solve(N, i, j, map, kill, visit, cnt+lencheck(i, j, hi, hj));
					
					//안죽일래
					//System.out.println(i+" "+j+" "+"안죽임");
					map[i][j][1]=x;
					kill[x]=true;
				}
			}
		}		
	}
	
	static boolean checkvisit(boolean[] visit) {
		
		//visit 이 true이면 아직 방문하지 않은 곳이 있음 
		for(int i=1; i<visit.length; i++) {
			if(visit[i]) return false;
			
		}
		//모두 방문 했다면
		return true;
	}
	
	static int lencheck(int i, int j, int hi, int hj) {
		int sum = Math.abs(i-hi)+Math.abs(j-hj);
		return sum;
	}

}
