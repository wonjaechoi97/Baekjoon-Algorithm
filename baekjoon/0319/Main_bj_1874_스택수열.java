package practice0317;
import java.io.*;
import java.util.*;
public class Main_bj_1874_스택수열 {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		//
		int curnum=0;
		int N = Integer.parseInt(br.readLine());
		Stack<Integer> sta = new Stack<>();
		
		for(int i=0; i<N; i++) {
			int n= Integer.parseInt(br.readLine());
			if(n>curnum) {
				while(curnum<n) {
					curnum++;
					sta.push(curnum);
					sb.append("+").append("\n");
				}
				sta.pop();
				
				sb.append("-").append("\n");
			}else {
				int pop = sta.pop();
				if(pop!=n) {
					sb=new StringBuilder();
					sb.append("NO");
					break;
				}else {
					sb.append("-").append("\n");
				}
			}

		}
		System.out.println(sb.toString());
		br.close();

	}

}
