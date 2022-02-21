import java.io.*;
import java.util.*;

public class Solution_d4_1238_Contact_대전_5반_최원재 {
	static int N;
	static List<Integer>[] g;
	static boolean[] v;	
	static int max ;
	public static void main(String[] args)throws Exception {
		System.setIn(new FileInputStream("res/input (11).txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for(int t=1; t<=10; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			v=new boolean[101];//vertex 숫자 1~100까지 가능 
			N = Integer.parseInt(st.nextToken());
			int start= Integer.parseInt(st.nextToken());
			//리스트 배열 사용 
			g=new List[101];
			// 초기화 
			//안하면 널 포인트 에러
			for(int i=0; i<101; i++) {
				g[i]=new ArrayList<Integer>();
			}
			
			st= new StringTokenizer(br.readLine()," ");
			
			//리스트 배열에 vertex의 인접 vertex 넣어주기 
			for(int i=0; i<N/2; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				g[from].add(to);
			}
			max = -1;
			bfs(start);//시작하는 vertex start
			sb.append("#").append(t).append(" ").append(max).append("\n");
			
			//for(List<Integer> a: g)System.out.println(a.toString());
		}
		
		
		System.out.println(sb.toString());
		br.close();

	}
	static void bfs(int i) {
		Queue<int[]> q = new LinkedList<int[]>();
		
		int cnt = 0;//몇 번째 나아 간 것인지 확인하기 위해 cnt사용
		q.offer(new int[] {i,cnt}); //들어온 시작점과 진행 스텝 0 배열로 넣어주기 
		v[i]=true;//방문 처리
		
		while(!q.isEmpty()) {
			int[] current = q.poll();//가장 처음에 넣은 것을 빼 내어서 current배열에 담기

			if(current[1]>cnt) {//빼 낸 것의 진행 스텝이 지난번 것보다 크다면 
				max = current[0]; // 결과값을 위한 max값 갱신하고
				cnt+=1; //스텝 수도 갱신
			}
			if(current[1]==cnt) {
				//만약 스텝 수도 같으면서 vertex 값은 더 크다면 max를 현재 vertex값으로 변경
				if(current[0]>max)max = current[0];
			}
			
			
			for(int j:g[current[0]]) {
				if(!v[j]) {
					//스텝 수를 하나 씩 더해
					//큐에 더해준다.
					v[j]=true;
					q.offer(new int[] {j, current[1]+1});
				}
			}
		}
	
	}
}
