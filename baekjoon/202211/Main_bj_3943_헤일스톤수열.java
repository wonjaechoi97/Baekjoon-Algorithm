package algo202211;
import java.io.*;
import java.util.*;
public class Main_bj_3943_헤일스톤수열 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++){
            int num = Integer.parseInt(br.readLine());
            int max = num;
            while(num!=1){
                if(num%2==0){
                    num/=2;
                }else{
                    num=num*3+1;
                    if(num>max)max=num;
                }
            }
            sb.append(max).append("\n");
        }
        System.out.println(sb.toString());
        br.close();

    }
}
