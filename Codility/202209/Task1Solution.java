package algo202209;

import java.io.*;
import java.util.*;

public class Task1Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());



        String[] binary = Integer.toBinaryString(N).split("");
        int max =0;


        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i<binary.length;i++){
            if(binary[i].equals("1")){
                list.add(i);
            }

        }
        int start = 0;

        for (int i = 1; i < list.size();i++ ) {
//            System.out.println(list.get(i)-start);
            if((list.get(i)-start-1)>max){
                max = list.get(i)-start-1;
            }
            start = list.get(i);
        }

        System.out.println(max);
//        System.out.println(binary);


        br.close();
    }
}
