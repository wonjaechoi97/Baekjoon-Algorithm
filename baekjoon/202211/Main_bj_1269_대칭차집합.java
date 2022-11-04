package algo202211;

import java.io.*;
import java.util.*;

public class Main_bj_1269_대칭차집합 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int[] arrA = new int[a];
        int[] arrB = new int[b];
        HashSet<Integer> setA = new HashSet<>();
        HashSet<Integer> setB = new HashSet<>();
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<a; i++){
            int n = Integer.parseInt(st.nextToken());
            arrA[i] = n;
            setA.add(n);

        }
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<b; i++){
            int n = Integer.parseInt(st.nextToken());
            arrB[i]= n;
           setB.add(n);
        }

        int sum = 0;
        for(int i=0; i<a; i++){
            if(!setB.contains(arrA[i]))sum++;
        }
        for(int i=0; i<b; i++){
            if(!setA.contains(arrB[i]))sum++;
        }
        System.out.println(sum);
        br.close();

    }
}
