package algo202210;
import java.util.*;
import java.io.*;
public class Main_bj_14425_문자열집합 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0; i<N; i++){
            map.put(br.readLine(),1);
        }
        int cnt = 0;
        for(int i=0; i<M; i++){
            if(map.containsKey(br.readLine())) cnt++;
        }
        System.out.println(cnt);
        br.close();

    }
}
