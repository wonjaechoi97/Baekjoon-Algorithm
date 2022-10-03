package algo202210;

import java.io.*;
import java.util.*;

public class Main_bj_17173_배수들의합 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        int[] nums = new int[M];
        for(int i=0; i<M; i++){
            nums[i] =Integer.parseInt(st.nextToken());
        }
        HashSet<Integer> set = new HashSet<>();

        for(int i=0; i<M; i++){
            int multi = 1;
            while(true){
                int number = nums[i]*multi;
                if(number>N)break;
                set.add(number);
                multi++;
            }
        }
        int result =0;
        for(int n : set){
            result+=n;
        }

        System.out.println(result);
        br.close();
    }
}
