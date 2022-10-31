package algo202210;
import java.io.*;
import java.util.*;
public class Main_bj_2947_나무조각 {
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[5];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<5; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        while(true){
            for(int i=0; i<4; i++){
                if(arr[i]>arr[i+1]){
                    int tmp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1]=tmp;
                    System.out.println(arr[0]+" "+arr[1]+" "+arr[2]+" "+arr[3]+" "+arr[4]);
                }

            }


            boolean check = true;
            for(int i=0; i<5;i++){
                if(arr[i]!=i+1){
                    check = false;
                    break;
                }
            }
            if(check)break;
        }

        br.close();
    }
}
