package algo202212;

import java.io.*;
import java.util.*;
public class Main_bj_21918_전구 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] lights = new int[N+1];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=1; i<=N; i++){
            lights[i] = Integer.parseInt(st.nextToken());
        }
        for (int t = 0; t < M; t++) {
            st = new StringTokenizer(br.readLine(), " ");
            int order = Integer.parseInt(st.nextToken());
            if(order == 1){
                int i = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());
                lights[i]=x;
            }else if(order==2){
                int l = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());
                for(int j=l; j<=r; j++){
                    if(lights[j]==0)lights[j]=1;
                    else lights[j]=0;
                }
            }else if(order==3){
                int l = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());
                for(int j=l; j<=r; j++){
                    lights[j]=0;
                }
            }else{
                int l = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());
                for(int j=l; j<=r; j++){
                    lights[j]=1;
                }
            }
        }
        for(int i=1;i<=N; i++){
            System.out.print(lights[i]);
            if(i==N)break;
            System.out.print(" ");
        }

    }

}
