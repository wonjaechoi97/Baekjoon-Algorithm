package p07;

import java.io.*;
import java.util.*;

public class Main_bj_1107_리모컨_개선 {
	static int min;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		/*
		 * 중복 순열 사용 min = 원하는 채널 - 현재 채널(100)저장 원하는 채널 자리 수 파악 length 로 구하면 될듯(한자리 수 아래도
		 * 고려해야함) 가장 높은자리의 수 부터 채워 나갈 것 n자리 수를 모두 구하면 (abs(원하는 채널 - 중복 순열로 구한 값)+1) 과
		 * min 비교해서 더 작은 값을 min에 넣기
		 * 
		 */
		String in = br.readLine();
		int len = in.length(); // 숫자 자릿수
		int want = Integer.parseInt(in);
		min = Math.abs(want - 100);
		int noUse = Integer.parseInt(br.readLine());
		if (noUse != 0) {
			int[] noUseList = new int[noUse];
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < noUse; i++) {
				noUseList[i] = Integer.parseInt(st.nextToken());
			}

			for (int i = 0; i <= 1000000; i++) {
				boolean check = false;

				String i_string = Integer.toString(i);
				// System.out.println(i);
				for (int j = 0; j < i_string.length(); j++) {
					// System.out.println(i);
					for (int k = 0; k < noUseList.length; k++) {
						if (noUseList[k] == i_string.charAt(j) - '0') {
							// System.out.println(i);
							check = true;
							break;
						}
					}
				}

				if (!check) {
					int result = Math.abs(i - want) + i_string.length();
					if (result < min) {
						// System.out.println(i);
						// System.out.println(result);
						min = result;
					}
				}

				// System.out.println(i+" : "+i_string);

			}
		}else {
			if(in.length()<min)min=in.length();
		}

		System.out.println(min);

		br.close();

	}

}
