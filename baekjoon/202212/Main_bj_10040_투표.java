package algo202212;

import java.io.*;
import java.util.*;
public class Main_bj_10040_투표 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int max = 0;
        int max_idx=-1;
        int[] game = new int[N];
        int[] people = new int[M];
        int[] vote = new int[N];
        for(int i=0; i<N; i++){
            game[i] = Integer.parseInt(br.readLine());
        }

        for(int i=0; i<M; i++){
            people[i] = Integer.parseInt(br.readLine());
        }

        for(int i=0; i<M; i++){

            int val = people[i];

            for(int j=0; j<N; j++){
                if(game[j]<=val){
                    vote[j]=vote[j]+1;

                    if(vote[j]>max) {
                        max = vote[j];
                        max_idx = j+1;
                    }
                    break;
                }
            }
        }

        System.out.println(max_idx);

        br.close();
    }

}
