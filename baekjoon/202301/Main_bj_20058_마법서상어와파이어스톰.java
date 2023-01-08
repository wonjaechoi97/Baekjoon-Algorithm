package algo202301;

import java.io.*;
import java.util.*;

public class Main_bj_20058_마법서상어와파이어스톰 {
    static int[] di = {-1, 0, 1, 0};
    static int[] dj = {0, 1, 0, -1};
    public static int n;
    public static int Q;

    static int max = 0;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        int size = (int)Math.pow(2, n);
        int[][] map = new int[size][size];
        for (int i = 0; i < size; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < size; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
//        for(int[] a: map)System.out.println(Arrays.toString(a));

        st = new StringTokenizer(br.readLine(), " ");
        for (int q = 0; q < Q; q++) {
            int level = Integer.parseInt(st.nextToken());
            int len = (int)Math.pow(2, level);
            //회전
            for(int i=0; i<=size - len; i+=len){
                for (int j = 0; j <= size - len; j += len) {
                    rotate(i,j,level, map);
                }
            }
          /*  System.out.println("녹기 전******");
            for (int[] a : map) System.out.println(Arrays.toString(a));
            System.out.println();*/
            boolean[][] melt = new boolean[size][size];

            //녹이기
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    int cnt = 0;
                    for(int d=0;d<4;d++){
                        int ni = i + di[d];
                        int nj = j + dj[d];
                        if (0 <= ni && ni < size && 0 <= nj && nj < size) {
                            if(map[ni][nj]>0) cnt++;
                        }
                    }
                    if(cnt<3) melt[i][j] = true;
                }
            }

            for (int i = 0; i < size; i++) {
                for (int j = 0; j <size; j++){

                    if(melt[i][j] &&map[i][j]>0)map[i][j]--;
                }
            }

            /*System.out.println("녹은 후******");
            for (int[] a : map) System.out.println(Arrays.toString(a));
            System.out.println("=========================================");*/
        }
        int sum = 0;
        boolean[][] visited = new boolean[size][size];
        for(int i=0; i<size; i++){
            for (int j = 0; j < size; j++) {
                //얼음있는지 확인
                if(map[i][j]>0){
                    sum += map[i][j];
                    if (!visited[i][j]) {
                        findBiggest(i, j, map, visited, size);
                    }
                }

            }
        }

        System.out.println(sum);
        System.out.println(max);




    }



    static void rotate(int si, int sj, int level, int[][] map){
        int size = (int)Math.pow(2,level);
        int[][] copy = new int[size][size];
        for (int i = si; i < si + size; i++) {
            for (int j = sj; j < sj + size; j++) {
                copy[i - si][j - sj] = map[i][j];
            }
        }
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                map[j + si][sj + size - 1 - i] = copy[i][j];
            }
        }


    }
    
    static void findBiggest(int si, int sj, int[][] map, boolean[][] visited, int size){
        Queue<int[]> que = new LinkedList<>();
        visited[si][sj]=true;
        que.add(new int[]{si, sj});
        int cnt = 0;
        while(!que.isEmpty()){
            int[] cur = que.poll();
            //덩어리 크기 측정용
            cnt++;
            for(int d = 0; d<4; d++){
                int ni = cur[0] + di[d];
                int nj = cur[1] + dj[d];
                // 1. 범위 내인지 확인 2. 방문 했는지 확인, 3. 얼음 있는지 확인
                if (0 <= ni && ni < size && 0 <= nj && nj < size&&!visited[ni][nj]&&map[ni][nj]>0) {
                    //방문 처리
                    visited[ni][nj]=true;
                    //que에 담기
                    que.add(new int[]{ni, nj});
                }
            }
                    
        }
        if (cnt > max) {
            max = cnt;
        }
    }

}
