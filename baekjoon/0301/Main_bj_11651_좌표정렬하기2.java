package practice0228;
import java.io.*;
import java.util.*;
public class Main_bj_11651_좌표정렬하기2 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[][] coor = new int[N][2];
		
		for(int i=0; i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			coor[i][0] = Integer.parseInt(st.nextToken());
			coor[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(coor,new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				int r = o1[1]-o2[1];
				if(r==0)r=o1[0]-o2[0];
				return r;
			}
		});
		for(int i=0; i<N; i++) {
			sb.append(coor[i][0]).append(" ").append(coor[i][1]).append("\n");
		}
		
		System.out.println(sb.toString());
		br.close();

	}

}
