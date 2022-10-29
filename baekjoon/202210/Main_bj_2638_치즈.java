package algo202210;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
public class Main_bj_2638_치즈 {
    static int[] di = {-1, 0, 1, 0};
    static int[] dj = {0, 1, 0, -1};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];
        int[][] meltCount = new int[N][M];

        for(int i=0; i<N; i++){
            st= new StringTokenizer(br.readLine()," ");
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int time=0;
        while(true){
            time++;
            Queue<int[]> que = new LinkedList<>();
            que.add(new int[] {0,0});
            boolean[][] visited = new boolean[N][M];
            visited[0][0]=true;
            while(!que.isEmpty()){
                int[] cur = que.poll();

                for(int d=0;d<4;d++){
                    int ni = cur[0] + di[d];
                    int nj = cur[1] + dj[d];
                    if(0<=ni&&ni<N&&0<=nj&&nj<M){
                        if(map[ni][nj]==1) {
                            meltCount[ni][nj]++;
                        }else if(map[ni][nj]==0&&!visited[ni][nj]){
                            visited[ni][nj]=true;
//                            System.out.println(ni+" "+nj);
                            que.add(new int[] {ni,nj});
                        }
                    }
                }

            }
           // for(int[] a : meltCount) System.out.println(Arrays.toString(a));
            //System.out.println();
            for(int i=0; i<N; i++){
                for(int j=0; j<M;j++){
                    if(meltCount[i][j]>1) {
                        map[i][j]=0;

                    }
                    meltCount[i][j]=0;
                }
            }
//            for(int[] a : map) System.out.println(Arrays.toString(a));
//            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~`");
//            System.out.println();
            boolean check =false;
            for(int i=0; i<N; i++){
                for(int j=0; j<M; j++){
                    if(map[i][j]==1){
                        check=true;
                        break;
                    }
                }
            }
            if(!check)break;
        }
        System.out.println(time);

        br.close();

    }
}
