package practice0307;
import java.io.*;
import java.util.*;

public class Main_bj_9012_괄호 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0; t<T; t++) {
			
			Stack<Character> sta = new Stack<>();
			
			boolean check = true;
			String str = br.readLine();
			for(int i=0; i<str.length(); i++){
				
			
				if(str.charAt(i)=='(') {
					sta.push('(');
				}else {
					if(sta.size()==0) {
						
						check = false;
						break;
					}else if(sta.peek()!='('){
						System.out.println(1);
						check = false;
						break;
					}else if(sta.pop()!='('){
						
					}
				}
			}
			if(sta.size()>0)check = false;
			
			if(check) {
				sb.append("YES").append("\n");
			}else {
				sb.append("NO").append("\n");
				
			}
			
			
			
		}
		
		System.out.println(sb.toString());
		
		
		
		br.close();

	}

}
