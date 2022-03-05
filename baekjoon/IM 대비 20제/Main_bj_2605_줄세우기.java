import java.io.*;
import java.util.*;
public class Main_bj_2605_줄세우기 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N =Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		List<Integer> list = new LinkedList<>();
		for(int i=1; i<=N;i++) {
			int input = Integer.parseInt(st.nextToken());
			list.add(i-1-input,i);
		}
		for(int i =0; i<N;i++) {
			sb.append(list.get(i)).append(" ");
		}
		System.out.println(sb.toString());
	}

}
