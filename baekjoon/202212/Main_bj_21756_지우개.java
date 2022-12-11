package algo202212;

import java.io.*;
import java.util.*;
public class Main_bj_21756_지우개 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<Integer> list = new LinkedList<>();
        for(int i=1; i<=n; i++){
            list.add(i);
        }


        while(list.size()!=1){
            for(int i=list.size()-1; i>=0; i--){
                if(i%2==0){
                    list.remove(i);
                }
            }
          /*  for(int i = 0; i<list.size(); i++){
                System.out.print(list.get(i)+" ");
            }
            System.out.println();*/
        }
        System.out.println(list.get(0));
        br.close();
    }
}
