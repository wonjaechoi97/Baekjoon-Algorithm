package p05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_bj_16953_AB2 {
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int result=1;
		while(true) {
			if(B==A) {
				System.out.println(result);
				break;
			}
			if(B<A) {
				System.out.println(-1);
				break;
			}
			if(B%10!=1&&B%2!=0) {
				System.out.println(-1);
				break;
			}
			if(B%10==1) {
				B=B/10;
			}else {
				B=B/2;
			}
			result++;
		}
		solve(A, B, 1);
		
		br.close();

	}

	static void solve(int a, int B, int cnt) {
		if (a > B)
			return;
		if (cnt >= min)
			return;
		if (a == B) {
			if (cnt < min)
				min = cnt;
			return;
		}
		solve(a * 2, B, cnt + 1);
		solve(a * 10 + 1, B, cnt + 1);
	}
}
