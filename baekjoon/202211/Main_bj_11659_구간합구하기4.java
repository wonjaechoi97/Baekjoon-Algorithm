package algo202211;
import java.util.*;
import java.io.*;
public class Main_bj_11659_구간합구하기4 {
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        arr[0] = Integer.parseInt(st.nextToken());
        for(int i=1; i<N; i++){
            arr[i] = arr[i - 1] + Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(a==1){
                System.out.println(arr[b-1]);
            }else{
                System.out.println(arr[b-1]-arr[a-2]);
            }
        }

        br.close();

    }
}
