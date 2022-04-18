package p0417;
import java.io.*;
import java.util.*;

public class Main_bj_1003_피보나치함수 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int[] zerocall = new int[41];
		int[] onecall = new int[41];
		zerocall[0]=1;
		zerocall[1]=0;
		onecall[0]=0;
		onecall[1]=1;
		for(int i=2; i<41; i++) {
			zerocall[i]=zerocall[i-1]+zerocall[i-2];
			onecall[i] = onecall[i-1]+onecall[i-2];
		}
		int T = Integer.parseInt(br.readLine());
		for(int t=0; t<T;t++) {
			int n = Integer.parseInt(br.readLine());
			sb.append(zerocall[n]).append(" ").append(onecall[n]).append("\n");
		}
		System.out.println(sb.toString());
		
		br.close();

	}

}
