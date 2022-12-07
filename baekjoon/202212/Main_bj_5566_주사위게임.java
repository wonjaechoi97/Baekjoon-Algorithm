package algo202212;

import java.io.*;
import java.util.*;

public class Main_bj_5566_주사위게임 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] board = new int[N];
        for(int i=0; i<N; i++){
            board[i] = Integer.parseInt(br.readLine());

        }
        int cur =0 ; //현재 위치
        int result = 0;
        for(int m = 0; m<M; m++){
//            System.out.println(m+" : "+cur);
            int move = Integer.parseInt(br.readLine());
            cur+=move;
            if(cur>=N-1){
                result = m+1;
                break;
            }

            cur += board[cur];
            if(cur>=N-1){
                result = m+1;
                break;
            }

        }
        System.out.println(result);
        br.close();

    }
}
