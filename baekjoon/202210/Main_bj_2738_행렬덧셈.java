package algo202210;

import java.io.*;
import java.util.*;
public class Main_bj_2738_행렬덧셈 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] A = new int[N][M];
        int[][] B = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<M; j++){
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<M; j++){
                B[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {

            for(int j=0; j<M; j++){
                sb.append(A[i][j] + B[i][j]).append(" ");
            }
            sb.append("\n");
        }


        System.out.println(sb.toString());
        br.close();
    }
}
