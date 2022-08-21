package practice0301;

import java.io.*;
import java.util.*;
public class Main_bj_1541_잃어버린괄호 {

	public static void main(String[] args) throws Exception{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		LinkedList<Integer> num =new LinkedList<Integer>();
		LinkedList<Character> op =new LinkedList<Character>();
		String input = br.readLine();
		for(int i=0; i<input.length();i++) {
			if(input.charAt(i)=='-'||input.charAt(i)=='+') op.add(input.charAt(i));
		}
		StringTokenizer st = new StringTokenizer(input,"+");
		while(st.hasMoreTokens()) {
			StringTokenizer st2 = new StringTokenizer(st.nextToken(),"-");
			while(st2.hasMoreTokens()) {
				num.add(Integer.parseInt(st2.nextToken()));
			}
			
		
		}
		
//		System.out.println(num.toString());
//		System.out.println(op.toString());
		boolean check=true; //아직 +가 남았는지 안남았는지 확인하는 
		
			int size = op.size();
			for(int i=size-1; i>=0; i--) {
				if(op.get(i)=='+') {
					num.add(i, num.get(i)+num.get(i+1));
					
					num.remove(i+2);
					num.remove(i+1);
					//num.remove(0);
					//System.out.println(num.toString());
					op.remove(i);
				}
			}
			//System.out.println(num.toString());
			size = op.size();
			//System.out.println(num.size());
			while(num.size()!=1) {
				num.add(0, num.get(0)-num.get(1));
				num.remove(2);
				num.remove(1);
				//System.out.println(num.toString());
			}
		
		System.out.println(num.get(0));
		
		br.close();

	}

}
