package algo202210;
import java.util.*;
import java.io.*;

public class Main_bj_1620_나는야포켓몬마스터이다솜 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> map = new HashMap<>();
        String[] name = new String[N];
        for(int i=0; i<N; i++){
            String input = br.readLine();
            map.put(input, i);
            name[i]=input;
        }

        for(int i=0; i<M; i++){
            String input = br.readLine();
            if(isNum(input)){
                //숫자면?
                sb.append(name[Integer.parseInt(input)-1]).append("\n");
            }else{
                sb.append(map.get(input) + 1).append("\n");
            }
        }
        System.out.println(sb.toString());
        br.close();
    }
    static boolean isNum(String input){
        try{
            Integer.parseInt(input);
        }catch(Exception e){
            return false;
        }
        return true;
    }
}
