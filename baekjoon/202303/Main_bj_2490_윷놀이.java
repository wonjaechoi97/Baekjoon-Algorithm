package algo202303;

import java.io.*;
import java.util.*;
public class Main_bj_2490_윷놀이 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int front=0;
            int back=0;
            for(int j=0; j<4; j++){
                if(Integer.parseInt(st.nextToken())==0){
                    front++;
                }else{
                    back++;
                }
            }
            if(front==0){
                System.out.println("E");
            } else if (front==1) {
                System.out.println("A");
            } else if (front==2) {
                System.out.println("B");
            } else if (front==3) {
                System.out.println("C");
            }else{
                System.out.println("D");
            }
        }


        br.close();
    }

}
