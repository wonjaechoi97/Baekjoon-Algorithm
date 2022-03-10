package practice0309;
import java.io.*;
import java.util.*;
public class Main_bj_4949_균형잡힌세상 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			
			Stack<Character> sta = new Stack<>();
			boolean check= true;
			String str = br.readLine();
			if(str.length()==1)break;
			
			for(int i=0; i<str.length();i++) {
				if(str.charAt(i)=='('||str.charAt(i)=='[')sta.push(str.charAt(i));
				else if(str.charAt(i)==')') {
					if(sta.isEmpty()) {
						check = false;
						break;
					}
					else if(sta.peek()!='(') {
						check = false;
						break;
					}else {
						sta.pop();
					}
				}else if(str.charAt(i)==']') {
					if(sta.isEmpty()) {
						check = false;
						break;
					}
					else if(sta.peek()!='[') {
						check=false;
						break;
					}else {
						sta.pop();
					}
				}
			}
			
			if(sta.size()>0)check=false;
			
			if(check) {
				sb.append("yes").append("\n");
			}else {
				sb.append("no").append("\n");
				
			}
			
			
		}
		System.out.println(sb.toString());
		
		br.close();

	}

}
