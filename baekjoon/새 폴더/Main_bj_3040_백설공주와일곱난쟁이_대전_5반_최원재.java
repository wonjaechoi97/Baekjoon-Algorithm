import java.io.*;
import java.util.*;
public class Main_bj_3040_백설공주와일곱난쟁이_대전_5반_최원재 {
	static int[] input;
	static int[] temp;
	static List<Integer> output = new ArrayList<>();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		input = new int[9];
		temp = new int[7];
		for(int i=0; i<9;i++) {
			input[i]=Integer.parseInt(br.readLine());
		}
		combination(0, 0);
		for(int i=0; i<7;i++) {
			sb.append(output.get(i)).append("\n");
		}
		System.out.println(sb.toString());
		br.close();

	}
	static void combination(int cnt, int start) {
		if(cnt==7) {			
			int sum = 0;
			for(int i=0; i<7;i++) {
				sum+=temp[i];
			}
			if (sum ==100) {	
				for(int i=0; i<7;i++) output.add(temp[i]);			
			}			
			return;
		}
		for(int i=start; i<9;i++) {
			temp[cnt]=input[i];
			combination(cnt+1,i+1);
		}	
	}
}
