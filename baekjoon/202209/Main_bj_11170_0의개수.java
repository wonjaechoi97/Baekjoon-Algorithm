package algo202209;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_bj_11170_0의개수 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int cnt = 0;
            for(int i=N; i<=M; i++){
                int num = i;
                while(true){
                    int rest = num%10;
                    if(rest==0)cnt++;
                    num/=10;
                    if(num == 0 )break;
                }
            }
            sb.append(cnt).append("\n");

        }
        System.out.println(sb.toString());

        br.close();
    }
}
