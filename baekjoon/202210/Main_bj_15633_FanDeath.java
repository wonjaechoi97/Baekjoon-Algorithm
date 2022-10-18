package algo202210;

import java.io.*;
import java.util.*;
public class Main_bj_15633_FanDeath {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int result = 0;
        for(int i=1; i<=n; i++){
            if(n % i ==0){
                result += i;
            }
        }
        System.out.println(result * 5 - 24);
        br.close();
    }
}
