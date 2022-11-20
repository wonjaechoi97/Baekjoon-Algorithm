package algo202211;
import java.io.*;
import java.util.*;
public class Main_bj_2979_트럭주차 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int[] a = new int[2];
        int[] b = new int[2];
        int[] c = new int[2];
        st = new StringTokenizer(br.readLine()," ");
        a[0] = Integer.parseInt(st.nextToken());
        a[1] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine()," ");
        b[0] = Integer.parseInt(st.nextToken());
        b[1] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine()," ");
        c[0] = Integer.parseInt(st.nextToken());
        c[1] = Integer.parseInt(st.nextToken());
        int time = Math.max(c[1], Math.max(a[1], b[1]));
        int cost = 0;
        for(int i=1; i<=time; i++){
            int cnt = 0;
            if(a[0]<=i&&i<a[1]) cnt++;
            if(b[0]<=i&&i<b[1]) cnt++;
            if(c[0]<=i&&i<c[1]) cnt++;
            if(cnt==1){
                cost +=A;
            }else if(cnt==2){
                cost +=2*B;
            }else if(cnt==3){
                cost +=3*C;
            }
        }
        System.out.println(cost);

    }
}
