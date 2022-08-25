package p06;
import java.io.*;
import java.util.*;
public class Main_bj_3460_이진수 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0; t<T; t++) {
			
			PriorityQueue<Integer> list = new PriorityQueue<>();
			int n = Integer.parseInt(br.readLine());
			
			int a=2;
			int cnt = 0;
			while(true) {
				if(n==1) {
					list.add(0);
					break;
				}else if(n==0) {
					break;
				}
				if(a>n) {
					n%=(a/2);
					list.add(cnt);
					a=2;
					cnt=0;
				}else {
					a*=2;
					cnt++;
				}
			}
			
			int size = list.size();
			for(int i=0; i<size;i++) {
				int out = list.poll();
				System.out.print(out+" ");
			}
			System.out.println();
		}
		
		br.close();

	}

}
