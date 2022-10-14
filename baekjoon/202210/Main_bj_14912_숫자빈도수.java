package algo202210;

import java.io.*;
import java.util.*;

public class Main_bj_14912_숫자빈도수 {
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int digit = Integer.parseInt(st.nextToken());
        int result =0;

        for (int i = 1; i <= N; i++) {
            String num = Integer.toString(i);
            for(int j=0; j<num.length(); j++){
                if(num.charAt(j)-'0'==digit)result++;
            }
        }
        System.out.println(result);
        br.close();

    }
}
