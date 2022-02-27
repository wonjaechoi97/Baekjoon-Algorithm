package practice0227;
import java.io.*;
import java.util.*;
public class Main_bj_2605_줄세우기_대전_5반_최원재  {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N =Integer.parseInt(br.readLine());
		ArrayList<Integer> line = new ArrayList<>();
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for(int i=1;i<=N;i++) {
			int n = Integer.parseInt(st.nextToken());
			line.add(i-1-n,i);
		}
		//System.out.println(line.size());
		for(int i=0; i<N;i++) {
			sb.append(line.get(i)).append(" ");
		}
		System.out.println(sb.toString());
		br.close();
	}	
}
