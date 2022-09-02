import java.util.*;
import java.io.*;

public class Main_bj_1076_저항 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String first = br.readLine();
        String second = br.readLine();
        String third = br.readLine();

        ArrayList<String> list = new ArrayList<>();
        list.add("black"); // index = 0
        list.add("brown"); // index = 1
        list.add("red"); // index = 2
        list.add("orange"); // index = 3
        list.add("yellow"); // index = 4
        list.add("green"); // index = 5
        list.add("blue"); // index = 6
        list.add("violet"); // index = 7
        list.add("grey"); // index = 8
        list.add("white"); // index = 9

        long answer = 0L;
        answer += list.indexOf(first)*10;
        answer += list.indexOf(second);
        answer *= Math.pow(10, list.indexOf(third));
        

        System.out.println(answer);
        
        br.close();
    }
}
