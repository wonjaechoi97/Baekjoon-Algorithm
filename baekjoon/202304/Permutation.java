package algo202304;

import java.util.Arrays;

public class Permutation {

	public static void main(String[] args) {
		int n = 4;
		permu(0, new boolean[n+1], new int[n], n, n);
	}
	
	static void permu(int cnt, boolean[] visited, int[] num, int n, int r) {
		if(cnt>=n) {
			System.out.println(Arrays.toString(num));
			return;
		}
		
		
		for(int i=1; i<=n; i++) {
			if(!visited[i]) {
				num[cnt] = i;
				visited[i] = true;
				permu(cnt+1,visited, num, n, r);
				visited[i] = false;
			}
		}
	}

}
