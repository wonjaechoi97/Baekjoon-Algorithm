import java.io.*;
import java.util.*;

public class Main_bj_2116_주사위쌓기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] input = new int[N][6];
		int[][] check = new int[N][5];// 제일 앞에는 위에 올라가는 부분 적기;
		int max = -1;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 6; j++) {
				input[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int x = 0; x < 6; x++) {
			int sum = 0;
			check[0][0] = input[0][x];
			if (x == 0 || x == 5) {
				check[0][1] = input[0][1];
				check[0][2] = input[0][2];
				check[0][3] = input[0][3];
				check[0][4] = input[0][4];
			} else if (x == 1 || x == 3) {
				check[0][1] = input[0][0];
				check[0][2] = input[0][2];
				check[0][3] = input[0][4];
				check[0][4] = input[0][5];
			} else {
				check[0][1] = input[0][0];
				check[0][2] = input[0][1];
				check[0][3] = input[0][3];
				check[0][4] = input[0][5];
			}
			for (int i = 1; i < N; i++) {
				int down = 0;
				for (int j = 0; j < 6; j++) {
					if (input[i][j] == check[i - 1][0]) {
						down = j;// j index임
						break;
					}
				}
				if (down == 0 || down == 5) {
					check[i][0] = down == 0 ? input[i][5] : input[i][0];
					check[i][1] = input[i][1];
					check[i][2] = input[i][2];
					check[i][3] = input[i][3];
					check[i][4] = input[i][4];
				} else if (down == 1 || down == 3) {
					check[i][0] = down == 1 ? input[i][3] : input[i][1];
					check[i][1] = input[i][0];
					check[i][2] = input[i][2];
					check[i][3] = input[i][4];
					check[i][4] = input[i][5];
				} else {
					check[i][0] = down == 2 ? input[i][4] : input[i][2];
					check[i][1] = input[i][0];
					check[i][2] = input[i][1];
					check[i][3] = input[i][3];
					check[i][4] = input[i][5];
				}
			}
			for (int i = 0; i < N; i++) {
				int ma = -1;
				for (int j = 1; j < 5; j++) {
					if (check[i][j] > ma)
						ma = check[i][j];
				}
				sum += ma;
			}
			if (sum > max)
				max = sum;
		}
		System.out.println(max);
		br.close();

	}

}
