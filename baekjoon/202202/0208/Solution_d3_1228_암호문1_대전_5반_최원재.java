import java.io.*;
import java.util.*;
/*
 * 1. 링크드 리스트 사용해서 삽입
 * 2. 입력 받은 후
 * 3. 위치에 token으로 자른 것을 하나씩 삽입하자 
 */
public class Solution_d3_1228_암호문1_대전_5반_최원재 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb =new StringBuilder();
		LinkedList<Integer> list = new LinkedList<>();
		for(int x = 1 ; x<=10;x++) {
			int len = Integer.parseInt(br.readLine());
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			for(int i = 0 ; i< len ; i++) {
				list.add(Integer.parseInt(st.nextToken()));
			}
			//System.out.println(list.toString());
			int N = Integer.parseInt(br.readLine());
			
			st=new StringTokenizer(br.readLine(), " ");
			for(int i = 0 ; i<N; i++) {
				
				st.nextToken();
				int loc = Integer.parseInt(st.nextToken());
				int nums = Integer.parseInt(st.nextToken());
				for(int t=loc;t<loc+nums;t++) {
					list.add(t,Integer.parseInt(st.nextToken()));
				}
				
				
			}
			sb.append("#").append(x).append(" ");
			for(int i=0; i<10; i++) {
				sb.append(list.get(i)).append(" ");
				
			}
			sb.append("\n");
			list.clear();
		}
		sb.setLength(sb.length()-1);
		System.out.println(sb.toString());
		br.close();

	}

}
