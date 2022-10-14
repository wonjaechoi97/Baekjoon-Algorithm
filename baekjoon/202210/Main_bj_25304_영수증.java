package algo202210;

import java.io.*;
import java.util.*;
public class Main_bj_25304_영수증 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int X = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());
        int sum = 0;
        for (int n = 0; n < N; n++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sum += a * b;
        }
        if(sum!=X){
            System.out.println("No");
        }else{
            System.out.println("Yes");
        }
        br.close();
    }
}
