package algo202210;
import java.io.*;
import java.util.*;

public class Main_bj_11721_열개씩끊어출력하기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String input = br.readLine();

        for (int i = 0; i < input.length(); i++) {
            sb.append(input.charAt(i));
            if(i%10==9) sb.append("\n");
        }
        System.out.println(sb.toString());
        br.close();
    }
}
