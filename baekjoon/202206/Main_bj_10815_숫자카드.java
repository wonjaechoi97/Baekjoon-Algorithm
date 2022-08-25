package p06;

import java.util.*;
import java.io.*;

public class Main_bj_10815_숫자카드 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		
		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < m; i++) {
			int num = Integer.parseInt(st.nextToken());
			int left = 0;
			int right = arr.length - 1;
			int mid;
			boolean check = false;
			while (left <= right) {
				mid = (left + right) / 2;
				if (arr[mid] == num) {
					check = true;
					break;
				} else if (arr[mid] > num) {
					
					right = mid - 1;
				} else {

					left = mid + 1;
				}
			}

			if (check) {
				sb.append(1 + " ");
			} else {
				sb.append(0 + " ");
			}
		}

		System.out.println(sb.toString());
		br.close();

	}

}
