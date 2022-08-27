import java.io.*;
import java.util.*;
public class Solution_d4_1223_계산기2_대전_5반_최원재 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Stack<Integer> stack = new Stack<>();
		Queue<Character> queue = new ArrayDeque<Character>();	
		for(int i = 1 ; i<= 10 ; i++) {
			boolean plus = false;
			int ti = 0;
			int N=Integer.parseInt(br.readLine());
			String str = br.readLine();
			for(int x=0;x<N;x++) {
				if(str.charAt(x)!='+'&&str.charAt(x)!='*') {
					queue.add(str.charAt(x));
					if(x==N-1) {
						for(int k =0; k<ti;k++)queue.add('*');
						if (plus == true)queue.add('+');
					}
				}else if(str.charAt(x)=='+') {
					for(int k =0; k<ti;k++)queue.add('*');
					ti = 0;
					if (plus == false)plus = true;
					else {	
						queue.add('+');
						plus=true;
					}	
				}else {
					ti++;
				}
			}
			for(int x = 0 ; x<N;x++) {
				char out = queue.poll();
				if(out!='+'&&out!='*') {
					stack.add(out-'0');
				}else {
					int a = stack.pop();
					int b = stack.pop();
					if(out=='*')stack.add(((a*b)));
					else stack.add((a+b));
				}
			}
			sb.append("#").append(i);
			sb.append(" ").append(stack.pop()).append("\n");
		}
		System.out.println(sb.toString());
		br.close();
	}
}
