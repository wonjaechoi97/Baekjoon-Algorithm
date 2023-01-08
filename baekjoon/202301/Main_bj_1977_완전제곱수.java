package algo202301;

import java.io.*;
import java.util.*;
public class Main_bj_1977_완전제곱수 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int from = (int)Math.sqrt(N);
       // System.out.println(from);
        int sum = 0;
        int min = -1;
        boolean isMin = false;
        while(true){
            int res = from*from;
            if(N<=res&&res<=M){
                if(!isMin){
                    min = res;
                    isMin=true;
                }
                sum+=res;
            }else if(res>M){
                break;
            }
            from++;
        }
        if(sum!=0)System.out.println(sum);
        System.out.println(min);
        br.close();
    }
}
