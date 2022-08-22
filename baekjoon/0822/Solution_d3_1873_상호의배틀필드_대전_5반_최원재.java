import java.io.*;
import java.util.*;

public class Solution_d3_1873_상호의배틀필드_대전_5반_최원재 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d3_1873.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int H = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			char[][] map = new char[H][W];

			for (int i = 0; i < H; i++) {
				String s = br.readLine();
				for (int j = 0; j < W; j++) {
					map[i][j] = s.charAt(j);
				}
			}

			int order = Integer.parseInt(br.readLine());
			String commander = br.readLine();
			for (int i = 0; i < order; i++) {
				map = movement(commander.charAt(i), map);
			}
			sb.append("#").append(t+1).append(" ");
			for (int i = 0; i < H; i++) {

				for (int j = 0; j < W; j++) {
					sb.append(map[i][j]);
				}
				sb.append("\n");
			}
			
		}
		sb.setLength(sb.length()-1);
		System.out.println(sb.toString());
		br.close();

	}

	public static char[][] movement(char com, char[][] map) {
		int ni = -1;
		int nj = -1;
		for (int y = 0; y < map.length; y++) {
			for (int x = 0; x < map[0].length; x++) {
				if (map[y][x] == '^' || map[y][x] == 'v' || map[y][x] == '<' || map[y][x] == '>') {
					ni = y;
					nj = x;
				}
			}
		}
		if (com == 'U') {
			map[ni][nj] = '^';
			if (ni - 1 >= 0 && map[ni - 1][nj] == '.') {
				map[ni][nj] = '.';
				map[ni - 1][nj] = '^';

			}

		} else if (com == 'D') {
			map[ni][nj] = 'v';
			if (ni + 1 < map.length && map[ni + 1][nj] == '.') {
				map[ni][nj] = '.';
				map[ni + 1][nj] = 'v';

			}

		} else if (com == 'L') {
			map[ni][nj] = '<';
			if (nj - 1 >= 0 && map[ni][nj - 1] == '.') {
				map[ni][nj] = '.';
				map[ni][nj - 1] = '<';
			}
		} else if (com == 'R') {
			map[ni][nj] = '>';
			if (nj + 1 < map[0].length && map[ni][nj + 1] == '.') {
				map[ni][nj] = '.';
				map[ni][nj + 1] = '>';
			}
			} else {
				if (map[ni][nj] == '^') {
					for (int i = ni; i >= 0; i--) {
						if(map[i][nj] == '#')break;
						if (map[i][nj] == '*') {
							map[i][nj] = '.';
							break;
						}
					}
				} else if (map[ni][nj] == 'v') {
					for (int i = ni; i < map.length; i++) {
						if(map[i][nj] == '#')break;
						if (map[i][nj] == '*') {
							map[i][nj] = '.';
							break;
						}
					}
				} else if (map[ni][nj] == '<') {
					for (int j = nj; j >= 0; j--) {
						if(map[ni][j] == '#')break;
						if (map[ni][j] == '*') {
							map[ni][j] = '.';
							break;
						}
					}

				} else {
					for (int j = nj; j < map[0].length; j++) {
						if(map[ni][j] == '#')break;
						if (map[ni][j] == '*') {
							map[ni][j] = '.';
							break;
						}
					}

				}
			}
		
	return map;
}

}
