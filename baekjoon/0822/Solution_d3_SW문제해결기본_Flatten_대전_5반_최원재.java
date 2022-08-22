import java.io.*;
import java.util.*;
public class Solution_d3_SW문제해결기본_Flatten_대전_5반_최원재 {

	//정렬을 한 후 하는 것도 좋다.
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d3_SW문제해결기본.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for(int n=0; n<10;n++) {
			int dump = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int[] arr = new int[100];
			int[] index = new int[2];
			for(int i=0; i<100;i++) {			
				arr[i]=Integer.parseInt(st.nextToken());
			}
			for(int i =0; i<dump;i++) {
				index = find(arr);
				arr[index[0]]--;
				arr[index[1]]++;			
			}
			index = find(arr);
			sb.append("#").append(n+1).append(" ").
			   append(arr[index[0]]-arr[index[1]]).append("\n");	
		}
		System.out.println(sb.toString());
	}
	
	public static int[] find(int[] arr) {
		int[] Mm = new int[2];
		int max_idx=-1;
		int min_idx=-1;
		int max=-1;
		int min = 101;
		for(int i=0; i<arr.length;i++ ) {		
			if(arr[i]>max) {
				max=arr[i];
				max_idx=i;
			}
			if(arr[i]<min) {
				min=arr[i];
				min_idx=i;
			}
		}
		Mm[0]=max_idx;
		Mm[1]=min_idx;		
		return Mm;
	}

}
