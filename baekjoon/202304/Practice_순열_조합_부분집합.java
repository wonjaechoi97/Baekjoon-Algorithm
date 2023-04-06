package algo202304;

import java.util.Arrays;

public class Practice_순열_조합_부분집합 {

	public static void main(String[] args) {
		int n = 4;
		int r = 3;
		

		permu(0, new boolean[n + 1], new int[n], n, n);
		System.out.println("************************");
		comb(0, 1, new int[r], n, r);
		System.out.println("************************");
		subset(n, new boolean[n], 0);
	
	}

	static void permu(int cnt, boolean[] visited, int[] num, int n, int r) {
		if (cnt >= n) {
			System.out.println(Arrays.toString(num));
			return;
		}

		for (int i = 1; i <= n; i++) {
			if (!visited[i]) {
				num[cnt] = i;
				visited[i] = true;
				permu(cnt + 1, visited, num, n, r);
				visited[i] = false;
			}
		}
	}

	static void comb(int cnt, int cur, int[] selected, int n, int r) {
		if (cur > n) {
			return;
		}
		if (cnt >= r) {
			System.out.println(Arrays.toString(selected));
			return;
		}

		selected[cnt] = cur;
		comb(cnt + 1, cur + 1, selected, n, r);

		comb(cnt, cur + 1, selected, n, r);
	}

	static void subset(int n, boolean[] set, int cnt) {

		if (cnt >= n) {
			for (int i = 0; i < n; i++) {
				if (set[i]) {
					System.out.print(i + 1 + " ");
				}
			}
			System.out.println();
			return;
		}

		set[cnt] = true;
		subset(n, set, cnt + 1);
		set[cnt] = false;
		subset(n, set, cnt + 1);

	}

}
