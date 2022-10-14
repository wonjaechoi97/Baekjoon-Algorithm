package algo202210;

import java.io.*;
import java.util.*;
public class Main_bj_7569_토마토 {
    //상 우 하 좌 위 아래
    static int[] di = {-1, 0, 1, 0, 0, 0};
    static int[] dj = {0, 1, 0, -1, 0, 0};
    static int[] dh = {0, 0, 0, 0, 1, -1};

    static class Tomato {
        int i;
        int j;
        int h;
        int day;

        public Tomato(int i, int j, int h, int day) {
            this.i = i;
            this.j = j;
            this.h = h;
            this.day = day;
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int count = 0;

        int[][][] map = new int[N][M][H];

        Queue<Tomato> que = new ArrayDeque<>();
        for (int h = 0; h < H; h++) {
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < M; j++) {
                    int place = Integer.parseInt(st.nextToken());
                    map[i][j][h] = place;
                    if(place == 1){
                        que.offer(new Tomato(i, j, h,0));
                    }else if(place == 0 ){
                        count++;
                    }
                }
            }
        }

        boolean[][][] visited = new boolean[N][M][H];
        int result = -1;
        if(count==0) result = 0;
        label: while (!que.isEmpty()) {

            Tomato cur = que.poll();

            for(int d=0; d<6; d++){
                int ni = cur.i + di[d];
                int nj = cur.j + dj[d];
                int nh = cur.h + dh[d];
                if (0 <= ni && ni < N && 0 <= nj && nj < M && 0 <= nh && nh < H) {
                    if (map[ni][nj][nh]==0) {
                        que.offer(new Tomato(ni,nj,nh, cur.day+1));
                        map[ni][nj][nh] =1;
                        count--;
                        if(count == 0) {
                            result = cur.day + 1;
                            break label;
                        }
                    }
                }
            }


        }
        System.out.println(result);
        br.close();

    }
}
