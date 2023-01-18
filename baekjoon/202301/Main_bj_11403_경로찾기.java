package algo202301;

import java.io.*;
import java.util.*;

public class Main_bj_11403_경로찾기 {
    static int N;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        int[][] graph = new int[N][N];

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<N; i++){
            for (int j = 0; j < N; j++) {
                if(find(graph, i, j)){
                    sb.append(1).append(" ");
                }else{
                    sb.append(0).append(" ");
                }
            }
            sb.append("\n");
        }
        /*for (int[] a : graph) {
            System.out.println(Arrays.toString(a));
        }*/

        System.out.println(sb);




        br.close();
    }

    static boolean find(int[][] graph, int from, int to){
        boolean[] visited = new boolean[N];
        Queue<Integer> que = new LinkedList<>();
        //i 부터 시작
        for (int i = 0; i < N; i++) {
            if(graph[from][i]==1){
                if(i==to){
                    return true;
                }else{
                    que.add(i);
                }
            }
        }
        while (!que.isEmpty()) {

            int cur = que.poll();
            visited[cur] = true;
            for(int i=0; i<N; i++){
                if(graph[cur][i]==1){
                    if(i==to){
                        return true;
                    }else{
                        if(!visited[i]) que.add(i);
                    }
                }
            }
        }
        return false;
    }
}
