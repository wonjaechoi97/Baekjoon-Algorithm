import java.io.*;
import java.util.*;
public class Main_jo_1681_해밀턴순환회로_대전_5반_최원재 {
	
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());// 방문 장소 수
		int[][] map = new int[N][N];
		boolean[] v = new boolean[N];
		for(int i=0 ; i<N ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for(int j=0; j<N;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		//for(int[] a: map)System.out.println(Arrays.toString(a));
		dfs(map, 0, N, 0, v, 0);
		System.out.println(min);
		br.close();
	}
	static void dfs(int[][] map,int cur,  int N, int sum, boolean[] v, int cnt) {
		if(sum>min)return;
		if(cnt==N-1) {
			//System.out.println("sum : "+sum);
			
			if(map[cur][0]!=0) {
				sum+=map[cur][0];
				if(sum<min)min=sum;
			}
			return;
		}
		v[cur]=true;
		
		for(int i=1; i<N;i++) {
			if(map[cur][i]!=0&&!v[i]) {
				dfs(map, i, N, sum+map[cur][i], v,cnt+1);
				
				v[i]=false;
			}
		}
	}
}
