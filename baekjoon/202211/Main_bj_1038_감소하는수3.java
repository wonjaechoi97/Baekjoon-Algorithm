package algo202211;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main_bj_1038_감소하는수3 {
    static int cnt;
    static int N;
    static boolean check;
    static ArrayList<Integer> list;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
//        if(N==0){
//            System.out.println(0);
//        } else if(N<=10){
//            System.out.println(N);
//        }else {
//            for(int i=1;i<10;i++){
//                list.add(i);
//            }
//            for(int i=2; i<8; i++){
//
//                solve(0,i, 0,new int[i]);
//                if(cnt>N)break;
//            }
////            System.out.println(list.size());
//
//            if(cnt<N){
//                System.out.println(list.size());
//                for(int i=0; i<list.size();i++) System.out.print(i+1+" "+list.get(i)+" ");
//                System.out.println();
//                System.out.println(-1);
//            }else {
//                Collections.sort(list);
////                for(int n : list) System.out.print(n+" ");
////                System.out.println();
//                System.out.println(list.get(N-1));
//            }
//        }
        for(int i=1; i<=9; i++){
            solve(i,i,1);
        }

        Collections.sort(list);
        if(N<=10){
            System.out.println(N);
        }else if(N<1022){
            System.out.println(list.get(N-1));
        }else if(N==1022){
            System.out.println("9876543210");
        }else{
            System.out.println(-1);
        }

        br.close();

    }
    static void solve( int num, int ex, int idx){
        if(idx==10)return;
        list.add(num);
//        System.out.println(idx+"  "+num);
        for(int i=0; i<ex; i++){
            solve(num*10+i, i,idx+1 );
        }
    }
}
