package algo202210;
import java.io.*;
import java.util.Scanner;

public class Main_bj_11718_그대로출력하기 {
    public static void main(String[] args) throws Exception{
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            System.out.println(sc.nextLine());
        }
        sc.close();
    }
}
