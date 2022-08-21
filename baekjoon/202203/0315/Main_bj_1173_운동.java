package swtest;
import java.io.*;
import java.util.*;
public class Main_bj_1173_운동 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken()); //운동 N 분 하려고 한다.
		int m = Integer.parseInt(st.nextToken()); //운동 N 분 하려고 한다.
		int M = Integer.parseInt(st.nextToken()); //최대 맥박 
		int T = Integer.parseInt(st.nextToken()); //맥박 증가
		int R = Integer.parseInt(st.nextToken()); //맥박 감소
		int start = m;
		int cnt=0;
		int exertime =0;
		if((m+T)>M) {
			System.out.println(-1);
		}else {
			while(true) {
				if(start+T<=M) {
					start+=T;
					exertime++;
				}else {
					start-=R;
					if(start<m)start=m;
				}
				cnt++;
				if(exertime == N)break;
			}
			System.out.println(cnt);
		}

	}

}
