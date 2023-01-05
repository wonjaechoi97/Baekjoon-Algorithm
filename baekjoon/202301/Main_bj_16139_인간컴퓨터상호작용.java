package algo202301;

import java.io.*;
import java.util.*;
public class Main_bj_16139_인간컴퓨터상호작용 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String input = br.readLine();
        int q = Integer.parseInt(br.readLine());
        int[][] map = new int[26][input.length()];
        char[] arr = input.toCharArray();

        for(int i=0; i<arr.length;i++){
            char cur = arr[i];

            // 알파벳 위치 cur-'a' 인덱스는 i
            int loc = cur-'a'; // a=0, b=1 .....
            if(i==0){ //첫번째 자리라면?
                map[loc][i] = 1; //알파벳 loc의 첫번째 자리는 1
                //알파벳 없는 곳은 다 0처리
            }else{
                map[loc][i]=map[loc][i-1]+1; //첫번째가 아니면 이전 자리에서 +1
                for(int j=0; j<26; j++){ // 이전과 동일
                    if(j==loc)continue;
                    map[j][i] = map[j][i - 1]; //이전과 동일

                }
            }

        }

        for(int i = 0; i<q; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String in = st.nextToken();
            char ch = in.charAt(0);
            int index = ch - 'a';
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            int result = 0;
            if(l==0){
                result = map[index][r];
            }else{
                result = map[index][r] - map[index][l-1];
            }
            sb.append(result).append("\n");
//            System.out.println(result);
        }
        System.out.println(sb);

//        for(int[] a : map) System.out.println(Arrays.toString(a));;

        br.close();

    }
}
