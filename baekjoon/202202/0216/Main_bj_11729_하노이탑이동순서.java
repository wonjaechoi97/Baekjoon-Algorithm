import java.io.*;
import java.util.*;
public class Main_bj_11729_하노이탑이동순서 {
	static int cnt;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		StringBuilder sb2 = new StringBuilder();
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int N= Integer.parseInt(br.readLine());
		cnt=0;
		hannoi(N,1,2,3);
		sb2.append(cnt).append("\n").append(sb.toString());
		System.out.println(sb2.toString());
		br.close();
	}
	public static void hannoi(int n,int start, int mid, int end) {
		if(n==1) {
			sb.append(start+" "+end).append("\n");
			cnt++;
			return;
		}
		
		hannoi(n-1,start,end,mid);
		hannoi(1,start,mid,end);
		hannoi(n-1,mid,start,end);
		
	}

}
