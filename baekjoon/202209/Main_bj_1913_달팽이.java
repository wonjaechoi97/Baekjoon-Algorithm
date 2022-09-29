package algo202209;

import java.io.*;
import java.util.*;

public class Main_bj_1913_달팽이 {
    static int[] di = {-1, 0, 1, 0};
    static int[] dj = {0, 1, 0, -1};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n=1;
        int len = 1;
        int d=0;
        int[][] map = new int[N][N];
        map[N/2][N/2] = 1;
        int ni = N/2;
        int nj=N/2;
        int result_i =N/2+1;
        int result_j =N/2+1;
        here: while (true) {
            for(int j=0; j<2; j++){

                for (int i = 0; i < len; i++) {

                    ni += di[d];
                    nj += dj[d];
                    n++;
                    if(ni>=N || ni<0 || nj>=N || nj<0) break here;
                    map[ni][nj] = n;
                    if(n==K){
                        result_i = ni+1;
                        result_j = nj+1;
                    }

                }
                d++;
                d%=4;

            }

            len++;

        }
        for(int i=0; i<N; i++){
            for (int j = 0; j < N; j++) {
                sb.append(map[i][j] + " ");

            }
            sb.append("\n");
        }
        sb.append(result_i + " " + result_j);
        System.out.println(sb.toString());
    }
}
