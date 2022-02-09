import java.io.*;
import java.util.*;
public class Solution_d3_3499_퍼펙트셔플_대전_5반_최원재 {
/*
 * 입력받은 배열을 두 부분으로 나누어서 번갈아 넣어준다.
 * 짝수 일때는 N/2-1인덱스를 기준으로 나뉘고
 * 홀수 일때는 N/2인덱스를 기준으로 나눈다.
 * 1 2 3 | 4 5 6  6/2 - 1 =2
 * 1 2 3 | 4 5    5/2 = 2
 * 
 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 1 ; i <= T; i++) {
			int N = Integer.parseInt(br.readLine());
			String[] input = new String[N];
			StringTokenizer st  = new StringTokenizer(br.readLine(), " ");
			for(int t = 0 ; t< N; t++) {
				input[t]=st.nextToken();
			}
			//앞 뒤 구분하는 곳 
			int front = N%2==0?N/2-1:N/2;
			sb.append("#").append(i).append(" ");
			for(int x = 0; x<=front; x++) {
				sb.append(input[x]).append(" ");
				if(front+1+x==N)break;
				sb.append(input[front+1+x]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
		br.close();
	}
}
