package algo202209;
import com.sun.security.jgss.GSSUtil;

import java.io.*;
import java.util.*;
public class Main_bj_1051_숫자정사각형 {
    static int[] di = {0,1,1};
    static int[] dj = {1,1,0};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        for(int i=0; i<N; i++){
            String line = br.readLine();
            for(int j=0; j<M; j++){

                map[i][j]=(int)(line.charAt(j)-'0');
            }
        }
        int max = 0;
        int limit = 0;
        if(N>=M) limit = M;
        else limit = N;
        for(int i=0; i<N; i++){
            check : for(int j=0; j<M; j++){
                for(int k=1; k<=limit; k++) {
                    if(k<max)continue;
                    //우 탐색
                    int ni = i+di[0]*k;
                    int nj = j+dj[0]*k;
                    int checknum = map[i][j];
                    if(0<=ni&&ni<N&&0<=nj&&nj<M){
                        if(checknum != map[ni][nj]) continue ;
                    }else {
                        continue check;
                    }
                    //하 탐색
                    ni = i+di[1]*k;
                    nj = j+dj[1]*k;
                    if(0<=ni&&ni<N&&0<=nj&&nj<M){
                        if(checknum != map[ni][nj]) continue ;
                    }else {
                        continue check;
                    }
                    // 우 하 탐색
                    ni = i+di[2]*k;
                    nj = j+dj[2]*k;
                    if(0<=ni&&ni<N&&0<=nj&&nj<M){
                        if(checknum != map[ni][nj]) continue ;
                    }else {
                        continue check;
                    }
                    if(k>max)max = k;
                }
            }
        }
//        for(int[] a: map) System.out.println(Arrays.toString(a));
//        System.out.println("*******************");
        max++;
        System.out.println(max*max);

        br.close();
    }
}
