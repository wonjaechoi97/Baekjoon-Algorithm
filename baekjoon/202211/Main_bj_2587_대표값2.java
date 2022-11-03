package algo202211;

import java.io.*;
import java.util.*;
public class Main_bj_2587_대표값2 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] array = new int[5];
        int sum = 0 ;
        for(int i=0; i<5; i++){
            int n = Integer.parseInt(br.readLine());
            array[i] = n;
            sum+=n;
        }
        Arrays.sort(array);

        System.out.println(sum/5);
        System.out.println(array[2]);
        br.close();

    }
}
