package algo202301;

import java.io.*;
import java.util.*;

public class Main_bj_1904_01타일 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int a = 1;
        int b = 2;

        for (int i = 3; i <= N; i++) {
            int tmp = (a + b)%15746;
            a = b % 15746;
            b = tmp;
        }
        if(N==1){
            System.out.println(1);
        }else{
            System.out.println(b % 15746);
        }
        br.close();
    }
}
