package practice0307;
import java.io.*;
import java.util.*;
public class Main_bj_10773_제로 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int K = Integer.parseInt(br.readLine());
		Stack<Integer> sta = new Stack<>();
		for(int k=0; k<K; k++) {
			int input = Integer.parseInt(br.readLine());
			if(input==0)sta.pop();
			else sta.push(input);
		}
		int sum = 0;
		for(int i=0; i<sta.size();i++) {
			sum+=sta.get(i);
		}
		System.out.println(sum);
		br.close();

	}

}
