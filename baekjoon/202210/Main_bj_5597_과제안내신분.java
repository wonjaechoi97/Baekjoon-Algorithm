package algo202210;

import java.io.*;
import java.util.*;

public class Main_bj_5597_과제안내신분 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean[] arr = new boolean[30];

        for (int i = 0; i < 28; i++) {
            int n = Integer.parseInt(br.readLine());
            arr[n-1]=true;
        }
        int cnt=0;
        for(int i=0; i<30; i++){
            if(!arr[i]){
                System.out.println(i+1);
                cnt++;
            }
            if(cnt==2)break;
        }
        br.close();
    }
}
