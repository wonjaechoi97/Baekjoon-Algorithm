import java.util.*;
import java.io.*;

public class Main_bj_1244_스위치켜고끄기_대전_5반_최원재 {

	public static void main(String[] args) throws Exception{
		//System.setIn(new FileInputStream("res/input_bj_1244.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int len=Integer.parseInt(br.readLine());
		int[] sw = new int[len];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<len;i++) {
			
			sw[i]=Integer.parseInt(st.nextToken());
		}
		int std = Integer.parseInt(br.readLine());
		for(int i =0; i<std;i++) {
			st=new StringTokenizer(br.readLine());
			int gender =Integer.parseInt(st.nextToken());
			int num =Integer.parseInt(st.nextToken());
			if(gender ==1) {
				int n=1;
				while(true) {
					
					if(n*num-1<len) {
						sw[n*num-1]= sw[n*num-1]==0?1:0; 
					n++;
					}else break;
				}
			}
			if(gender == 2) {
				int n = 2;
				sw[num-1]=sw[num-1]==0?1:0;
				while(true) {
				if(num-n>=0&&num-2+n<len&&sw[num-n]==sw[num-2+n]) {
					sw[num-n]=sw[num-n]==0?1:0;
					sw[num-2+n]=sw[num-n];
					n++;
				}else break;
				}
			}
			
		}
		
		for(int i =0; i<len; i++) {
			System.out.print(sw[i]+" ");
			if((i+1)%20==0)System.out.println();
		}
		br.close();
	}

}
