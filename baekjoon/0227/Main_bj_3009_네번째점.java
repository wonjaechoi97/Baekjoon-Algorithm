package practice0227;
import java.io.*;
import java.util.*;
public class Main_bj_3009_네번째점 {

	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] x = new int[2][2];
		int[][] y = new int[2][2];
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int xx = Integer.parseInt(st.nextToken());
		int yy = Integer.parseInt(st.nextToken());
		x[0][0]=xx;
		x[0][1]=1;
		y[0][0]=yy;
		y[0][1]=1;
		st = new StringTokenizer(br.readLine()," ");
		xx = Integer.parseInt(st.nextToken());
		yy = Integer.parseInt(st.nextToken());
		if(xx==x[0][0]) {
		x[0][1]=2;
		}else {
			x[1][0]=xx;
			x[1][1]=1;
		}
		if(yy==y[0][0]) {
			y[0][1]=2;
			}else {
				y[1][0]=yy;
				y[1][1]=1;
		}
		st = new StringTokenizer(br.readLine()," ");
		xx = Integer.parseInt(st.nextToken());
		yy = Integer.parseInt(st.nextToken());
		if(xx==x[0][0]) {
		x[0][1]++;
		}else {
			x[1][0]=xx;
			x[1][1]++;
		}
		if(yy==y[0][0]) {
			y[0][1]++;
			}else {
				y[1][0]=yy;
				y[1][1]++;
		}
		int a, b;
		if(x[0][1]==1)a=x[0][0];
		else a=x[1][0];
		if(y[0][1]==1)b=y[0][0];
		else b=y[1][0];
		//for(int[] a:x)System.out.println(Arrays.toString(a));
		//for(int[] a:y)System.out.println(Arrays.toString(a));
		System.out.println(a+" "+b);
		br.close();

	}

}
