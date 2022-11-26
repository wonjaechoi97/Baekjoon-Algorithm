package algo202211;
import java.io.*;
import java.util.*;

public class Main_bj_1012_유기농배추 {
    static int[] di = {-1, 0, 1, 0};
    static int[] dj = {0, 1, 0, -1};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            int[][] map = new int[N][M];
            boolean[][] visited = new boolean[N][M];
            int[][] list = new int[K][2];
            for(int k=0; k<K; k++){
                st = new StringTokenizer(br.readLine(), " ");
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                map[b][a] = 1;
                list[k] = new int[] {b, a};
            }
            int cnt = 0 ;
            for(int k =0 ; k<K; k++){
                int[] now = list[k];
                if(!visited[now[0]][now[1]]) {
                    Queue<int[]> que = new ArrayDeque<>();
                    que.add(new int[]{now[0], now[1]});
                    visited[now[0]][now[1]] = true;
                    while (!que.isEmpty()) {
                        int[] cur = que.poll();
                        for (int d = 0; d < 4; d++) {
                            int ni = cur[0] + di[d];
                            int nj = cur[1] + dj[d];
                            if (0 <= ni && ni < N && 0 <= nj && nj < M && map[ni][nj] == 1) {
                                if (!visited[ni][nj]) {
                                    que.offer(new int[]{ni, nj});
                                    visited[ni][nj] = true;

                                }
                            }
                        }
                    }

                    cnt++;
                }

            }
            sb.append(cnt).append("\n");

        }

        System.out.println(sb.toString());
        br.close();

    }
}
