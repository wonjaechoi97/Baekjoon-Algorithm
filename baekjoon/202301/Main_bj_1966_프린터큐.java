package algo202301;

import java.io.*;
import java.util.*;

public class Main_bj_1966_프린터큐 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for(int t=0; t<T;t++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken()); //문서의 개수
            int M = Integer.parseInt(st.nextToken()); //원하는 문서 위치
            st = new StringTokenizer(br.readLine(), " ");
            List<Integer> list = new LinkedList<>(); // 우선 순위가 높은 순으로 집어 넣을 리스트
            Queue<int[]> que = new LinkedList<>();
            for(int i=0; i<N; i++){
                int priority = Integer.parseInt(st.nextToken());
                list.add(priority);
                que.add(new int[] {i, priority}); // 초기 위치와 우선순위를 각각 담기
            }

            list.sort(Comparator.reverseOrder());
            int cnt = 1;
            while(true){
                int[] cur = que.poll();
                if(cur[1]==list.get(0)) { //큐에서 뽑은 우선순위가 가장 높은 우선순위라면
                    if(cur[0]==M){ // 출력한게 원하는 문서라면?
                        sb.append(cnt).append("\n");
                        break;
                    }else{ //원하는 문서가 아니라면
                        cnt++;
                        list.remove(0);
                    }
                }else{//우선 순위 높은게 아니라면
                    que.add(cur);
                }
            }

        }
        System.out.println(sb);

        br.close();

    }
}
