package algo202211;
import java.io.*;
import java.util.*;
public class Main_bj_1543_문서검색 {
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input  = br.readLine();
        char[] inputArr = input.toCharArray();
        String comp = br.readLine();
        char[] compArr = comp.toCharArray();


        int cnt = 0;
//        System.out.println(input.length()-comp.length()+1);
        here:for(int i = 0; i<input.length()-comp.length()+1; i++){
//            System.out.println(i);
            for(int j=0; j<comp.length(); j++){
                if(inputArr[i+j]!=compArr[j]){
                    continue here;
                }
            }
            //System.out.println(i);
            i+=comp.length()-1;
            cnt++;
        }
        System.out.println(cnt);
        br.close();
    }
}
