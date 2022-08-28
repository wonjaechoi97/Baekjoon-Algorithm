package p08;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_ShuffleOMatic {
	static int N;
	static int ans;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			N = Integer.parseInt(br.readLine());
			int[] inputArray = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for(int i=0; i<N; i++) {
				inputArray[i] = Integer.parseInt(st.nextToken());
			}
			ans = 6;
			dfs(0, inputArray);
			if(ans>5) {
				sb.append("#").append(t).append(" ").append(-1).append("\n");
			}
			else sb.append("#").append(t).append(" ").append(ans).append("\n");
			
		}
		
		System.out.println(sb.toString());
		
		
		br.close();

	}
	
	static void dfs(int dep, int[] cardArray) {
		
		if(dep >= ans || dep> 5) {
			return;
		}
		
		if(checkSort(cardArray)) {
			ans = dep < ans? dep: ans;
			return;
		}
		
		int[][] divideArray = divideCard(cardArray);
		for(int i=0; i<N; i++) {
			dfs(dep+1, shuffle(divideArray[0], divideArray[1], i));
		}
	}
	
	static boolean checkSort(int[] arr) {
		boolean up = true;
		boolean down = true;
		
		for(int i=0; i<N; i++) {
			if(i+1 != arr[i]) up = false;
			if(N-i != arr[i]) down = false;
			if(!up && !down) return false;
		}
		return true;
	}
	
	static int[][] divideCard(int[] total){
		int[][] twoArray = new int[2][N/2];
		for(int i=0; i<N; i++) {
			if(i<N/2) {
				twoArray[0][i] = total[i];
			}else {
				twoArray[1][i%(N/2)] = total[i];
			}
		}
		
		return twoArray;
	}
	
	static int[] shuffle(int[] left, int[] right, int idx) {
		int[] ans = new int[N];
		int lIdx = idx;
		int rIdx = N/2;
		
		for(int i=0; i<N; i++) {
			if(lIdx - idx >= N/2) {
				ans[i]=right[rIdx - N/2];
				rIdx++;
				continue;
			}
			
			if(rIdx - N/2>= N/2) {
				ans[i] = left[lIdx - idx];
				lIdx++;
				continue;
			}
			
			if(rIdx<=lIdx) {
				ans[i] = right[rIdx - N/2];
				rIdx++;
			}else {
				ans[i] = left[lIdx - idx];
				lIdx++;
			}
		}
		return ans;
	}

}
