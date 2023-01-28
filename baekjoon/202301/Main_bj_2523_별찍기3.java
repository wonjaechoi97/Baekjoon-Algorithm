package algo202301;

import java.io.*;
import java.util.*;

public class Main_bj_2523_별찍기3 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        //위에 넓어지는 부분

        for(int i=1; i<=n; i++){
            for(int j=0; j<i; j++){
                System.out.print("*");
            }
            System.out.println();
        }

        //줄어드는 부분
        for(int i=n-1; i>0; i--){
            for(int j=0; j<i; j++){
                System.out.print("*");
            }
            System.out.println();
        }

        br.close();
    }
}
