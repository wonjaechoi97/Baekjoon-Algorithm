
import java.io.*;
import java.util.*;

public class Main_bj_2164_카드2 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Integer> list = new LinkedList<>();

        for(int i=1; i<=N; i++){
            list.add(i);
        }

//        System.out.println(list.size());

        while(list.size()!=1){

            list.remove(0);
//            for (Integer integer : list) {
//                System.out.print(integer+" ");
//            }
            int out = list.get(0);
            list.remove(0);
            list.add(out);
//            System.out.println();
        }

        System.out.println(list.get(0));

        br.close();
    }
}
