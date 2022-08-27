import java.io.*;
import java.util.*;
public class Main_bj_9375 {
	
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		String[][] clothes;
		StringTokenizer st;
		for(int t =0 ; t<T;t++) {
			int N = Integer.parseInt(br.readLine());
			clothes= new String[N][2];
			int cnt = 0;
			int sum=0;
			for(int x = 0 ;x < N; x++) {
				st=new StringTokenizer(br.readLine()," ");
				clothes[x][0]=st.nextToken();
				clothes[x][1]=st.nextToken();
			}
			
			for(int i =0;i<N-1;i++) {
				cnt=0;
				for(int j = i+1; j<N; j++) {
					if(!clothes[i][1].equals(clothes[j][1])) cnt++;
				}
				sum+=cnt;
			}
			sum+=clothes.length;
			System.out.println(sum);
		}

	}

}
