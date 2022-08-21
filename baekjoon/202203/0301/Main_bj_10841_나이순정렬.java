package practice0228;
import java.io.*;
import java.util.*;
public class Main_bj_10841_나이순정렬 {
	static class person implements Comparable<person>{
		int age;
		String name;
		@Override
		
		public int compareTo(person o) {
			
			return this.age-o.age;
		}
		public person(int age, String name) {
			super();
			this.age = age;
			this.name = name;
		}
		
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		person[] p = new person[N];
		for(int i=0; i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int a = Integer.parseInt(st.nextToken());
			String na = st.nextToken();
			p[i]=new person(a, na);
		}
		Arrays.sort(p);
		for(int i=0; i<N; i++) {
			sb.append(p[i].age).append(" ").append(p[i].name).append("\n");
		}
		System.out.println(sb.toString());
		br.close();

	}

}
