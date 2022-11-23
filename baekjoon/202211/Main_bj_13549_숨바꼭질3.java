package algo202211;

import java.io.*;
import java.util.*;

public class Main_bj_13549_숨바꼭질3 {

    static class pos implements Comparable<pos>{
        int p;
        int time;

        public pos(int p, int time) {
            this.p = p;
            this.time = time;
        }

        public int compareTo(pos o){
            int r = this.time-o.time;
            return r;
        }

    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        HashSet<Integer> set = new HashSet<>();
        Queue<pos> que =new LinkedList<>();
        int[] visited = new int[100_001];
        for(int i=0; i<100001; i++){
            visited[i]=100002;
        }
;       que.add(new pos(N, 0));
        visited[N]=0;
        while(!que.isEmpty()){
            pos cur = que.poll();

            int x = cur.p;
//            System.out.println(x);
            if(0<=(x-1)&&(x-1)<=100_000){
                if(cur.time+1<visited[x-1]){
                    visited[x - 1] = cur.time + 1;
                    que.add(new pos(x-1, cur.time+1));
                }
            }
            if(0<=(x+1)&&(x+1)<=100_000){
                if (cur.time + 1 < visited[x + 1]) {
                    visited[x + 1] = cur.time + 1;
                    que.add(new pos(x + 1, cur.time + 1));
                }
            }
            if(0<=(x*2)&&(x*2)<=100_000){
                if (cur.time  < visited[x*2]) {
                    visited[x*2] = cur.time;
                    que.add(new pos(x * 2, cur.time));
                }
            }
        }

        System.out.println(visited[K]);
        br.close();

    }

}
