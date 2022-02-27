package practice0226;
import java.util.*;
import java.io.*;
public class Main_bj_1244_스위치켜고끄기_대전_5반_최원재 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[] sw = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<N;i++) {
			sw[i] = Integer.parseInt(st.nextToken());
		}
		int student = Integer.parseInt(br.readLine());
		for(int i=0; i<student; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int gender = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			if(gender==1) {
				for(int n =num-1; n<N; n+=num ) {
					if(sw[n]==0)sw[n]=1;
					else sw[n]=0;
					//System.out.println(Arrays.toString(sw));
				}
			}
			if(gender==2) {
				if(sw[num-1]==0)sw[num-1]=1;
				else sw[num-1]=0; // 우선 자기 자신부터 바꾸거
				for(int n=1; n<N/2; n++) {
					int a = num-1-n;
					int b = num-1+n;
					if(a<0||b>N-1)break;
					if(sw[a]==sw[b]) {
						if(sw[a]==0)sw[a]=sw[b]=1;
						else sw[a]=sw[b]=0;
					}else break;
					//System.out.println(Arrays.toString(sw));
				}
			}
		}
		for(int i=0; i<N;i++) {
			sb.append(sw[i]+" ");
			if((i+1)%20==0)sb.append("\n");
		}
		System.out.println(sb.toString());
		br.close();	
	}
}
