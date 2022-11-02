package algo202211;

import java.io.*;
import java.util.*;
public class Main_bj_1748_수이어쓰기 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int start = 10;
        int N = Integer.parseInt(br.readLine());
        int result = 0;
        int len = 1;
        for(int i=1; i<=N; i++){
            if(i/start==0){
                result+=len;
            }else{
                start*=10;
                len++;
                result +=len;
            }
        }
        System.out.println(result);
        br.close();
    }
}
