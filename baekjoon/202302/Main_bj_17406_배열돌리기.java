package algo202302;

import java.io.*;
import java.util.*;
public class Main_bj_17406_배열돌리기 {
    static int[] di = {0, 1, 0, -1}; //우 하 좌 상
    static int[] dj = {1, 0, -1, 0};

    static int N;
    static int M;
    static int K;
    static int[][] orders;
    static int min ;
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken()); //회전 연산 수
        int[][] map = new int[N][M];
        min = Integer.MAX_VALUE;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0 ; j< M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
//        for(int[] a : map) System.out.println(Arrays.toString(a));

        orders = new int[K][3];

        for(int i=0; i<K; i++){
            st = new StringTokenizer(br.readLine(), " ");
            orders[i][0] = Integer.parseInt(st.nextToken());
            orders[i][1] = Integer.parseInt(st.nextToken());
            orders[i][2] = Integer.parseInt(st.nextToken());
        }

//        for(int[] a : orders) System.out.println(Arrays.toString(a));
//        rotate(map, 2);
        order(0, new boolean[K], new int[K], map);
        System.out.println(min);
        br.close();

    }

    static void order(int cur, boolean[] selected, int[] result, int[][] map){
        if(cur==K){
//            System.out.println(Arrays.toString(result));
            int[][] copy = new int[N][M];
            for(int i=0; i<N; i++){
                for (int j = 0; j < M; j++) {
                    copy[i][j] = map[i][j];
                }
            }

            /// 최종 !!!!!!!!!!!!!!!!
            for(int i=0 ; i<K ; i++){
               /* System.out.println("순서");
                System.out.println(Arrays.toString(orders[result[i]]));
                System.out.println();*/
                solve(copy, orders[result[i]]);

              /*  for (int[] a : copy) System.out.println(Arrays.toString(a));
                System.out.println();*/
            }
            for(int n = 0 ; n<N; n++){
                int sum = 0;
                for(int m = 0 ;m <M; m++){
                    sum += copy[n][m];
                }
                if(sum < min)min = sum;

            }
//            System.out.println("-----------------------------------");
            return;
        }
        for(int i = 0; i< K; i++){
            if (selected[i])continue;
            // 선택
            result[cur] = i;
            selected[i] = true;
            order(cur + 1, selected, result, map);

            //비선택
            selected[i] = false;
        }
    }

    static void solve(int[][] map, int[] order){
        //시작
        int si = order[0] - order[2]-1;
        int sj = order[1] - order[2]-1;

        // 사이즈
        int size = order[2]*2+1;

        int[][] copy = new int[size][size];
        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){
                copy[i][j] = map[si + i][sj + j];
            }
        }

        copy = rotate(copy, order[2]);
        for(int i=0 ; i<size; i++){

            for (int j=0; j<size; j++){
                map[si + i][sj + j] = copy[i][j];
            }
        }
//        for(int[] a : copy) System.out.println(Arrays.toString(a));
    }
    static int[][] rotate(int[][] map, int s){
        int i = 0;
        int j = 0;
        for(int o=s; o>0; o--){ //바깥 껍데기 부터
            int start = map[i][j];
            for(int t=0; t<o*2*4; t++) { //껍데기 한칸씩 옮기기 s가 3일 때 시작은 3(o) * 2 * 4 = 24옮겨야하고
                // 그 다음은 2*2*4 =16번
                // 마지막으로 1*2*4 = 8번 옮겨야 한다.

                int ni = i + di[t / (o * 2)]; // 우 하 상 좌
                int nj = j + dj[t / (o * 2)];
                int tmp = map[ni][nj];
                map[ni][nj] = start;
                start = tmp;
                i = ni;
                j = nj;
//               / System.out.println(i +" "+ j);


            }
            i++;
            j++;
        }
//        for(int[] a : map) System.out.println(Arrays.toString(a));
        return map;
    }

    //끼워 넣는 작업

}
