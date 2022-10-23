package algo202210;
import java.io.*;
import java.util.*;

public class Main_bj_2589_보물섬 {
    static int[] di = {-1, 0, 1, 0};
    static int[] dj = {0, 1, 0, -1};

    static class spot {
        int i;
        int j;
        int step;

        public spot(int i, int j, int step) {
            this.i = i;
            this.j = j;
            this.step = step;
        }

    }
    static int max;
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int W = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        max = 0;
        char[][] map = new char[W][L];

        for(int i=0; i<W; i++){
            map[i] = br.readLine().toCharArray();
        }
//        for(char[] a : map) System.out.println(Arrays.toString(a));
        for(int i=0; i<W; i++){
            for(int j=0; j<L; j++){
                if(map[i][j]=='L') {
                    int result = bfs(i, j, W, L, map);
                    if (result > max) max = result;
                }
            }
        }
        //for 문 두번 돌려서 두 위치 최단 거리 찾기 항상 실행
        System.out.println(max);
        br.close();
    }

    static int bfs(int si, int sj, int W, int L, char[][] map) {
        boolean[][] visited = new boolean[W][L];
        visited[si][sj] = true;
        Queue<spot> que = new ArrayDeque<>();
        que.add(new spot(si, sj, 0));
        int result = 0;
        while (!que.isEmpty()) {
            spot cur = que.poll();

            for (int d = 0; d < 4; d++) {
                int ni = cur.i + di[d];
                int nj = cur.j + dj[d];
                if (0 <= ni && ni < W && 0 <= nj && nj < L&&map[ni][nj]=='L') {
                    if(!visited[ni][nj]){
                        visited[ni][nj]=true;
                        que.add(new spot(ni, nj, cur.step + 1));
                        if(cur.step+1>result)result=cur.step+1;
                    }
                }
            }
        }

        return result;

    }
}
