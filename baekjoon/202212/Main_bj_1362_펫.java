package algo202212;

/*100 10
        E 20
        F 100
        F 100
        # 0
        0 0*/

import java.io.*;
import java.util.*;
public class Main_bj_1362_펫 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = 1;
        while(true){

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int o = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            if(o==0)break;
            String status = "";
            boolean isDead = false;
            while(true){
                st = new StringTokenizer(br.readLine(), " ");
                String order = st.nextToken();

                int num = Integer.parseInt(st.nextToken());
//                System.out.println(w);
                if (order.equals("#")) {
                    if(!isDead) { //안죽음
                        if (o / 2 < w && w < 2 * o) {
                            status = ":-)";
                        } else {
                            status = ":-(";
                        }
                    }else{
                        status = "RIP";
                    }
                    break;
                } else if (order.equals("F")) {
                    w += num;
                } else {
                    w -= num;
                    if (w <= 0) {
//                        System.out.println("여기 오냐");
                        status = "RIP";
                        isDead=true;
                    }
                }

            }
            sb.append(t +" "+ status).append("\n");
            t++;
        }
        System.out.println(sb);
        br.close();
    }
}
