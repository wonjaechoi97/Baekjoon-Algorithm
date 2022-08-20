package practice0228;
import java.io.*;
import java.util.*;
public class Main_bj_2750_수정렬하기2 {

	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> num = new PriorityQueue<>();
		
		for(int i=0; i<N;i++) {
			num.add(Integer.parseInt(br.readLine()));
			
		}
			
		for(int i=0; i<N; i++) {
			sb.append(num.poll()).append("\n");
		}
		System.out.println(sb.toString());
		br.close();
	}

}
