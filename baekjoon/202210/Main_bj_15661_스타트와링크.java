package algo202210;
import com.sun.security.jgss.GSSUtil;

import java.io.*;
import java.util.*;

public class Main_bj_15661_스타트와링크 {
    static int N;
    static int[][] ability;

    static int min;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        ability = new int[N][N];
        min = Integer.MAX_VALUE;
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                ability[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        solve(0,new boolean[N]);
        System.out.println(min);
        br.close();

    }
    static void solve(int cnt, boolean[] listA){
        if(cnt == N){

            boolean[] listB = new boolean[N];
            int fcount=0;
            for(int i=0; i<N; i++){
                if(!listA[i]){
                    listB[i]=true;
                    fcount++;
                }
            }
//            System.out.println(Arrays.toString(listA));
//            System.out.println(Arrays.toString(listB));
            if(fcount==N || fcount==0)return;
            int pointA=0;
            int pointB=0;
            for(int i=0; i<N; i++){
                if(listA[i]){
                    for(int j=i+1; j<N; j++){
                        if(listA[j]) {
//                            System.out.println(ability[i][j] + " " + ability[j][i]);
                            pointA += (ability[i][j] + ability[j][i]);
                        }
                    }
                }
            }
//            System.out.println("???");
            for(int i=0; i<N; i++){
                if(listB[i]){
                    for(int j=i+1; j<N; j++){
                        if(listB[j]) {
                            pointB += (ability[i][j] + ability[j][i]);
                        }
                    }
                }
            }
            min = Math.min(min, Math.abs(pointA-pointB));
//            System.out.println(pointA+" "+pointB);


            return;
        }
        //부분집합
        //선택
       listA[cnt]=true;
        solve(cnt+1, listA);
        //비선택
        listA[cnt]=false;
        solve(cnt+1,listA);
    }
}
