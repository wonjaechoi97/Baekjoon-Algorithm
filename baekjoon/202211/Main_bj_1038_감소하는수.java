package algo202211;

import java.io.*;
import java.util.*;
public class Main_bj_1038_감소하는수 {
    static int cnt;
    static int N;
    static boolean check;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        if(N<=10){
            System.out.println(N-1);
        }else {
            cnt = 9;
            for (int i = 2; i < 8; i++) {
                for (int n = 1; n <= 9; n++) {
                    int[] selected = new int[i];
                    selected[0] = n;
                    solve(n, i, 1, selected);
                }
                if (cnt >= N) break;
            }
            if(cnt<N) System.out.println(-1);
        }

        br.close();

    }
    static void solve( int ex,int jari,  int count, int[] selected){
        if(cnt==N)return;
        if(count==jari){
//            System.out.println(Arrays.toString(selected));
            cnt++;
            if(cnt==N) {
                StringBuilder sb = new StringBuilder();
                for(int i=0; i<selected.length;i++){
                    sb.append(selected[i]);
                }
                check =true;
                System.out.println(sb.toString());
            }
            return;
        }

        for(int i=0; i<ex; i++){
            if(ex<=i)return;
            selected[count]=i;
            solve(i, jari, count+1, selected);
        }
    }
}
