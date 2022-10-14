package algo202210;

import java.io.*;
import java.util.*;
public class Main_bj_10830_행렬제곱 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] matrix = new int[N][N];
        int[][] result = new int[N][N];
        int[][] tmp = new int[N][N];
        for (int i = 0; i < N; i++) {
            st= new StringTokenizer(br.readLine()," ");
            for(int j=0; j<N; j++){
                int num = Integer.parseInt(st.nextToken());
                matrix[i][j] = num;
                result[i][j] = num;
                tmp[i][j] = num;
            }
        }

        for(int m=0; m<M;m++){ //M번 곱하기

            for(int i =0; i<N; i++){
                //한 행 순회
                for(int j=0; j<N; j++){
                    //열 고정
                    for(int k=0; k<N; k++){

                        tmp[i][j] += result[i][k]*matrix[k][j];
                    }
                    tmp[i][j]%=1000;
                }
            }

            for (int i = 0; i < N; i++) {
                for(int j=0; j<N; j++){
                    result[i][j] = tmp[i][j];
                }
            }
        }

        for(int[] a: result) System.out.println(Arrays.toString(a));
        br.close();

    }
}
