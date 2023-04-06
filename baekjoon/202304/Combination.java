package algo202304;

import java.util.Arrays;

public class Combination {

	public static void main(String[] args) {
		int n = 5;
		int r = 3;
		
		comb(0, 1, new int[r], n, r);
		
	}
	
	static void comb(int cnt, int cur, int[] selected,int n, int r) {
		if(cur>n) {
			return;
		}
		if(cnt >= r) {
			System.out.println(Arrays.toString(selected));
			return;
		}
		
		selected[cnt] = cur;
		comb(cnt+1, cur+1, selected, n, r);
		
		comb(cnt, cur+1, selected, n, r);
	}

}
