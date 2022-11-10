package algo202211;

import java.io.*;
import java.util.*;
public class Main_bj_18258_큐2 {
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        Deque<Integer> que = new ArrayDeque<>();


        int front = -1;
        int back = -1;

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String order = st.nextToken();
            if(order.equals("push")){
                que.offer(Integer.parseInt(st.nextToken()));
            } else if (order.equals("pop")) {
                if(que.isEmpty()){
                    sb.append(-1).append("\n");
                }else{
                    sb.append(que.poll()).append("\n");
                }
            }else if (order.equals("size")) {
                sb.append(que.size()).append("\n");
            }else if (order.equals("empty")) {
                if(que.isEmpty()){
                    sb.append(1).append("\n");
                }else{
                    sb.append(0).append("\n");
                }
            }else if (order.equals("front")) {
                if(que.isEmpty()){
                    sb.append(-1).append("\n");
                }else{
                    sb.append(que.peek()).append("\n");
                }
            }else{
                if(que.isEmpty()){
                    sb.append(-1).append("\n");
                }else{
                    sb.append(que.peekLast()).append("\n");
                }
            }
        }

        System.out.println(sb.toString());
        br.close();

    }
}
