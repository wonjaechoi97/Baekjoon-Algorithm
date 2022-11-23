package algo202211;

import java.io.*;
import java.util.*;
public class Main_bj_1038_감소하는수2 {
    static int cnt;
    static int N;
    static boolean check;
    static ArrayList<Integer> list;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        if(N==0){
            System.out.println(0);
        } else if(N<=10){
            System.out.println(N);
        }else {
            for(int i=1;i<10;i++){
                list.add(i);
            }
            for(int i=2; i<8; i++){

                solve(0,i, 0,new int[i]);
                if(cnt>N)break;
            }
//            System.out.println(list.size());

            if(cnt<N){
                System.out.println(list.size());
                for(int i=0; i<list.size();i++) System.out.print(i+1+" "+list.get(i)+" ");
                System.out.println();
                System.out.println(-1);
            }else {
                Collections.sort(list);
//                for(int n : list) System.out.print(n+" ");
//                System.out.println();
                System.out.println(list.get(N-1));
            }
        }

        br.close();

    }
    static void solve( int start,int jari,  int count, int[] selected){
        if(count==jari){
            cnt++;
            StringBuilder sb = new StringBuilder();
            for(int i=1; i<=selected.length; i++){
                sb.append(selected[selected.length-i]);
            }
            int n = Integer.parseInt(sb.toString());
//            System.out.println(n);
//            System.out.println(Arrays.toString(selected));
            list.add(Integer.parseInt(sb.toString()));
            return;
        }
        for(int i=start; i<=9; i++){
            selected[count] = i;
            solve(i+1,jari,count+1, selected);
        }
    }
}
