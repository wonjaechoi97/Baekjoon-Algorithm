import java.io.*;
import java.util.*;
public class Main_bj_16637_괄호추가하기 {
	static ArrayList<Integer> num;
	static ArrayList<Character>oper;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		char[] ch = br.readLine().toCharArray();
		for(int i = 0 ; i<N;i++) {
			if(0<=ch[i]-'0'&&ch[i]-'0'<=9) {
				num.add(ch[i]-'0');
			}else oper.add(ch[i]);
		}
		
	}
	public static int caculate(int a, int b, char op) {
		if(op == '+') {
			return a+b;
		}else if(op == '-') {
			return a-b;
		}else return a*b;
		
	}

}
