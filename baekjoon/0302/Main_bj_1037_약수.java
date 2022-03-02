package practice0302;
import java.io.*;
import java.util.*;
public class Main_bj_1037_약수 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
			
			long[] num = new long[N];
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for(int i=0; i<N;i++) {
				num[i]=  (long)Integer.parseInt(st.nextToken());
			}
			Arrays.sort(num);
		
			System.out.println(num[0]*num[N-1]);

		
		
		br.close();

	}

}
