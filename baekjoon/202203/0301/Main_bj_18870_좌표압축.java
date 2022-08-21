package practice0228;
import java.io.*;
import java.util.*;
public class Main_bj_18870_좌표압축 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N =Integer.parseInt(br.readLine());
		int[] list = new int[N];
		int[] sor = new int[N];
		HashMap<Integer, Integer> checking = new HashMap<Integer, Integer>();
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for(int i=0; i<N;i++) {
			list[i]=sor[i]= Integer.parseInt(st.nextToken());
		}
		Arrays.sort(sor);
		int cnt=0;
		for(int i=0; i<N; i++) {
			int k = sor[i];
			if(!checking.containsKey(k)) {
				checking.put(k, cnt);
				cnt++;
			}
			
			
		}
		for(int i=0; i<N;i++) {
			sb.append(checking.get(list[i])).append(" ");
		}
		System.out.println(sb.toString());
		br.close();

	}

}
