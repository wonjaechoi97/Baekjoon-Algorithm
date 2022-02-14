import java.io.*;
import java.util.*;
public class Main_bj_2961_도영이가만든맛있는음식_대전_5반_최원재 {
	static int[][] taste;
	static boolean[] visited;//재료의 사용여부 확인용 배열
	static int N;
	static int min=Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N =Integer.parseInt(br.readLine());//재료 수;
		taste=new int[N][2];//0인덱스에 신맛, 1번 인덱스에 쓴맛을 저장한다.
		visited = new boolean[N];
		for(int i=0;i<N;i++) {
			//재료의 수 만큼 줄을 읽어 쓴맛과 신맛을 저장
			StringTokenizer st = new StringTokenizer(br.readLine()," "); //공백으로 읽은 문장의 신맛 쓴맛 구분
			taste[i][0]=Integer.parseInt(st.nextToken());//parseint를 사용하여 정수형으로
			taste[i][1]=Integer.parseInt(st.nextToken());;//0인덱스에 신맛, 1번 인덱스에 쓴맛을 저장한다.			
		}
		subset(0);
		System.out.println(min);
	}
	static void subset(int cnt) {
		if(cnt==N) {
			boolean check=false;
			for(int i=0;i<N;i++) {
				if(visited[i])check=true;
			}
			if(!check)return;
			int sin =1;
			int sseun=0;
			for(int i=0; i<N;i++) {
				if(visited[i]) {
					sin*=taste[i][0];
					sseun+=taste[i][1];
			}
			}			
			int sum=Math.abs(sin-sseun);
			if(sum<min)min=sum;
			return;
		}		
		visited[cnt]=true;
		subset(cnt+1);
		visited[cnt]=false;
		subset(cnt+1);
	}
}
