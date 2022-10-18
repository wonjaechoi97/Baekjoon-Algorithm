package algo202209;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_bj_2003_수들의합2 {
    static int count;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        count = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < N; i++) {

            solve(arr, i, 0, M, N);
//            System.out.println(i+" "+count);
        }
        System.out.println(count);
        br.close();

    }

    public static void solve(int[] arr, int cur, int sum, int M,int N) {

        if(sum==M){
            count++;
            return;
        }else if(sum>M)return;
        if(cur==N) return;
        sum += arr[cur];
//        System.out.println(sum);
        solve(arr, cur + 1, sum, M, N);
    }
}
