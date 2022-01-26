package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Bj2562Array1d {
	

	public static void main(String[] args) throws Exception {
		int max = 0;
		int max_idx=-1;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] nums = new int[9];
		
		for(int i =0; i<9;i++) {
			nums[i]=Integer.parseInt(br.readLine());
		}
		
		for(int i=0; i<9;i++) {
			if(nums[i]>max) {
				max=nums[i];
				max_idx=i;
			}
		}
		System.out.println(max);
		System.out.println(max_idx+1);

	}

}
