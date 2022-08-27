import java.io.*;
import java.util.*;
public class Solution_d3_1225_암호생성기_대전_5반_최원재 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for(int x =0; x<10; x++) {
			int cnt = 1;
			
			ArrayDeque<Integer> que = new ArrayDeque<Integer>(); 
			int T = Integer.parseInt(br.readLine());
			
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for(int i=0; i<8;i++) {
				que.add(Integer.parseInt(st.nextToken()));
			}
			while((que.peek()-cnt)>0) {				
				que.add(que.poll()-cnt);	
				cnt++;
				if(cnt==6)cnt=1;
			}
			que.poll();
			que.add(0);
			sb.append("#").append(T).append(" ");
			for(int i =0; i<8; i++) {
				sb.append(que.poll()).append(" ");
			}
			sb.append("\n");
		}
		sb.setLength(sb.length()-1);
		System.out.println(sb.toString());
		br.close();
	}

}
