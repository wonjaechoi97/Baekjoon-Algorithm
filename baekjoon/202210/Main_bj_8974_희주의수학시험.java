package algo202210;

import java.io.*;
import java.util.*;

public class Main_bj_8974_희주의수학시험 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int num = 1;
        int cnt = 1;
        int totalCnt=1;
        int sum = 0;
        while(true){
            if(totalCnt>B)break;
            if(A<=totalCnt && totalCnt<=B){
                sum+=num;
//                System.out.println(totalCnt+" : "+sum);
            }
            cnt++;
            totalCnt++;
            if(cnt>num){
                num++;
                cnt =1;
            }


        }
        System.out.println(sum);
        br.close();

    }
}
