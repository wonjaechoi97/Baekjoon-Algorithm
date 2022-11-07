package algo202211;

import java.io.*;
import java.util.*;

public class Main_bj_17142_연구소3 {

    static class Virus{
        int r;
        int c;
        int time;


        public Virus(int r,int c, int time){
            this.r =r;
            this.c=c;
            this.time = time;
        }

    }
    static int N;
    static int M;
    static int[] di = {-1, 0, 1, 0};
    static int[] dj = {0, 1, 0, -1};

    static int total=0;
    static int min;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        //0 : 빈칸 1: 벽 2: 바이러스

        int[][] map = new int[N][N];
        min = Integer.MAX_VALUE;
        List<Virus> list = new ArrayList<>();
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0; j<N; j++){
                int n = Integer.parseInt(st.nextToken());
                if(n == 0)total++;
                else if (n == 2) {
                    list.add(new Virus(i,j,1));
                }
                map[i][j] = n;
            }
        }

        if(total==0) System.out.println(0);
        else {
            solve(0, 0, map, new Virus[M], list);
            if (min == Integer.MAX_VALUE) System.out.println(-1);
            else System.out.println(min);
        }

        br.close();
    }
    // 0 빈칸
    // 1 벽
    // 2 비활성
    // 3 활성
    static void solve(int idx, int cnt, int[][] map, Virus[] select, List<Virus> list){
//        System.out.println(cnt+" "+M);
        if(cnt == M){
//            for(Virus v : select){
//                System.out.print(v.r+" "+v.c+" ");
//            }
//            System.out.println();
            simulate(select,  map, total);
            return;
        }

        for(int i = idx; i< list.size();i++){
            select[cnt]=list.get(i);
           solve(i+1, cnt+1, map, select, list);
        }

        // M개의 조합을 찾는다
//        while(true){
//
//            if(N==r) break;
//            if(map[r][c]==2){
//                //선택
//                select[cnt] = new Virus(r, c, 1);
//                c++;
//                if(c==N){
//                    r++;
//                    c=0;
//                }
//                solve(r,c,cnt+1,map, select);
//
//                solve(r,c,cnt,map,select);
//                //비선택
//            }else{
//                c++;
//                if(c==N){
//                    r++;
//                    c=0;
//                }
//            }
//        }


    }
    // 0 빈칸
    // 1 벽
    // 2 비활성
    // 3 활성
    static void simulate(Virus[] select, int[][] copyMap, int all){
//        System.out.println("들어오냐?");
        Queue<Virus> que = new LinkedList<>();
        boolean[][] visited = new boolean[N][N];
        for(int i=0; i<M; i++){
            que.add(select[i]);
            visited[select[i].r][select[i].c]=true;
        }

        int max = 0;
        while(!que.isEmpty()){
//            System.out.println(all);
            if(all==0)break;
            Virus cur = que.poll();
            visited[cur.r][cur.c]=true;
            if(cur.time>max) max = cur.time;
            if(max>min) return;
            for(int d=0; d<4; d++){
                int ni = cur.r + di[d];
                int nj = cur.c + dj[d];
                if(0<=ni&&ni<N&&0<=nj&&nj<N&&!visited[ni][nj]){
//                    System.out.println(ni+" "+nj);
                    if(copyMap[ni][nj]==0 || copyMap[ni][nj]==2){
                        if(copyMap[ni][nj]==0)all--;
                        visited[ni][nj]=true;
                        que.add(new Virus(ni, nj, cur.time + 1));
                    }
                }
            }

        }
        if(all>0)return;
//        System.out.println();
        if(min>max)min=max;
    }
}
