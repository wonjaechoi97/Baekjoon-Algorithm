import java.io.*;
import java.util.*;
public class Main_bj_2292_벌집 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N =Integer.parseInt(br.readLine());
		int cnt=0;
		int x = 1;
		while(true) {
			x= x+6*cnt;
			if(x>=N)break;
			cnt++;
		}
		System.out.println(cnt+1);
	}

}

