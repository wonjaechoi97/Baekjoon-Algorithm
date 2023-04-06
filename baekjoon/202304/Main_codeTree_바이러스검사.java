package algo202304;

import java.io.*;
import java.util.*;

public class Main_codeTree_바이러스검사 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		/**/
		int n = Integer.parseInt(br.readLine());// 식당 수
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int[] stores = new int[n]; // 식당에 있는 사람 수\
		for (int i = 0; i < n; i++) {
			stores[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine()," ");
		int manager = Integer.parseInt(st.nextToken()); //매니저가 검사할 수 있는 최대 사람 수
		int member = Integer.parseInt(st.nextToken()); //멤버가 검사할 수 있는 최대 사람 수
		long total=n;
		for(int i=0; i<n; i++) {
			int num = stores[i] - manager;
			if(num>0) {
				
				if(num%member==0) {
					total += num/member;
				}else {
					total += num/member + 1;
				}
				
			}
		}
		System.out.println(total);

	}

}
