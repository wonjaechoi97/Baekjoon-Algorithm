package algo202210;

import java.io.*;
import java.util.*;

public class Main_bj_2566_최댓값 {
    public static void main(String args[])throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int max = -1;
        int maxI=-1;
        int maxJ = -1;
        for(int i=1; i<=9; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= 9; j++) {
                int n = Integer.parseInt(st.nextToken());
                if(n>max){
//                    System.out.println(max);
                    max = n;
                    maxI = i;
                    maxJ = j;
                }
            }
        }

        System.out.println(max);
        System.out.println(maxI + " " + maxJ);


        br.close();


    }
}
