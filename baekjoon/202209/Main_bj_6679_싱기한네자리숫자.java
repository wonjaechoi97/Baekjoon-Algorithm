package algo202209;
import java.io.*;
import java.util.*;
public class Main_bj_6679_싱기한네자리숫자 {
    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        for(int i=1000; i<=9999; i++){
            //10진수 걍 i
            int tenjin = 4+i;

            //12진수
            int num = i;
            String ans12 = "";
            while (true){
                ans12 = num%12 + ans12;
                num /=12;
                if(num==0){
                    break;
                }
            }
            int twelvejin = Integer.parseInt(ans12)+ans12.length();

            //16진수
            num = i;
            String ans16 = "";
            while (true){
                ans16 = num%16 + ans16;
                num /=16;
                if(num==0){
                    break;
                }
            }
            int sixteenjin = Integer.parseInt(ans16) + ans16.length();
            if(i==2992) {
//                System.out.println();
                System.out.println(tenjin+" "+twelvejin+" "+sixteenjin);
            }


            if(tenjin == twelvejin && twelvejin == sixteenjin){
                sb.append(i).append("\n");
            }




        }
        System.out.println(sb.toString());
    }
}
