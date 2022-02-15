import java.io.*;
import java.util.*;
public class Main_bj_2480_주사위세개 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st =new StringTokenizer(br.readLine()," ");
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int prize=0;
		if(A==B&&B==C) {
			prize = 10000+A*1000;
		}else if(A==B||A==C) {
			prize = 1000+A*100;
		}else if(B==C) {
			prize = 1000+B*100;
		}else {
			if(A>B&&A>C) {
				prize = A*100;
			}else if(B>C&&B>A) {
				prize = B*100;
			}else if(C>B&&C>A) {
				prize = C*100;
			}		
		}
		System.out.println(prize);	
		br.close();
	}

}
