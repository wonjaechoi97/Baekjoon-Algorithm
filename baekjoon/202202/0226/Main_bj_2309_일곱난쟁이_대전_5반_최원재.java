package practice0226;
import java.io.*;
import java.util.*;
public class Main_bj_2309_일곱난쟁이_대전_5반_최원재 {

	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int[] input = new int[9];
		int[] result = new int[7];
		int idx1=0;
		int idx2=0;
		
		for(int i=0; i<9;i++) {
			input[i]= Integer.parseInt(br.readLine());
		}
	label:for(int i=0; i<8;i++) {
			for(int j=i+1;j<9;j++) {
				int sum=0;
				for(int k=0;k<9;k++) {
					if(k!=i&&k!=j)sum+=input[k];
				}
				
				if(sum == 100) {
					int cnt = 0;
					for(int k=0; k<9;k++) {
						if(k!=i&&k!=j) {
							result[cnt++]=input[k];
						}
					}
					break label;
				}
			}
		}
		Arrays.sort(result);
		for(int i=0; i<7; i++) {
			sb.append(result[i]).append("\n");
		}
		System.out.println(sb.toString());
	}
}
