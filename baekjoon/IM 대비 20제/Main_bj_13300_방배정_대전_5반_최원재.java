package practice0227;
import java.io.*;
import java.util.*;
public class Main_bj_13300_방배정_대전_5반_최원재 {

	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] stu = new int[7][2];
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int sum=0;
		int N = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		for(int i=0; i<N;i++) {
			st= new StringTokenizer(br.readLine()," ");
			int sex = Integer.parseInt(st.nextToken());
			int grade = Integer.parseInt(st.nextToken());
			stu[grade][sex]++;
		}
		for(int i=1; i<=6;i++) {
			int a = stu[i][0];
			int b= stu[i][1];
			if(a!=0) {
				if(a%k==0)sum+=a/k;
				else sum+=a/k+1;
			}
			if(b!=0) {
				if(b%k==0)sum+=b/k;
				else sum+=b/k+1;
			}
		}
		System.out.println(sum);
		br.close();

	}

}
