package algo202210;

import java.io.*;
import java.util.*;

public class Main_bj_2851_슈퍼마리오 {
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sum = 0;
        int min = Integer.MAX_VALUE;
        for(int i=0; i<10; i++){
            int n = Integer.parseInt(br.readLine());

            if(Math.abs(100-(sum+n))>min){
                break;
            }
            min = Math.abs(100-(sum+n));
            sum+=n;
        }

        System.out.println(sum);
        br.close();

    }
}
