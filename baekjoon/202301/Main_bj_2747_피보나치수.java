package algo202301;

import java.io.*;
import java.util.*;

public class Main_bj_2747_피보나치수 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int ex = 0;
        int num = 1;

        for (int i = 1; i < n; i++) {
            int tmp = num;
            num = ex + num;
            ex = tmp;
            //System.out.println(num);
        }
        System.out.println(num);
        br.close();

    }
}
