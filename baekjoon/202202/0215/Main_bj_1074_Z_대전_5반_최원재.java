import java.io.*;
import java.util.*;
public class Main_bj_1074_Z_대전_5반_최원재 {

	static long count=0;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N =Integer.parseInt(st.nextToken());
		int size = (int)(Math.pow(2, N));
		
		int r =Integer.parseInt(st.nextToken());
		int c =Integer.parseInt(st.nextToken());

		find(r, c, size);
		br.close();
		
	}
	
		
	public static void find(int i, int j, int size) {
		if(size==1) {
			System.out.println(count);
			return;
		}
		long a = (size/2)*(size/2);
		
		if(i<size/2&&j<size/2) {
			
			find( i,j,size/2);
		}else if(i<size/2) {
			count+=a;
			
			find(i, j-size/2, size/2);
		}else if(j<size/2) {
			
			count+=2*a;
	
			find(i-size/2,j,size/2);
		}else {
			
			count+=3*a;
			
			find(i-size/2,j-size/2,size/2);
			
		}
	}

}
