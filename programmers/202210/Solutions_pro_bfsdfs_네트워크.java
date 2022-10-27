package algo202210;
import java.io.*;
import java.util.*;


public class Solutions_pro_bfsdfs_네트워크 {
    public static void main(String[] args)throws Exception {
        int[][] computers = {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};
        int n = 3;
        boolean[] connected = new boolean[n];
        int answer = 0;
        // n : 컴퓨터 개수
        for(int i=0; i<n; i++){
            if(connected[i])continue;
//            System.out.println(i+"!!!!!!!!!!!!!!!!!!!");
            answer++;
            Queue<Integer> que = new LinkedList<>();
            que.add(i);
            while(!que.isEmpty()){
                int cur = que.poll();
//                System.out.println(cur);
                connected[cur]=true;
                for(int j=0; j<n; j++){

                    if(computers[cur][j]==1){
                        if(!connected[j])que.add(j);
                    }
                }
            }
        }
        System.out.println(answer);

    }
}
