package algo202212;

import java.io.*;
import java.util.*;
public class Main_bj_3060_욕심쟁이돼지 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        long T = Long.parseLong(br.readLine());
        for (int t = 0; t < T; t++) {
            long N = Long.parseLong(br.readLine());
            long[] pigs = new long[6];
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int sum = 0;
            for(int i=0; i<6; i++){
                pigs[i] = Integer.parseInt(st.nextToken());
                sum += pigs[i];
            }
            int cnt = 1;
            while (true) {
                if(sum>N){
                    sb.append(cnt).append("\n");
                    break;
                }
                sum *= 4;
                cnt++;


            }
        }
        System.out.println(sb);

        br.close();
    }
}
