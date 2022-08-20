import java.io.*;
import java.util.*;

public class Main_bj_1193_분수찾기 {

	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int i=1;
		int j=1;
		int d=-1;
		//i+1 j-1 반복 j가 1에 도달하면 다시 
		int sum=0;
		int cnt=1;
		for(int x=1; x<N;x++) {
			if(i==1&&d==-1) {
				i=1;
				j+=1;
				d=-d;
			}else if(j==1&d==1) {
				j=1;
				i+=1;
				d=-d;
			}else {
				i+=d;
				j-=d;
			}
		}
		System.out.println(i+"/"+j);
		br.close();
	}
}
