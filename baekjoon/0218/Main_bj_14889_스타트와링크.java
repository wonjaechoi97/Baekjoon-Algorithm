import java.io.*;
import java.util.*;
public class Main_bj_14889_스타트와링크 {

	static int min;	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
			
			int N = Integer.parseInt(br.readLine());
			int[][] sin = new int[N][N];
			int R = N/2; //나누어지는 재료수 조합시 고르는 재료 수 
			int[] out1= new int[N];
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
		
		
		System.out.println(min);
				
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