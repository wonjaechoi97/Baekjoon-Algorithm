package algo202210;

import java.io.*;
import java.util.*;
public class Main_bj_1697_숨바꼭질 {
    static class Subin implements Comparable<Subin>{
        int pos;
        int turn;

        public Subin(int pos, int turn) {
            this.pos = pos;
            this.turn = turn;
        }

        @Override
        public int compareTo(Subin o) {
            return this.turn-o.turn;
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());//술래
        int K = Integer.parseInt(st.nextToken());//동생

        PriorityQueue<Subin> que = new PriorityQueue<>();
        boolean[] visited = new boolean[100001];
        que.offer(new Subin(N,0));
        int result = 0;
        while (true) {
            Subin cur = que.poll();
            visited[cur.pos]=true;
            if(cur.pos == K){
                result = cur.turn;
                break;
            }
            if(cur.pos-1>=0&&!visited[cur.pos-1]) {
                que.offer(new Subin(cur.pos - 1, cur.turn + 1));
            }
            if(cur.pos+1<=100000&&!visited[cur.pos+1]) {
                que.offer(new Subin(cur.pos + 1, cur.turn + 1));
            }
            if(cur.pos*2<=100000&&!visited[cur.pos*2]) {
                que.offer(new Subin(cur.pos * 2, cur.turn + 1));
            }
        }
        System.out.println(result);
        br.close();

    }
}
