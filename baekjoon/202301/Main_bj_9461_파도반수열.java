package algo202301;

import java.io.*;
import java.util.*;

public class Main_bj_9461_파도반수열 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int max  = 0;
        int[] order = new int[n];


        for(int i=0; i<n; i++){
            int a = Integer.parseInt(br.readLine());
            order[i] =a;
            if(max < a) max = a;
        }
        long[] answer = new long[101];
        answer[1] = 1;
        answer[2] = 1;
        answer[3] = 1;
        answer[4] = 2;
        answer[5] = 2;
        for(int i=6; i<=max; i++){
            answer[i] = answer[i-1] + answer[i - 5];
        }

//        System.out.println(Arrays.toString(answer));
        for(int i=0; i<n; i++){
            sb.append(answer[order[i]]).append("\n");
        }

        System.out.println(sb);

        br.close();
    }
}
