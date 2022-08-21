package practice0228;
import java.io.*;
import java.util.*;
public class Main_bj_2108_통계학 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int[] list = new int[8001];
		int N = Integer.parseInt(br.readLine());
	
		int sum = 0;
		
		for(int i=0; i<N;i++) {
			int n  =Integer.parseInt(br.readLine());
			sum+=n;
			list[n+4000]++;
		}
		int cnt = 0;
		int center=0;
		for(int i=0; i<=8000;i++) {
			if(list[i]==0)continue;
			cnt+=list[i];
			if(cnt>=N/2+1) {
				center = i-4000;
				break;
			}
		}
		int min=0;
		int max=0;
		for(int i=0; i<=8000;i++) {
			if(list[i]==0)continue;
			if(list[i]!=0) {
				min = i-4000;
				break;
			}
		}
		for(int i=8000; i>=0;i--) {
			if(list[i]==0)continue;
			if(list[i]!=0) {
				max = i-4000;
				break;
			}
		}
		int avg = (int)Math.round((double)sum/N);
		
	
		int range = max - min;
		

		int max_freq = 0;;
		
		int freq_val=0;
		boolean check = false;
		for(int i=0; i<=8000;i++) {
			if(list[i]==0)continue;
			if(list[i]>max_freq) {
				max_freq = list[i];
				freq_val = i-4000;
				check = true;
			}else if(max_freq==list[i]&&check) {
				freq_val = i-4000;
				check = false;
			}
			
		}
		
		sb.append(avg).append("\n");
		sb.append(center).append("\n");
		sb.append(freq_val).append("\n");
		sb.append(range);
		
		System.out.println(sb.toString());
		br.close();

	}

}