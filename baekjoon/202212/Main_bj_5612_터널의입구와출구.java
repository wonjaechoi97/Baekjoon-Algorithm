package algo202212;

import java.io.*;
import java.util.*;
public class Main_bj_5612_터널의입구와출구 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        boolean under=false;
        int max = m;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int in = Integer.parseInt(st.nextToken());
            int out = Integer.parseInt(st.nextToken());
            m = m+in-out;
            if(m>max)max=m;
            if(m<0){
                under = true;
                break;
            }
        }
        if(under){
            System.out.println(0);
        }else{
            System.out.println(max);
        }
    }
}
