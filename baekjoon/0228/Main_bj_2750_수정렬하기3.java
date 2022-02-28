package practice0228;
import java.io.*;
import java.util.*;
public class Main_bj_2750_수정렬하기3 {

	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[] num = new int[10_000_001];
		
		for(int i=0; i<N;i++) {
			num[Integer.parseInt(br.readLine())]++;
			
		}
			
		for(int i=1; i<10_000_001; i++) {
			for(int j=0;j<num[i];j++) {
				sb.append(i).append("\n");
			}
		}
		System.out.println(sb.toString());
		br.close();
	}

}
