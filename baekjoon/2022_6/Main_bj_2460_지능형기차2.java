package algo06;
import java.io.*;
import java.util.*;


public class Main_bj_2460_지능형기차2 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		
		int max=-1;
		int start=0;
		for(int i=0; i<10; i++) {
			
				StringTokenizer st = new StringTokenizer(br.readLine()," ");
				int out =Integer.parseInt(st.nextToken());
				int in=Integer.parseInt(st.nextToken());
				start=start-out+in;
				
				if(max<start)max=start;
				
			
		}
		
		System.out.println(max);
		br.close();

	}

}
