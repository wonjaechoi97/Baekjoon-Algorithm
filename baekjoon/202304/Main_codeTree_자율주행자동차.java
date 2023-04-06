package algo202304;

import java.io.*;
import java.util.*;

public class Main_codeTree_자율주행자동차 {

	static int[] di = { -1, 0, 1, 0 }; // 북 동 남 사
	static int[] dj = { 0, 1, 0, -1 };

	static class Car {
		int dir;
		int i;
		int j;

		public Car(int dir, int i, int j) {
			this.dir = dir;
			this.i = i;
			this.j = j;
		}

	}
	
	
	static int n;
	static int m;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine(), " ");
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		Car myCar = new Car(d, x, y);
		
		int[][] map = new int[n][m];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0; j<m;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		
		boolean[][] visited = new boolean[n][m];
		visited[myCar.i][myCar.j] = true;


		while (true) {
			boolean leftTry = false;
			for (int dc = 0; dc < 4; dc++) {
				if (checkLeft(myCar, visited, map)) {
					leftTry = true;
					break;
				}

			}
			if (!leftTry) { // 4번의 시도가 성공하지 않았다면
				// 후진

				// 후진 실패
				if (!back(myCar, map)) {
					break;
				}

				// 후진 성공하면 후진 된 상태로 끝
			}



		}
		
		int cnt = 0;

//		for(boolean[] b : visited)System.out.println(Arrays.toString(b));
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(visited[i][j]) cnt++;
			}
		}
		
		System.out.println(cnt);
		
		br.close();

	}

	static boolean checkLeft(Car car, boolean[][] visited,int[][] map) {
		int ni = 0;
		int nj = 0;
		if(car.dir == 0) {
			ni = car.i + di[3];
			nj = car.j + dj[3];
			car.dir = 3;
		}else if(car.dir== 1) {
			ni = car.i + di[0];
		    nj = car.j + dj[0];
			car.dir = 0;
		}else if(car.dir == 2 ) {
			ni = car.i + di[1];
			nj = car.j + dj[1];
			car.dir = 1;
		}else {
			ni = car.i + di[2];
			nj = car.j + dj[2];
			car.dir = 2;
		}
		
		if(0<=ni&&ni<n&&0<=nj&&nj<m && !visited[ni][nj]) {
			if(map[ni][nj]==0) {
				//이동
				car.i = ni;
				car.j = nj;
				
				//방문처리
				visited[ni][nj] = true;
				return true;
			}
			
		}
		
		//못가도 일단 방향은 변경 해야 함
		return false;
	}

	static boolean back(Car car, int[][] map) {
		int ni = 0;
		int nj = 0;
		if(car.dir == 0) {
			ni = car.i + di[2];
			nj = car.j + dj[2];
		}else if(car.dir== 1) {
			ni = car.i + di[3];
		    nj = car.j + dj[3];
		}else if(car.dir == 2 ) {
			ni = car.i + di[0];
			nj = car.j + dj[0];
		}else {
			ni = car.i + di[1];
			nj = car.j + dj[1];
		}
		if(0<=ni&&ni<n&&0<=nj&&nj<m&&map[ni][nj]==0) {
			car.i = ni;
			car.j = nj;
			return true;
		}
		return false;
	}

}
