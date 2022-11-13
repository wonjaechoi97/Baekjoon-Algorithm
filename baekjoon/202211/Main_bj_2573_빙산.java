package algo202211;

import java.io.*;
import java.util.*;
public class Main_bj_2573_빙산 {
    static class Ice{
        int i;
        int j;
        int height;

        public Ice(int i, int j, int height) {
            this.i = i;
            this.j = j;
            this.height = height;
        }
    }

    static int[] di = {-1, 0, 1, 0};
    static int[] dj = {0, 1, 0, -1};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];
        List<Ice> list = new ArrayList<>();
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<M; j++){
                int n = Integer.parseInt(st.nextToken());
                if(n>0){
                    list.add(new Ice(i, j, n));
                }
                map[i][j]=n;
            }
        }
        int t=0;
        while(true){
            //주변확인

            for(int i=list.size()-1; i>=0; i--){
                Ice cur = list.get(i);
                int seaCnt = 0;
                for(int d=0; d<4; d++){
                    int ni = cur.i + di[d];
                    int nj = cur.j + dj[d];
                    if(0<=ni&&ni<N&&0<=nj&&nj<M){
                        if(map[ni][nj]==0)seaCnt++;
                    }
                }
                cur.height-=seaCnt;
                if(cur.height<=0){
                    list.remove(i);
                }
            }
            if(list.size()==0){
                System.out.println(0);
                break;
            }
            map= new int[N][M];
            int[][] copy =new int[N][M];
            for(int i=0; i<list.size(); i++){
                Ice cur = list.get(i);
                map[cur.i][cur.j]=copy[cur.i][cur.j]=cur.height;

            }
            t++;

            boolean check = isDivided(copy, list.get(0), N , M);
            if(check){
                System.out.println(t);
                break;
            }
        }

        br.close();
    }
    static boolean isDivided(int[][] map, Ice ice, int N, int M){
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[] {ice.i,ice.j});
        map[ice.i][ice.j]=0;
        while(!que.isEmpty()){
            int[] cur = que.poll();
            for(int d=0; d<4; d++){
                int ni = cur[0] + di[d];
                int nj = cur[1] + dj[d];
                if(0<=ni&&ni<N&&0<=nj&&nj<M){
                    if(map[ni][nj]>0){
                        map[ni][nj]=0;
                        que.add(new int[]{ni, nj});
                    }
                }
            }
        }
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(map[i][j]>0){
                    return true;
                }
            }
        }
        return false;
    }
}
