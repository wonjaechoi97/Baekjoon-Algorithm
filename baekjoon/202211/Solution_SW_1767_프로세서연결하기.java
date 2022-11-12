package algoTest;

import java.io.*;
import java.util.*;

public class Solution_SW_1767_���μ��������ϱ� {
	static int minLength;
	static int maxCore;
	static int[] di = { -1, 0, 1, 0 };
	static int[] dj = { 0, 1, 0, -1 };

	static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			int[][] map = new int[N][N];
			maxCore = 0;
			minLength = Integer.MAX_VALUE;

			List<int[]> coreList = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				// 1 : �ھ�
				// 0 : ��ĭ
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					int n = Integer.parseInt(st.nextToken());
					map[i][j] = n;
					if (n == 1) {
						if (i != 0 && i != N - 1 && j != 0 && j != N - 1) {
							coreList.add(new int[] { i, j });
						} 
					}
				}
			}
			solve(coreList, map, 0, 0, 0);
			sb.append("#"+t+" "+minLength+"\n");
			

			// �ϳ��� �׾�� �������� ���� �ٽ� ���ϵǾ ���ƿ��� �� �ٸ� �������� �׾��, �� �ߴ� ��쵵 üũ
		}
		System.out.println(sb.toString());

		br.close();

	}

	static void solve(List<int[]> coreList, int[][] map, int cur, int connectCnt, int lenSum) {
		if(cur==coreList.size()) {
			if(connectCnt < maxCore)return;		
			else if(connectCnt>maxCore) {
				
				maxCore = connectCnt;
				minLength =lenSum;
			}else{
				
				if(lenSum<minLength)minLength=lenSum;
			}
			return;
		}
		int i= coreList.get(cur)[0];
		int j= coreList.get(cur)[1];

		for (int d = 0; d < 4; d++) {
			if(isPossible(map, d, i, j)) {
				int drawLen = draw(map, d, i, j);
				solve(coreList, map, cur+1, connectCnt+1, lenSum+drawLen);
				erase(map, d, i, j);
			}
		}
		solve(coreList, map, cur+1, connectCnt, lenSum);
	}

	static boolean isPossible(int[][] map, int d, int i, int j) {
		
		while (true) {
			i += di[d];
			j += dj[d];
			if (0 <= i && i < N && 0 <= j && j < N) {
				// �׸����� ��ο� ���� �ְų� ���μ����� �ִٸ� false��ȯ
				if (map[i][j] == 1 || map[i][j] == 2) {
					return false;
				}
			} else {
				break;
			}

		}
		// �ƹ� �͵� ���� ������� �Դٸ� true��ȯ
		return true;
	}

	static int draw(int[][] map, int d, int i, int j) {
		
		int line=0;;
		while(true) {
			i+=di[d];
			j+=dj[d];
			if (0 <= i && i < N && 0 <= j && j < N) {
				line++;
				map[i][j]=2;
			} else {
				return line;
			}
		}
	}
	
	static void erase(int[][] map, int d, int i, int j) {
		while(true) {
			i+=di[d];
			j+=dj[d];
			if (0 <= i && i < N && 0 <= j && j < N) {
				map[i][j]=0;
			} else {
				return;
			}
		}
	}
}
