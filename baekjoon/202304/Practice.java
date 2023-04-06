package algo202304;

import java.util.Arrays;

public class Practice {

	public static void main(String[] args) {
		int n = 5;
		int r = 3;
		permutation(new boolean[n+1], 0, new int[r], n, r);
		System.out.println("****************************************************");
		combination(new int[r], 1, 0, n, r);
		System.out.println("****************************************************");
		subset(new boolean[n], 0, n);
		
		
	}
	
	static void permutation(boolean[] visited, int cnt, int[] selected, int n, int r) {
		if(cnt>=r) {
			System.out.println(Arrays.toString(selected));
			return;
		}
		
		
		for(int i = 1; i<=n; i++) {
			if(!visited[i]) {
			visited[i] = true;
			selected[cnt] = i;
			permutation(visited, cnt+1, selected, n, r);
			visited[i] = false;
			}
		}
	}
	
	static void combination(int[] selected, int cur, int cnt, int n, int r) {
		if(cur>n) {
			return;
		}
		if(cnt>=r) {
			System.out.println(Arrays.toString(selected));
			return;
		}
		
		selected[cnt] =cur;
		combination(selected, cur+1, cnt+1, n, r);
		
		combination(selected, cur+1, cnt, n, r);
		
	}
	
	static void subset(boolean[] selected, int cur, int n) {
		if(cur>=n) {
			for(int i=0; i<n; i++) {
				if(selected[i]) {
					System.out.print(i+1+" ");
				}
			}
			System.out.println();
			return;
		}
		
		//선택
		selected[cur] =true;
		subset(selected, cur+1, n);
		selected[cur] =false;
		subset(selected, cur+1, n);
		
		//비선택
	}

}
