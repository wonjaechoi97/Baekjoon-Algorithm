package algo202211;

import java.io.*;
import java.util.*;
public class Solution_sw_1026_View {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int t=1; t<=10;t++){
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int sum = 0;
            int[] buildings = new int[N];
            for(int i=0; i<N; i++){
                buildings[i] = Integer.parseInt(st.nextToken());
            }
            for(int i=2; i<=N-3; i++){
                int max = 0;
                boolean check = false;
                for(int j=i-2; j<=i+2; j++){
                    if(i==j)continue;
                    if(buildings[i]<=buildings[j]){
                        check = true;
                        break;
                    }

                    if(buildings[j]>max)max=buildings[j];

                }
                if(check) continue;
                sum+=buildings[i]-max;
            }
            System.out.println("#"+t+" "+sum);
        }

    }
}
