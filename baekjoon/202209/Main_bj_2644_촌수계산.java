package algo202209;

import java.io.*;
import java.util.*;
public class Main_bj_2644_촌수계산 {
    static class family implements Comparable<family>{
        int me;
        int chon;

        public family(int me, int chon) {
            this.me = me;
            this.chon = chon;
        }

        @Override
        public int compareTo(family o) {
            int r = this.chon - o.chon;
            return r;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int targetA = Integer.parseInt(st.nextToken());
        int targetB = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(br.readLine());
        List<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<Integer>());
        }

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        int result = -1;

        PriorityQueue<family> que = new PriorityQueue<>();
        boolean[] visited = new boolean[N+1];
        que.add(new family(targetA,0));
        while (!que.isEmpty()) {
            family cur = que.poll();
            if(cur.me == targetB){
                result = cur.chon;
                break;
            }
            for(int i=0; i<graph.get(cur.me).size(); i++){
                if (!visited[graph.get(cur.me).get(i)]) {
                    que.offer(new family(graph.get(cur.me).get(i), cur.chon+1));
                    visited[graph.get(cur.me).get(i)] = true;
                }
            }
        }

        System.out.println(result);

        br.close();
    }
}
