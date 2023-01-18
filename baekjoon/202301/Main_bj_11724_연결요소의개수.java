package algo202301;

import java.io.*;
import java.util.*;

public class Main_bj_11724_연결요소의개수 {
    static int cnt;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken()); // 정점 수
        int M = Integer.parseInt(st.nextToken()); // 연결 수

        boolean[] connect = new boolean[N];

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i = 0; i<N; i++){
            graph.add(new ArrayList<Integer>());
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken())-1;
            int to = Integer.parseInt(st.nextToken())-1;
            graph.get(from).add(to);
            graph.get(to).add(from);
        }
//        for(int i=0; i<N; i++){
//            System.out.println(graph.get(i).size());
//        }
        cnt = 0;

        //bfs
        //시작을 0번



        for(int i=0; i<N; i++){
            if(connect[i]) continue;
//            System.out.println(Arrays.toString(connect));
            bfs(connect, graph, i);
        }

        System.out.println(cnt);

        br.close();

    }

    static void bfs(boolean[] connect, ArrayList<ArrayList<Integer>> graph, int start) {
        Queue<Integer> que = new LinkedList<>();
        que.add(start);
        connect[start] = true;
        while(!que.isEmpty()){
            int cur = que.poll();
//            System.out.println(graph.get(cur).size());
            for(int i=0; i<graph.get(cur).size(); i++){

                if(!connect[graph.get(cur).get(i)]){
                    connect[graph.get(cur).get(i)] = true;
                    que.add(graph.get(cur).get(i));
                }
            }
        }

        cnt++;

    }

}
