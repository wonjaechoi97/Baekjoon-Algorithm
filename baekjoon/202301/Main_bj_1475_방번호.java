package algo202301;

import java.io.*;
import java.util.*;
public class Main_bj_1475_방번호 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        int[] numbers = new int[10];

        for(int i=0; i<input.length(); i++){
            int index = input.charAt(i) - '0';
             numbers[index]++;
        }
        int sn = numbers[6]+numbers[9];
        int max = 0;
        if (sn % 2 == 0) {

            max = sn / 2;
        } else {
            max = sn / 2 + 1;
        }

        for (int i = 0; i < 10; i++) {
            if(i==6||i==9)continue;
            if(numbers[i]>max) max = numbers[i];
        }
        System.out.println(max);
        br.close();
    }
}
