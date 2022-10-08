package algo202210;

import java.io.*;
import java.util.*;

public class Main_bj_10419_지각 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int num = Integer.parseInt(br.readLine());
            int result = 0;
            for(int i=0; i<=num;i++){

                if(i*i+i>num){

                    result = i-1;
                    break;
                }
            }
            sb.append(result).append("\n");
        }
        System.out.println(sb.toString());
        br.close();
    }
}
