package algoTest;

import java.io.*;
import java.util.*;

public class Main_bj_16236_아기상어2 {
	static class Fish {
		int i;
		int j;
		int size;
		int eatCnt;

		public Fish(int i, int j, int size, int eatCnt) {
			this.i = i;
			this.j = j;
			this.size = size;
			this.eatCnt = eatCnt;
		}
	}

	static class Spot implements Comparable<Spot> {
		int i;
		int j;
		int len;

		public Spot(int i, int j, int len) {
			this.i = i;
			this.j = j;
			this.len = len;
		}

		@Override
		public int compareTo(Spot o) {
			int r = this.len - o.len;
			if (r == 0) {
				r = this.i - o.i;
			}
			if (r == 0) {
				r = this.j - o.j;
			}
			return r;
		}
	}

	static int[] di = { -1, 0, 1, 0 };
	static int[] dj = { 0, 1, 0, -1 };
	static int fishCount;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		Fish shark = null;
		fishCount = 0;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				int n = Integer.parseInt(st.nextToken());
				if (n == 9) {
					shark = new Fish(i, j, 2, 0);
					map[i][j] = 0;
				} else if (0 < n && n < 9) {
					fishCount++;
					map[i][j] = n;
				} else {
					map[i][j] = 0;
				}

			}
		}
		int time = 0;
		// bfs
		while (fishCount != 0) {
			int timeCheck = bfs(shark, map, N);
			if (timeCheck == -1)
				break;
			time += timeCheck;
		}

		System.out.println(time);

		br.close();

	}

	static int bfs(Fish shark, int[][] map, int N) {
		PriorityQueue<Spot> que = new PriorityQueue<>();
		boolean[][] visited = new boolean[N][N];
		que.add(new Spot(shark.i, shark.j, 0));

		while (!que.isEmpty()) {
			Spot cur = que.poll();
			visited[cur.i][cur.j] = true;
//			System.out.println(cur.i + " " + cur.j + " " + map[cur.i][cur.j]);
			if (0 < map[cur.i][cur.j] && map[cur.i][cur.j] < shark.size) {

				// 상어 이동
				shark.i = cur.i;
				shark.j = cur.j;
//				System.out.println("발견");
//				System.out.println(cur.len);
				// 먹은 수 증가
				shark.eatCnt++;
				// 사이즈 증가
				if (shark.eatCnt == shark.size) {

					shark.eatCnt = 0;
					shark.size++;
				}
				// 물고기 먹기
				map[cur.i][cur.j] = 0;
				fishCount--;
				return cur.len;

			}
			for (int d = 0; d <4; d++) {
				int ni = cur.i + di[d];
				int nj = cur.j + dj[d];
				if (0 <= ni && ni < N && 0 <= nj && nj < N && map[ni][nj] <= shark.size) {
					if (!visited[ni][nj])
						que.add(new Spot(ni, nj, cur.len + 1));
				}
			}

		}
		return -1;

	}

}
