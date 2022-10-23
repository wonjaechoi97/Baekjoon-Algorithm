package algo202210;
import java.io.*;
import java.util.*;
public class Main_bj_10845_큐 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Queue<Integer> que = new LinkedList<>();
        int last = 0;
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String com = st.nextToken();
            if(com.equals("push")){
                int num = Integer.parseInt(st.nextToken());
                last = num;
                command(com,que, num, last);

            }else{
                command(com, que, 0, last);
            }

        }

        br.close();
    }

    static void command(String com, Queue<Integer> que, int num, int last) {

        if(com.equals("push")){
            que.add(num);
        }else if(com.equals("pop")){
            if(que.isEmpty()){
                System.out.println(-1);
            }else{
                System.out.println(que.poll());
            }
        }else if(com.equals("size")){
            System.out.println(que.size());
        }else if(com.equals("empty")){
            if(que.isEmpty()){
                System.out.println(1);
            }else{
                System.out.println(0);
            }
        }else if(com.equals("front")){
            if(que.isEmpty()){
                System.out.println(-1);
            }else{
                System.out.println(que.peek());
            }
        }else if(com.equals("back")){
            if (que.isEmpty()) {
                System.out.println(-1);
            }else{
                System.out.println(last);
            }
        }
    }
}
