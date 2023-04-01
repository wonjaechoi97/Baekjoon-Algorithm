package algo202303;

import java.io.*;
import java.util.*;



public class Main_bj_9085_더하기 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        for (int n = 0; n < N; n++) {
            int in = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int sum = 0;
            for(int i=0; i<in; i++){
                sum += Integer.parseInt(st.nextToken());
            }
            System.out.println(sum);
        }
        br.close();

    }
}
