package practice0227;
import java.io.*;
import java.util.*;
public class Main_bj_2527_직사각형_대전_5반_최원재 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<4; i++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int x1= Integer.parseInt(st.nextToken());
			int y1= Integer.parseInt(st.nextToken());
			int p1= Integer.parseInt(st.nextToken());
			int q1= Integer.parseInt(st.nextToken());
			int x2= Integer.parseInt(st.nextToken());
			int y2= Integer.parseInt(st.nextToken());
			int p2= Integer.parseInt(st.nextToken());
			int q2= Integer.parseInt(st.nextToken());
			
		    if(p1<x2||p2<x1||q1<y2||q2<y1)sb.append("d").append("\n");
		    
		    else if((x1==p2&&y1==q2)||(p1==x2&&y1==q2)||(p1==x2&&q1==y2)||(x1==p2&&q1==y2)) {
				sb.append("c").append("\n");
				continue;
			}
		    
			else if(y1==q2&& !(p2<x1||x2>p1)) {
				sb.append("b").append("\n");
				continue;
			}
			else if(q1==y2&& !(p2<x1||x2>p1)) {
				sb.append("b").append("\n");
				continue;
			}
			else if(p2==x1&& !(y2>q1||q2<y1)) {
				sb.append("b").append("\n");
				continue;
			}
			else if(x2==p1&& !(y2>q1||q2<y1)) {
				sb.append("b").append("\n");
				continue;
			}
			else sb.append("a").append("\n");			
		}
		System.out.println(sb.toString());	
		br.close();

	}

}
