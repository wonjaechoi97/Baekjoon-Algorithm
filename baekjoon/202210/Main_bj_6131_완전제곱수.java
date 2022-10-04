package algo202210;

import java.io.*;
import java.util.*;
public class Main_bj_6131_완전제곱수 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int result=0;
        for(int a=1; a<=1000; a++){
            for(int b=1; b<=a; b++){
                if(a*a == b*b+N){
                    result++;
                    break;
                } else if (a*a<b*b+N) {
                    break;
                }

            }
        }
        System.out.println(result);
        br.close();
    }
}
