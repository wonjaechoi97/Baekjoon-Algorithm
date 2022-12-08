package algo202212;

import java.io.*;
import java.util.*;
public class Main_bj_1672_DNA해독 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        char[] chArr = br.readLine().toCharArray();
        int curLen = N;
        char[][] map = {{'A', 'C', 'A', 'G'},
                {'C', 'G', 'T', 'A'},
                {'A', 'T', 'C', 'G'},
                {'G', 'A', 'G', 'T'}};

        while(true){
            if(curLen==1)break;
            int i = 0;
            int j = 0;
            if(chArr[curLen-2]=='A'){
                i = 0;
            }else if(chArr[curLen-2]=='G'){
                i = 1;
            }else if(chArr[curLen-2]=='C'){
                i = 2;
            }else if(chArr[curLen-2]=='T'){
                i = 3;
            }

            if(chArr[curLen-1]=='A'){
                j = 0;
            }else if(chArr[curLen-1]=='G'){
                j = 1;
            }else if(chArr[curLen-1]=='C'){
                j = 2;
            }else if(chArr[curLen-1]=='T'){
                j = 3;
            }
            chArr[curLen-2]=map[i][j];
            curLen--;

        }
        System.out.println(chArr[0]);
        br.close();
    }
}
