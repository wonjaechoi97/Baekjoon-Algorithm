package practice0228;
import java.io.*;
import java.util.*;
public class Main_bj_1181_단어정렬2 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		String[] str = new String[N];
		
		
		for(int i=0; i<N; i++) {
			str[i] = br.readLine();
			
		}
	
		
		Arrays.sort(str,new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				int r= o1.length()-o2.length();
				if(r==0)r=o1.compareTo(o2);
				return r;
			}
		});
		sb.append(str[0]).append("\n");
		for(int i=1; i<N; i++) {
			if(!str[i].equals(str[i-1]))sb.append(str[i]).append("\n");
		}
		System.out.println(sb.toString());
		br.close();

	}

}
