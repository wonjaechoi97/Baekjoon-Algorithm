package algo202211;
import java.io.*;
import java.util.*;
public class Main_bj_10816_숫자카드2 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        HashMap<Integer, Integer> map = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i=0; i<N; i++){
            int n = Integer.parseInt(st.nextToken());
            map.put(n ,map.getOrDefault(n,0)+1);
        }
        int M = Integer.parseInt(br.readLine());
        int[] result  = new int[M];
        int total=0;
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<M; i++){
            int x = map.getOrDefault(Integer.parseInt(st.nextToken()),0);
            result[i]=x;
        }
        for(int i =0; i<M; i++){
            sb.append(result[i]+" ");
        }
        System.out.println(sb.toString());
        br.close();

    }
}
