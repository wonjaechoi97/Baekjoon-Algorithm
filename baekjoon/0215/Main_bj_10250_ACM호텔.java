import java.io.*;
import java.util.*;

public class Main_bj_10250_ACM호텔 {

	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int floor;
		int num;
		int T = Integer.parseInt(br.readLine());
		for(int i=0;i<T;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int H=Integer.parseInt(st.nextToken());//층수
			int W=Integer.parseInt(st.nextToken());//방수
			int N=Integer.parseInt(st.nextToken());//손님
			if(N%H==0) {
				floor=H;
				num=N/H;
			}else {
				floor =N%H ;
				num=N/H+1;
				
			}
			sb.append(floor*100+num).append("\n");
		}
		
		System.out.println(sb.toString());
		br.close();

	}

}
