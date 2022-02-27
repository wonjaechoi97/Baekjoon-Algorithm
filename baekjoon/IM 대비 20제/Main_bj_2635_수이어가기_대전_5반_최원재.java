package practice0227;
import java.io.*;
import java.util.*;
public class Main_bj_2635_수이어가기_대전_5반_최원재 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int max = -1;
		ArrayList<Integer> result=new ArrayList<>();
		for(int i=N;i>=N/2;i--) {
			ArrayList<Integer> list = new ArrayList<>();
			list.add(N);
			list.add(i);
			int cnt=1;
			while(true) {
				int n = list.get(cnt-1)-list.get(cnt);
				if(n<0)break;
				list.add(n);
				cnt++;
			}
			if(cnt>max) {
				max=cnt;
				result = list;
			}
		}
		
		sb.append(max+1).append("\n");
		for(int i=0; i<result.size();i++) {
			sb.append(result.get(i)).append(" ");
		}
		System.out.println(sb.toString());
		br.close();
		
	}

}
