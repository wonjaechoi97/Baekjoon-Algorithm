package algo202302;

import java.io.*;
import java.util.*;
public class Main_bj_5014_스타트링크 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int F = Integer.parseInt(st.nextToken()); // 총 층
        int S = Integer.parseInt(st.nextToken()); // 강호 위치
        int G = Integer.parseInt(st.nextToken()); // 목적지
        int U = Integer.parseInt(st.nextToken()); // up
        int D = Integer.parseInt(st.nextToken()); //down

        boolean[] visited = new boolean[F+1];
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{S, 0});
        visited[S] = true;
        boolean pos = false;
        while(!que.isEmpty()){
            int[] cur = que.poll();
//            System.out.println(cur[0]);
            if(cur[0]==G){
                System.out.println(cur[1]);
                pos = true;
                break;
            }else{
                // up
                if (cur[0] + U <= F && !visited[cur[0] + U]) {
                    visited[cur[0] + U] = true;
                    que.add(new int[]{cur[0] + U, cur[1] + 1});
                }
                //down
                if (cur[0] - D > 0 && !visited[cur[0]  - D]) {
                    visited[cur[0] - D] = true;
                    que.add(new int[]{cur[0]  - D, cur[1] + 1});
                }
            }
        }
        if(!pos){
            System.out.println("use the stairs");
        }
        br.close();
    }
}
