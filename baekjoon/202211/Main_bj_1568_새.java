package algo202211;
import java.io.*;
import java.util.*;
public class Main_bj_1568_새 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int t=0;
        int start = 1;
        while(N>0){
            if(N>=start){
                N-=start;
                t++;
                start ++;
            }else{
                start = 1;
            }
        }
        System.out.println(t);
        br.close();
    }
}
