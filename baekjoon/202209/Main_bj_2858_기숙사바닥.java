package algo202209;

import java.io.*;
import java.util.*;

public class Main_bj_2858_기숙사바닥 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int R = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int L =0;
        int W=0;
        for(int i=1; i<=B; i++){
            if(B%i==0){
                int a = i;
                int b= B/i;
                //System.out.println((a+2)*(b+2)-B);
                if((a+2)*(b+2)-B == R){
                    W = a+2;
                    L = b+2;
                    break;
                }
            }
        }
        System.out.println(L +" "+ W);
    }
}
