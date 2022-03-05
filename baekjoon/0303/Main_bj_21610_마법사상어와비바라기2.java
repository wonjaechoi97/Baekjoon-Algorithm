package practice0303;
import java.io.*;
import java.util.*;
public class Main_bj_21610_마법사상어와비바라기2 {
	static int[] di = {0,-1,-1,-1,0,1,1,1};
	static int[] dj = {-1,-1,0,1,1,1,0,-1};
	static class cloud{
		int i;
		int j;
		public cloud(int i, int j) {
			this.i=i;
			this.j=j;
		}
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N= Integer.parseInt(st.nextToken());//격자 칸
		int M = Integer.parseInt(st.nextToken());//이동 수
		ArrayList<cloud> clo = new ArrayList<>();
		int[][] map = new int[N][N];
		
		for(int i=0; i<N; i++) {
			st= new StringTokenizer(br.readLine()," ");
			for(int j=0; j<N; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		clo.add(new cloud(N-1, 0));
		clo.add(new cloud(N-1, 1));
		clo.add(new cloud(N-2, 0));
		clo.add(new cloud(N-2, 1));
		int size = clo.size();
		for(int t=0; t<M ; t++) {
			System.out.println(size);
			st = new StringTokenizer(br.readLine()," ");
			int d = Integer.parseInt(st.nextToken())-1;
			int s = Integer.parseInt(st.nextToken());
			//구름 이동
			for(int i=0; i<clo.size();i++) {
				for(int c=0;c<s;c++) {
					System.out.print(clo.get(i).i+" "+clo.get(i).j+" "+d+"    ");
					clo.get(i).i+=di[d];
					clo.get(i).j+=dj[d];
					if(clo.get(i).i<0)clo.get(i).i+=N;
					if(clo.get(i).j<0)clo.get(i).j+=N;
					if(clo.get(i).i>=N)clo.get(i).i-=N;
					if(clo.get(i).j>=N)clo.get(i).j-=N;
					System.out.println(clo.get(i).i+" "+clo.get(i).j);
				
					
				}
				System.out.println("------");
			}
			System.out.println();
//			System.out.println();
//			for(int i=0; i<clo.size();i++) {
//				System.out.println(clo.get(i).i+" "+clo.get(i).j);
//			}
			System.out.println();
			//구름이 있는 곳에 물의 양 1 증가
			for(int i=0; i<clo.size();i++) {
//				System.out.println("이전"+map[clo.get(i).i][clo.get(i).j]);
				map[clo.get(i).i][clo.get(i).j]++;
				//System.out.println("이후"+map[clo.get(i).i][clo.get(i).j]);
			}
			System.out.println("구름 있는 곳 1증가");
			for(int[] a : map)System.out.println(Arrays.toString(a));
			System.out.println();
			
			for(int i=0; i<clo.size();i++) {

				//물복사 버그 시전
				int ci = clo.get(i).i;
				int cj = clo.get(i).j;
				int count = 0;
				if(0<=ci+1&&ci+1<N&&0<=cj+1&cj+1<N&&map[ci+1][cj+1]>0)count++;
				if(0<=ci+1&&ci+1<N&&0<=cj-1&cj-1<N&&map[ci+1][cj-1]>0)count++;
				if(0<=ci-1&&ci-1<N&&0<=cj+1&cj+1<N&&map[ci-1][cj+1]>0)count++;
				if(0<=ci-1&&ci-1<N&&0<=cj-1&cj-1<N&&map[ci-1][cj-1]>0)count++;
				
				map[ci][cj]+=count;
				//System.out.println(clo.get(i).i+" "+clo.get(i).j+" "+count+" "+map[ci][cj]);
				
			}
			System.out.println("물복사");
			for(int[] a : map)System.out.println(Arrays.toString(a));
			System.out.println();
			
			//구름 사라짐
			//clo.clear();
			
			for(int i=0; i<N;i++) {
				la:for(int j=0; j<N; j++) {
					if(map[i][j]>=2) {
						for(int k = 0 ; k<clo.size();k++) {
							if(i==clo.get(k).i&&j==clo.get(k).j) {
								continue la;
							}
						}
						System.out.println("@");
						clo.add(new cloud(i, j));
						map[i][j]-=2;
					}
				}
			}
			for(int j=0; j<clo.size();j++) {
				System.out.println(clo.get(j).i+" "+clo.get(j).j);
			}
			System.out.println(clo.size());
			for(int i=0; i<size;i++) {
				System.out.println(i);
				clo.remove(0);
			}
			for(int j=0; j<clo.size();j++) {
				System.out.println(clo.get(j).i+" "+clo.get(j).j);
			}
			for(int[] a : map)System.out.println(Arrays.toString(a));
			System.out.println();
			
			
			size = clo.size();
			System.out.println(size);
			System.out.println();
			System.out.println("=====");
		}
		int sum=0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N;j++) {
				sum+=map[i][j];
			}
		}
		for(int[] a : map)System.out.println(Arrays.toString(a));
		System.out.println(sum);
		br.close();

	}

}
