package algo202304;

import java.io.*;
import java.util.*;

public class Main_bj_17141_연구소2 {
    static int[] di = {-1, 0, 1, 0};
    static int[] dj = {0, 1, 0, -1};
    static int N;
    static int M;

    static boolean check;//퍼뜨릴 수 있는지 체크

    static int eCnt = 0;

    static int min = Integer.MAX_VALUE;
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken()); //연구소의 크기
        M = Integer.parseInt(st.nextToken()); //바이러스 놓을 수 있는 수
        int[][] map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]==0||map[i][j]==2){
                    eCnt++;
                }
            }
        }


        combination(map, 0, 0, 0);
        if(check) {
            System.out.println(min);
        }else{
            System.out.println(-1);
        }

        br.close();

    }
    static void combination(int[][] map,int cnt, int pi, int pj) {


        if (cnt == M) {

            //BFS
            int[][] copy = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    copy[i][j] = map[i][j];
                }
            }
            bfs(copy);
            return;
        }

        if(pi==N)return;
        // 조합
        int nj = pj + 1;
        int ni = pi;
        if (nj == N) {
            nj = 0;
            ni++;
        }
        // 선택 우선 바이러스 놓을 수 있나?
        if(map[pi][pj]==2) {

            map[pi][pj]=3;//바이러스 놓기
            combination(map, cnt + 1, ni, nj);
            //선택 x
            map[pi][pj]=2;
            combination(map, cnt, ni, nj);

        }else{ // 벽이거나 빈칸 다음칸으로 넘어가자
            combination(map, cnt, ni, nj);
        }
    }

    static void bfs(int[][] map) {

        boolean[][] visited = new boolean[N][N];
        int cnt = eCnt;
        Queue<int[]> que = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 3) {
                    que.add(new int[]{i, j, 0});
                }
            }
        }

        while (!que.isEmpty()) {

            int[] cur = que.poll();
            map[cur[0]][cur[1]]=3;
            cnt--;
            if(cnt==0){
                check = true;
                if(cur[2]<min) min = cur[2];

            }
            int time = cur[2];



            for (int d = 0; d < 4; d++) {
                int ni = cur[0] + di[d];
                int nj = cur[1] + dj[d];
                if(0<=ni&&ni<N&&0<=nj&&nj<N&&!visited[ni][nj]){
                    if (map[ni][nj] == 0 || map[ni][nj] == 2) {
                        que.add(new int[]{ni, nj, time + 1});
                        visited[ni][nj]=true;

                    }
                }
            }


        }
    }

}
