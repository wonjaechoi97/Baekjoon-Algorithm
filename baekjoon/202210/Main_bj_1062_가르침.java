package algo202210;

import java.io.*;
import java.util.*;

public class Main_bj_1062_가르침 {
    static int max;
    static String[] input;
    static int K;
    static int N;
    static boolean[] alphabet;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        max = -1;
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        alphabet = new boolean[26];
        input = new String[N];

        if(K<5) System.out.println(0);
        else if(K==26) System.out.println(N);
        else {
            alphabet[0] = true;
            alphabet['c' - 'a'] = true;
            alphabet['i' - 'a'] = true;
            alphabet['n' - 'a'] = true;
            alphabet['t' - 'a'] = true;

            // a c n t i
            for (int i = 0; i < N; i++) {
                String in = br.readLine().replaceAll("anta|tica","");

//                System.out.println(in);
                input[i] = in;

            }


            solve(0,  0);
            System.out.println(max);
        }
        br.close();
    }
    static void solve(int cnt,  int cur){
        //System.out.println(cur);
        if(cnt==K-5){
//            System.out.println(Arrays.toString(selected));
//            System.out.println(Arrays.toString(alphabet));
            int total=0;

            for(int i=0; i<N;i++){
                boolean check = true;
                for(int s =0; s<input[i].length();s++){
                   if(!alphabet[input[i].charAt(s)-'a']) {
                       check=false;
                       break;
                   }

                }
                if(check)total++;
            }
            max = Math.max(total,max);
            return;
        }
        // a b c d e f g h  i j k l m n o p q r s t u v w x y z
        for(int i = cur; i<26; i++){
            if(!alphabet[i]) {
                //선택
//            System.out.println(i);
                alphabet[i] = true;
                solve(cnt + 1, i+1);
                alphabet[i] = false;
            }

        }
    }
}
