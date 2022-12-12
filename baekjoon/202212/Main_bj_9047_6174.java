package algo202212;

import java.io.*;
import java.util.*;
public class Main_bj_9047_6174 {
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++){
            int input = Integer.parseInt(br.readLine());
            int cnt = 0;
            while(true){
                int[] arr = new int[4];
                if(input==6174){
                    sb.append(cnt).append("\n");
                    break;
                }
                arr[0] = input / 1000;
                arr[1] = (input % 1000) / 100;
                arr[2] = (input % 1000 % 100) / 10;
                arr[3] = (input % 1000 % 100 % 10);
                Arrays.sort(arr);
//                    System.out.println(Arrays.toString(arr));
                int max = 0;
                int min = 0;
                max = arr[3]*1000+arr[2]*100+arr[1]*10+arr[0];
                min = arr[0]*1000+arr[1]*100+arr[2]*10+arr[3];
                input = max - min;
                cnt++;

            }
        }
        System.out.println(sb);
        br.close();
    }
}
