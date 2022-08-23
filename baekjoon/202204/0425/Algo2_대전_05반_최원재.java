import java.io.*;
import java.util.*;
public class Algo2_대전_05반_최원재 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));//입력을 읽어들이기 위한 BufferedReader
		StringBuilder sb = new StringBuilder();// 정답 문자열을 담아두기 위한 stringbuilder
		boolean[][] check = new boolean[15001][2];//확인할 수 있는 숫자 체크하기 위한 배열
		//자신과 이전 추들로 만들어 낸 값을 사용하여 또 다른 확인할 수 있는 값 만드는 것을 방지하기 위해 2차원 배열로 한다.
		//[][0]현재 사용할 수 있는지 여부, [][1]은 다음 숫자부터 사용가능한지 여부 
		int N = Integer.parseInt(br.readLine());//추의 수
		int[] num = new int[N];//추의 무게를 입력받을 배열
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int limit=0;//이전 구슬들로 만들 수 있는 최대 값 계산 범위를 한정하기 위해 사용.
		
		for(int i=0; i<N; i++) {//추 무게 입력 받기
			num[i]=Integer.parseInt(st.nextToken());
		}
		check[num[0]][1]=check[num[0]][0]=true;// 가장 첫번째 추 하나로는 자신의 무게만 확인 가능하므로 추 무게 인덱스만 true
		limit=num[0]; //limit 값 설정 
		for(int n=1; n<N; n++) { //2번째 추부터 시작
			int cur = num[n];//현재 추 입력
			check[cur][1]=true; //현재 추 무게 다음부터 사용가능 
			for(int i=1; i<=limit;i++) {
				if(check[i][0]) {// 무게 i가 이전 추를 사용하여 만들 수 있는 무게였다면
					//i와 cur를 사용하여 만들 수 있는 무게는 다음 추 부터 사용할 수 있도록 바꾸어준다.
					check[Math.abs(i-cur)][1]=true;// |i - cur| 다음 추 부터 사용가능
					check[cur+i][1]=true; //i+cur 다음 추부터 사용가능
	
				}
			}
			limit=limit+cur;//limit 갱신
			for(int i=1; i<=limit;i++) {//다음 추부터 사용가능하도록 갱신
				check[i][0]=check[i][1];
			}
		}
		
		int K =Integer.parseInt(br.readLine());//확인하고자할 구슬 수 
		st = new StringTokenizer(br.readLine()," ");
		for(int i=0; i<K;i++) {
			int n = Integer.parseInt(st.nextToken()); //확인하고자 하는 수
			if(n>15000) { //추의 무개는 500g 이하이고 추의 개수는 30개 이하이기 때문에 최대 확인할 수 있는 무게는 15000이므로
				sb.append("N ");// 확인 불가능하므로 N를 담아둔다.
				continue;
			}
			if(check[n][0])sb.append("Y ");//확인가능한 숫자면 Y를 담아두고 
			else sb.append("N "); // 확인 불가능하면 N를 담아둔다.
			
		}
		System.out.println(sb.toString());//정답 출력
		
		
		br.close();

	}

}
