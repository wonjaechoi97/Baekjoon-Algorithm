package algo202210;

import java.io.*;
import java.util.*;
public class Main_bj_1189_컴백홈 {
    static int[] di = {-1, 0, 1, 0};
    static int[] dj = {0, 1, 0, -1};
    static int cnt;
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int R = Integer.parseInt(st.nextToken()); //i
        int C = Integer.parseInt(st.nextToken()); // j
        int K = Integer.parseInt(st.nextToken());
        cnt = 0;
        char[][] map = new char[R][C];
        for(int i=0; i < R; i++){
            map[i] = br.readLine().toCharArray();
        }
        boolean[][] visited = new boolean[R][C];

        visited[R-1][0] = true;
        dfs(R-1,0,1, 0, C-1, K, visited, R, C,map);
        System.out.println(cnt);
        br.close();

    }
    static void dfs(int i, int j ,int len , int targeti, int targetj, int targetlen, boolean[][] visited, int R, int C, char[][] map){
        if(len>targetlen)return;
        if(i==targeti && j==targetj){
            if(targetlen==len){
//                for(boolean[] a : visited) System.out.println(Arrays.toString(a));
                cnt++;
            }
            //System.out.println();
            return;
        }

        for (int d = 0; d < 4; d++) {
            int ni = i + di[d];
            int nj = j + dj[d];
            if(0<=ni&&ni<R && 0<=nj&&nj<C){ //갈 수 있는지 체크
                if (!visited[ni][nj]&&map[ni][nj]=='.') { //방문 가능?
                    visited[ni][nj] = true;
                    dfs(ni,nj,len+1, targeti, targetj, targetlen, visited,R,C, map);
                    visited[ni][nj]=false;
                }

            }
        }
    }
}
