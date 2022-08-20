import java.io.*;
import java.util.*;
public class Main_bj_if문문제 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int H = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int time = Integer.parseInt(br.readLine());
		//보통의 경우
		int res_h = (H+(M+time)/60)%24;
		int res_m = (M+time)%60;
		//24시가 넘어가는 경우 
		System.out.println(res_h+" "+res_m);
		br.close();

	}

}
