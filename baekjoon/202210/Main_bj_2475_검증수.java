package algo202210;
import java.io.*;
import java.util.*;

public class Main_bj_2475_검증수 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int sum=0;
        for(int i=0; i<5; i++){
            int a = Integer.parseInt(st.nextToken());
            sum+=a*a;
        }
        System.out.println(sum%10);
        br.close();

    }
}
