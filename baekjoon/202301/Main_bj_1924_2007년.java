package algo202301;


import java.io.*;
import java.util.*;
public class Main_bj_1924_2007년 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        int[] month = new int[13];
        month[1]=month[3]=month[5]=month[7]=month[8]=month[10]=month[12]=31;
        month[4]=month[6]=month[9]=month[11]=30;
        month[2]=28;

        //기준은 1월 0일 일요일
        String[] date = new String[7];
        date[0]="SUN";
        date[1]="MON";
        date[2]="TUE";
        date[3]="WED";
        date[4]="THU";
        date[5]="FRI";
        date[6]="SAT";
        int total=0;
        for(int i=0; i<x; i++){
            total+=month[i];
        }
        total += y;

        System.out.println(date[total%7]);
        br.close();
    }
}
