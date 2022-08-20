import java.io.*;
import java.util.*;
public class Solution_4012_요리사_대전_5반_최원재 {
/*
 * N개의 요리재료
 * N/2개씩 나누어서 요리 
 */
static int min= Integer.MAX_VALUE;	
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input1.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine()); //테케 수
		
		for(int t=1; t<=T;t++) {
			int N = Integer.parseInt(br.readLine());
			int[][] sin = new int[N][N];
			int R = N/2; //나누어지는 재료수 조합시 고르는 재료 수 
			int[] out1= new int[R];
			ArrayList<Integer> out2= new ArrayList<Integer>();
			
			for(int i=0; i<N;i++) {
				out2.add(i);
				StringTokenizer st = new StringTokenizer(br.readLine()," ");
				for(int j = 0; j<N; j++) {
					sin[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			
			min = Integer.MAX_VALUE;
			comb(0, 0, N, R, out1, out2, sin);
			sb.append("#").append(t).append(" ").append(min).append("\n");
		}
		System.out.println(sb.toString());
				
		br.close();
	}
	
	static void comb(int start, int cnt,int N, int R,int[] out1, ArrayList<Integer>out2,int[][] sin) {
		if(cnt==R) {
			int sumA=0;
			int sumB = 0;		
			for(int i=0;i<R;i++) {
				for(int j=0; j<R;j++) {
					if(i==j)continue;
					sumB+=sin[out2.get(i)][out2.get(j)];
					sumA+=sin[out1[i]][out1[j]];
				}
			}
			if(Math.abs(sumA-sumB)<min)min=Math.abs(sumA-sumB);
			
			return;
		}
		
		for(int i=start;i<N;i++) {
			out1[cnt]=i;
			for(int x=0; x<out2.size();x++) {
				if(out2.get(x)==i) {
					out2.remove(x);
					break;
				}			
			}
			comb(i+1,cnt+1,N,R,out1, out2, sin);
			out2.add(i);
		}
	}
}
