package algo202301;

import java.io.*;
import java.util.*;

public class Main_bj_11279_최대힙 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> que = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < N; i++) {
            int o = Integer.parseInt(br.readLine());
            if(o==0){
                if(que.isEmpty()){
                    sb.append(0).append("\n");
                }else{
                    sb.append(que.poll()).append("\n");
                }
            }else{
                que.add(o);

            }
        }

        System.out.println(sb);


        br.close();

    }
}
