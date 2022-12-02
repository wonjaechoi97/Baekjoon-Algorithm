package algo202212;
import java.io.*;
import java.util.*;
public class Main_bj_22864_피로도 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int damage = 0;
        int total=0;
        for(int i=0; i<24; i++){
            if(damage+A<=M){
                damage+=A;
                total+=B;
            }else{
                damage-=C;
                if(damage<0)damage=0;
            }
        }
        System.out.println(total);
        br.close();

    }
}
