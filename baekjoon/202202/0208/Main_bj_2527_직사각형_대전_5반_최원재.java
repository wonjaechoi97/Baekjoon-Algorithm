import java.io.*;
import java.util.*;
public class Main_bj_2527_직사각형_대전_5반_최원재 {
/*
 * 점이 -> 선 - > 면 순으로 조건
 * 조건을 찬찬히 잘 생각해보자
 * 점이 마주칠 경우 4가지
 * 선이 마주칠 경우 4가지 범위를 잘 설정해야 함.
 *
 */
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String ca;
		for(int i=0; i <4;i++ ) {
			
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int x1=Integer.parseInt(st.nextToken());
			int y1=Integer.parseInt(st.nextToken());
			int x2=Integer.parseInt(st.nextToken());
			int y2=Integer.parseInt(st.nextToken());
			int x3=Integer.parseInt(st.nextToken());
			int y3=Integer.parseInt(st.nextToken());
			int x4=Integer.parseInt(st.nextToken());
			int y4=Integer.parseInt(st.nextToken());
			
			if((x2==x3&&y2==y3)||(x2==x3&&y1==y4)||(x1==x4&&y2==y3)||(x1==x4&&y1==y4)) System.out.println("c");
			else if((x2==x3&&y2!=y3)||(x1==x4&& y2!=y3)||(x2!=x3&& y1==y4)||(x1!=x4&& y1==y4)) System.out.println("b");
			else if(x2<x3||x4<x1||y4<y1||y2<y3) System.out.println("d");
			else System.out.println("a");
			
		}
	
	}
	
}

