package algo202209;

import java.io.*;
import java.util.*;

public class Main_bj_1600_말이되고픈원숭이 {
    static int[] horsei = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] horesj = {1, 2, 2, 1, -1, -2, -2, -1};
    static int[] di = {-1, 0, 1, 0};
    static int[] dj = {0, 1, 0, -1};

    static class monkey implements Comparable<monkey> {
        int ci;
        int cj;
        int ck;
        int step;

        public monkey(int ci, int cj, int ck, int step) {
            this.ci = ci;
            this.cj = cj;
            this.ck = ck;
            this.step = step;
        }

        @Override
        public int compareTo(monkey o) {
            int r = this.step - o.step;
            return r;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int W = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int[][] map = new int[H][W];
        boolean[][][] steps = new boolean[H][W][31];

        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < W; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

            }
        }


        int time = K;

        int ti = H - 1;
        int tj = W - 1;

        PriorityQueue<monkey> que = new PriorityQueue<>();
        que.add(new monkey(0, 0, K, 0));

//        for (int[] a : map) System.out.println(Arrays.toString(a));
        int result = -1;
        while (!que.isEmpty()) {
            monkey cur = que.poll();
            if (cur.ci == H - 1 && cur.cj == W - 1) {
                result = cur.step;
                break;
            }
            for (int d = 0; d < 4; d++) {
                int ni = cur.ci + di[d];
                int nj = cur.cj + dj[d];
                int step = cur.step + 1;
                if (0 <= ni && ni < H && 0 <= nj && nj < W && map[ni][nj] !=1) {
                    if (!steps[ni][nj][cur.ck]) {
                        steps[ni][nj][cur.ck]=true;
                        que.add(new monkey(ni, nj, cur.ck , step));
                    }
                }
            }
            if (cur.ck > 0) { //말처럼 움직이자
                for (int t = 0; t < 8; t++) {
                    int ni = cur.ci + horsei[t];
                    int nj = cur.cj + horesj[t];
                    int step = cur.step + 1;
                    if (0 <= ni && ni < H && 0 <= nj && nj < W && map[ni][nj] !=1) {

                        if (!steps[ni][nj][cur.ck-1]) {
                            steps[ni][nj][cur.ck-1]=true;
                            que.add(new monkey(ni, nj, cur.ck - 1, step));
                        }
                    }
                }

            }
        }
        System.out.println(result);

    }
}
