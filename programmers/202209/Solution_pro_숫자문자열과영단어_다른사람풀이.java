package algo202209;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_pro_숫자문자열과영단어_다른사람풀이 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s  = br.readLine();


        String[] numbers = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        for(int i=0; i<=9; i++){
            s = s.replaceAll(numbers[i], Integer.toString(i));
        }
        System.out.println(Integer.parseInt(s));

        br.close();

    }


}
