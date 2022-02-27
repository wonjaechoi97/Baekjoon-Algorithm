package practice0227;
import java.io.*;
import java.util.*;
public class Main_bj_10158_개미_대전_5반_최원재 {

	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine()," ");
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(br.readLine());
		int res_x =x+t;
		int res_y = y+t;
		//System.out.println(res_x+" "+res_y);
		res_x = res_x%(2*w);
		res_y = res_y%(2*h);
		//System.out.println(res_x+" "+res_y);
		if(res_x>w)res_x=w-res_x%w;
		if(res_y>h)res_y=h-res_y%h;
		
		System.out.println(res_x+" "+res_y);
		
		br.close();

	}

}
