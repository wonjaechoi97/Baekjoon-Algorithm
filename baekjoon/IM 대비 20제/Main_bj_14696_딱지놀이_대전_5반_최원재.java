package practice0227;
import java.io.*;
import java.util.*;
public class Main_bj_14696_딱지놀이_대전_5반_최원재 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		for(int i=0; i<N;i++) {
			int[] A = new int[5];
			int[] B = new int[5];
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int AN = Integer.parseInt(st.nextToken());
			for(int j=0; j<AN; j++) {
				int shape = Integer.parseInt(st.nextToken());
				A[shape]++;
			}
			st = new StringTokenizer(br.readLine()," ");
			int BN = Integer.parseInt(st.nextToken());
			for(int j=0; j<BN; j++) {
				int shape = Integer.parseInt(st.nextToken());
				B[shape]++;
			}			
			if(A[4]!=B[4]) {
				if(A[4]>B[4])sb.append("A").append("\n");
				else sb.append("B").append("\n");
			}else if(A[3]!=B[3]) {
				if(A[3]>B[3])sb.append("A").append("\n");
				else sb.append("B").append("\n");
			}else if(A[2]!=B[2]) {
				if(A[2]>B[2])sb.append("A").append("\n");
				else sb.append("B").append("\n");
			}else if(A[1]!=B[1]) {
				if(A[1]>B[1])sb.append("A").append("\n");
				else sb.append("B").append("\n");
			}else {
				sb.append("D").append("\n");
			}
			
		}
		System.out.println(sb.toString());
	}
}
