package practice0227;
import java.io.*;
import java.util.*;
public class Main_bj_2628_종이자르기_대전_5반_최원재 {
	static class comp implements Comparator<Integer>{

		@Override
		public int compare(Integer o1, Integer o2) {
			
			return o1-o2;
		}
		
	}
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		comp c = new comp();
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		
		ArrayList<Integer> garo = new ArrayList<Integer>();
		ArrayList<Integer> sero = new ArrayList<Integer>();
		ArrayList<Integer> Ngaro = new ArrayList<Integer>();
		ArrayList<Integer> Nsero = new ArrayList<Integer>();
		int N = Integer.parseInt(br.readLine());
		for(int i=0; i<N;i++) {
			st = new StringTokenizer(br.readLine()," ");
			int dir = Integer.parseInt(st.nextToken());
			if(dir == 0) {
				garo.add(Integer.parseInt(st.nextToken()));
			}else {
				sero.add(Integer.parseInt(st.nextToken()));
			}
		}
	
		sero.sort(c);
		garo.sort(c);
		garo.add(h);
		sero.add(w);
	
		int s= sero.size();
		Nsero.add(sero.get(0));
		for(int i=1; i<s;i++) {
			
			Nsero.add(sero.get(i)-sero.get(i-1));
			//System.out.println("?");
		}
		s= garo.size();
		Ngaro.add(garo.get(0));
		for(int i=1; i<s;i++) {
			Ngaro.add(i, garo.get(i)-garo.get(i-1));
		}
	
		Nsero.sort(c);
		Ngaro.sort(c);
		
		System.out.println(Nsero.get(sero.size()-1)*Ngaro.get(garo.size()-1));
		
		br.close();
	}
}
