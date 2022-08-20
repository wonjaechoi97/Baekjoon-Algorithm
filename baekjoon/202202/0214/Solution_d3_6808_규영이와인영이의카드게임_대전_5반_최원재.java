import java.io.*;
import java.util.*;
public class Solution_d3_6808_규영이와인영이의카드게임_대전_5반_최원재 {
	static List<Integer> gyu;
	static List<Integer> in;
	static boolean[] visited=new boolean[9];
	static int max;
	static int[] out=new int[9];
	static int in_win;
	static int gyu_win;
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());		
		for(int i=0; i<T;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			gyu = new ArrayList<Integer>(); 
			in = new ArrayList<Integer>();
			for(int j=0; j<9;j++) {
				gyu.add(Integer.parseInt(st.nextToken()));
			}
			for(int j=1;j<=18;j++) {
				in.add(j);
			}
			for(int j=0; j<9;j++) {
				in.remove(Integer.valueOf(gyu.get(j)));
			}
			in_win=0;
			gyu_win=0;
			max=-1;
			permutaion(0);
			sb.append("#").append(i+1).append(" ").append(gyu_win).append(" ").append(in_win).append("\n");			
		}		
		System.out.println(sb.toString());
	}
	static void permutaion(int cnt) {
		if(cnt==9) {
			int in_sum=0;
			int gyu_sum =0;
			for(int i=0;i<9;i++) {
				if(gyu.get(i)>out[i]) {
					gyu_sum+=(gyu.get(i)+out[i]);
				}else {
					in_sum+=(gyu.get(i)+out[i]);
				}
			}
			if(gyu_sum>in_sum)gyu_win++;
			else in_win++;
			return;
		}
		for(int i=0; i<9;i++) {
			if(visited[i])continue;
			visited[i]=true;
			out[cnt]=in.get(i);
			permutaion(cnt+1);
			visited[i]=false;			
		}
	}
}
