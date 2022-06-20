package algo0518;
import java.io.*;
import java.util.*;
public class Main_bj_2501_약수구하기 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int cnt=0;
		boolean check = false;
		for(int i=1; i<=n; i++) {
			if(n%i==0) {
				cnt++;
				if(cnt==k) {
					System.out.println(i);
					check=true;
					break;
				}
			}
		}
		
		if(!check) {
			System.out.println(0);
		}
		
		
		br.close();

	}

}
