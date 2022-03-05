import java.io.*;
import java.util.*;
public class Main_bj_2477_참외밭 {

	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] dir=new int[6];
		int[] dist =new int[6];
		int maxx=0;
		int maxy=0;
		for(int i=0; i<6;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			dir[i]=Integer.parseInt(st.nextToken());
			dist[i]=Integer.parseInt(st.nextToken());
			if(dir[i]==1||dir[i]==2) {
				if(dist[i]>maxx)maxx=dist[i];
			}else{
				if(dist[i]>maxy)maxy=dist[i];
			}
		}
		int y=0;
		int x =0;
		for(int i=0; i<6; i++) {
			if(dir[i]==1||dir[i]==2) {
				if(dir[i]==dir[(i+2)%6]) {
					y=dist[(i+1)%6];
					if((dir[i]==1&&dir[(i+1)%6]==4)||(dir[i]==2&&dir[(i+1)%6]==3)) {
						x=dist[(i+2)%6];
					}else {
						x=dist[i];
					}
					break;
				}
			}			
		}
		System.out.println((maxx*maxy-x*y)*N);
	}
}
