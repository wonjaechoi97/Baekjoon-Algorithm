import java.io.*;
import java.util.*;
public class Main_bj_2635_수이어가기 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int max = -1;
		int max_idx = -1;
		for(int i=N/2;i<=N;i++) {
			int a=N;
			int b =i;
			int c = 0; 
			int cnt=2;
			while(true) {
				c=a-b;
				if(c<0)break;
				a=b;
				b=c;
				cnt++;
				//System.out.println(c);
			}
			if(cnt>max) {
				max=cnt;
				max_idx = i;
			}			
		}
		int x=N;
		int y =max_idx;
		int z = 0; 
		sb.append(max).append("\n").append(x).append(" ").append(max_idx).append(" ");
		while(true) {
			z=x-y;			
			if(z<0)break;
			sb.append(z).append(" ");
			x=y;
			y=z;
		}
		System.out.println(sb.toString());
		br.close();
	}

}
