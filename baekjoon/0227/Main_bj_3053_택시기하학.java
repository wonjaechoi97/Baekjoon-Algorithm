package practice0227;
import java.io.*;
import java.util.*;
public class Main_bj_3053_택시기하학 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int r = Integer.parseInt(br.readLine());
		
		double circle = r*r*Math.PI;
		double taxi =r*r*2;
		System.out.printf("%6f\n",circle);
		System.out.printf("%6f",taxi);
		br.close();

	}

}
