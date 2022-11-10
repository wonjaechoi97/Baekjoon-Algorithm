package algo202211;

import java.io.*;
import java.util.*;

public class Main_bj_14470_전자레인지 {
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int A = Integer.parseInt(br.readLine()); //현재온도
        int B = Integer.parseInt(br.readLine()); //목표온도
        int C = Integer.parseInt(br.readLine()); //언 상태에서 1도 올리는 시간
        int D = Integer.parseInt(br.readLine()); //해동에 걸리는 시간
        int E = Integer.parseInt(br.readLine()); //해동된 고기 1도 올리는 시간

        int time = 0;
        boolean freeze = false;
        if(A>0)freeze=false;
        else if(A<0)freeze=true;
        while(true){
            if(A == B)break;
            if(A<0){
                A++;
                time+=C;
            }else if(A==0&&freeze){
                time+=D;
                freeze=false;
            }else{
                A++;
                time+=E;
            }
        }

        System.out.println(time);

        br.close();

    }
}
