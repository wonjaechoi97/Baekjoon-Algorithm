package algo202210;

import java.io.*;
import java.util.*;

public class Main_bj_17608_막대기 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] poll = new int[N];

        for(int i=0; i<N; i++){
            poll[i] = Integer.parseInt(br.readLine());
        }

        int  start = 0;
        int cnt =0;

        for (int i = N - 1; i >= 0; i--) {
            if(poll[i]>start){
                cnt++;
                start = poll[i];
            }
        }

        System.out.println(cnt);
        br.close();

    }
}
