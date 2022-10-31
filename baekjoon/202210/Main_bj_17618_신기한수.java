package algo202210;

import java.io.*;
public class Main_bj_17618_신기한수 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int N = Integer.parseInt(br.readLine());
        int cnt = 0;
        for(int i=1; i<=N; i++){
            String num = Integer.toString(i);
            int sum=0;
            for (char a : num.toCharArray()) {
                int x =Integer.parseInt(Character.toString(a));
                sum += x;
            }
            if(i % sum ==0)cnt++;
        }
        System.out.println(cnt);

        br.close();

    }
}
