package algo202210;
import java.io.*;
import java.util.*;
public class Main_bj_18429_근손실 {
    static int answer=0;
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine()," ");
        int[] kit = new int[N];
        for(int i=0; i<N; i++){
            kit[i]=Integer.parseInt(st.nextToken());
        }
        int[] result = new int[N];
        boolean[] used = new boolean[N];
        solve(0, result, kit, N, K, used);
        System.out.println(answer);
        br.close();
    }
    static void solve(int cnt, int[] result, int[] kit, int N, int K, boolean[] used ){
        if(cnt==N){
            int start = 500;
            for(int i=0; i<N; i++){
                start=start+kit[result[i]]-K;
                if(start<500)return;
            }
            answer++;
            return;
        }
        for(int i=0; i<N; i++){
            if(used[i]) continue;
            result[cnt] = i;
            used[i]=true;
            solve(cnt+1, result, kit, N, K, used);
            used[i]=false;
        }
    }
}
