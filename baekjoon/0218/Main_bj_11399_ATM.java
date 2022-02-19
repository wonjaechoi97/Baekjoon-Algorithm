import java.io.*;
import java.util.*;
public class Main_bj_11399_ATM {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for(int i=0; i<N; i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		int sum = 0;
		for(int i=1;i<N;i++) {
			arr[i]=arr[i-1]+arr[i];
		}
		for(int i=0;i<N;i++) {
			sum+=arr[i];
		}
		
		System.out.println(sum);
		br.close();
	}
}
