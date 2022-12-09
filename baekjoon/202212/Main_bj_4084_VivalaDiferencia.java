package algo202212;

import java.io.*;
import java.util.*;
public class Main_bj_4084_VivalaDiferencia {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int[] arr = new int[4];
            arr[0] = Integer.parseInt(st.nextToken());
            arr[1] = Integer.parseInt(st.nextToken());
            arr[2] = Integer.parseInt(st.nextToken());
            arr[3] = Integer.parseInt(st.nextToken());
            if (0 == arr[0] && arr[0] == arr[1] && arr[1] == arr[2] & arr[2] == arr[3]) {
                break;
            }
            int cnt = 0;
            while (true) {

//                System.out.println(Arrays.toString(arr));
                if (0 != arr[0] && arr[0] == arr[1] && arr[1] == arr[2] & arr[2] == arr[3]) {
                    sb.append(cnt).append("\n");
                    break;
                }
                int a = arr[0];
                arr[0] = Math.abs(arr[1] - arr[0]);
                arr[1] = Math.abs(arr[2] - arr[1]);
                arr[2] = Math.abs(arr[3] - arr[2]);
                arr[3] = Math.abs(arr[3] - a);

                cnt++;
            }

        }
        System.out.println(sb.toString());
    }

}
