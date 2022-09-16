package algo202209;
import java.io.*;
import java.util.*;
public class Main_bj_5618_공약수 {
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int[] nums = new int[N];
        int max = 0;
        int min = Integer.MAX_VALUE;

        for(int i=0; i<N; i++){
            int in = Integer.parseInt(st.nextToken());
            nums[i] = in;
            if(in > max) max = in;
            if(in<min) min = in;
        }

//        System.out.println(Arrays.toString(nums));
//        System.out.println(max + " : "+ min);
//        sb.append(1).append("\n");
        here:for(int i=1; i<=min; i++){
            for(int j=0; j<N; j++){
                if(nums[j]%i!=0) continue here;
            }
            sb.append(i).append("\n");
        }
        System.out.println(sb.toString());
        br.close();
    }
}
