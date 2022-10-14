package algo202210;

import java.io.*;
import java.util.*;
public class Main_bj_3003_킹퀸룩비숍나이트폰 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        sb.append(1 - Integer.parseInt(st.nextToken())).append(" ");
        sb.append(1 - Integer.parseInt(st.nextToken())).append(" ");
        sb.append(2 - Integer.parseInt(st.nextToken())).append(" ");
        sb.append(2 - Integer.parseInt(st.nextToken())).append(" ");
        sb.append(2 - Integer.parseInt(st.nextToken())).append(" ");
        sb.append(8 - Integer.parseInt(st.nextToken()));
        System.out.println(sb.toString());
        br.close();

    }
}
