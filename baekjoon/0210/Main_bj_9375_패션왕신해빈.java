import java.io.*;
import java.util.*;
public class Main_bj_9375_패션왕신해빈 {
	
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int t =0 ; t<T;t++) {
			int N = Integer.parseInt(br.readLine());
			List<Dress> list = new ArrayList<Dress>();
			int sum=0;
			for(int x = 0 ;x < N; x++) {
				StringTokenizer st=new StringTokenizer(br.readLine()," ");	
				st.nextToken();
				String clo=st.nextToken();
				boolean dup = false;
				for(int i =0; i<list.size();i++) {
					
					if(clo.equals(list.get(i).item)) {
						list.get(i).yang++;
						dup = true;
						break;
					}				
				}
				if(!dup)list.add(new Dress(clo, 1));
			}
			sum=1;
			for(int i =0;i<list.size();i++) {
				sum*=(list.get(i).yang+1);
				
			}
			sum-=1;
			sb.append(sum).append("\n");
		}
		System.out.println(sb.toString());
		br.close();
	}

}
class Dress{
	String item;
	int yang=0;
	
	public Dress(String item, int yang) {
		this.item=item;
		this.yang=yang;
	}
}
