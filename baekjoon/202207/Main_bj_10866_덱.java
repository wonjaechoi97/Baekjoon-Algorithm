package AlgoJuly22;

import java.io.*;
import java.util.*;

public class Main_bj_10866_덱 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Deque<Integer> deque = new ArrayDeque<>();
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            String order = st.nextToken();

            if(order.equals("push_back")){
                int num = Integer.parseInt(st.nextToken());
                deque.addLast(num);
            }else if(order.equals("push_front")){
                int num = Integer.parseInt(st.nextToken());
                deque.addFirst(num);
            }else if(order.equals("pop_front")){
                if(deque.isEmpty()){//비었다면
                    System.out.println(-1);
                }else{
                    System.out.println(deque.pollFirst());
                }
            }else if(order.equals("pop_back")){
                if(deque.isEmpty()){//비었다면
                    System.out.println(-1);
                }else{
                    System.out.println(deque.pollLast());
                }
            }else if(order.equals("size")){
                System.out.println(deque.size());
            }else if(order.equals("empty")){
                if(deque.isEmpty()){//비었다면
                    System.out.println(1);
                }else{
                    System.out.println(0);
                }
            }else if(order.equals("front")){
                if(deque.isEmpty()){//비었다면
                    System.out.println(-1);
                }else{
                    System.out.println(deque.getFirst());
                }
            }else{
                if(deque.isEmpty()){//비었다면
                    System.out.println(-1);
                }else{
                    System.out.println(deque.getLast());
                }
            }
        }

        br.close();

    }
}
