package algo202301;

import java.io.*;
import java.util.*;
public class Main_bj_2840_행운의바퀴 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken()); // 바퀴 카 수
        int K = Integer.parseInt(st.nextToken()); // 바퀴 돌리는 횟수

        char[] arr = new char[N];
        int[] change = new int[K];
        char[] alpha = new char[K];
        boolean[] used = new boolean[26];
        for(int i=0; i<N; i++){
            arr[i] = '?';
        }

        for(int i=0; i<K; i++){
            st = new StringTokenizer(br.readLine()," ");
            change[i] = Integer.parseInt(st.nextToken());
            alpha[i] = st.nextToken().charAt(0);

        }

        String result = "?";


        int turn = 0;
        //역으로
        for(int i=K-1; i>=0; i--){
            if(arr[turn]=='?'){
                if(used[alpha[i]-'A']){ //이미 사용된 알파벳이라면?
                    result = "!";
                    break;
                }
                arr[turn] = alpha[i];
                used[alpha[i]-'A']=true;
            }else if(arr[turn]!=alpha[i]) {
                result = "!";
                break;
            }
            turn = (turn+change[i])%N;
        }
        if(result.equals("?")){
            result = "";
            for(int i=0; i<N; i++){
                result +=arr[i];
            }
        }
        System.out.println(result);
        br.close();
    }
}
