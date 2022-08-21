package practice0302;
import java.io.*;
import java.util.*;
public class Main_bj_13305_주유소 {

	public static void main(String[] args) throws Exception{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] distance = new int[N-1];
		int[] price = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for(int i=0; i<N-1; i++) {
			distance[i]=Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine()," ");
		for(int i=0; i<N; i++) {
			price[i]=Integer.parseInt(st.nextToken());
		}
		int left=0;
		int right=1;
		long sum = 0;
		while(right!=N) {
			
			if(price[left]<=price[right]) {
				sum+=(long)price[left]*distance[right-1];
				//System.out.println(left+" "+right+" "+sum);
				right++;
			}else {
				sum+=(long)price[left]*distance[right-1];
				//System.out.println(left+" "+right+" "+sum);
				left=right;
				right++;
				
			}
			
		}
		System.out.println(sum);
				
		br.close();

	}

}
