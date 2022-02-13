import java.io.*;
import java.util.*;
public class Main_bj_10158_개미 {
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int W = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine()," ");
		int ni = Integer.parseInt(st.nextToken());
		int nj = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(br.readLine());		
		
		int a =(ni+t)%(2*W);
		int b= (nj+t)%(2*H);		
		ni = a>W?2*W-a:a;
		nj= b>H?2*H-b:b;

		System.out.println(ni+" "+nj);
		br.close();
	}
}
