package algo202210;
import java.io.*;
import java.util.*;
public class Main_bj_11478_서로다른부분문자열의개수 {
    static HashSet<String> set;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        set = new HashSet<>();
        String input = br.readLine();
        //두개 조합 다만 겹칠 수 있으니 set을 사용
        solve(0,0, new int[2], input.length(),input);
        System.out.println(set.size());
        br.close();
    }
    static void solve(int cur, int cnt, int[] result, int N, String input){
        if(cnt==2){
            String sub = input.substring(result[0],result[1]+1);
            set.add(sub);
//            System.out.println(sub);
            return;
        }
        for(int i=cur; i<N; i++){
            result[cnt] = i;
            solve(i, cnt+1, result, N, input);
        }
    }

}
