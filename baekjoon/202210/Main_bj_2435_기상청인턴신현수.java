package algo202210;

import java.io.*;
import java.util.*;

public class Main_bj_2435_기상청인턴신현수 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] nums = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        int max = Integer.MIN_VALUE;

        for (int i = 0; i <= N - K; i++) {
            int sum = 0;
            for(int k=0; k<K; k++){
                sum += nums[i + k];
            }
            if(sum>max)max = sum;
        }

        System.out.println(max);

        br.close();
    }
}
