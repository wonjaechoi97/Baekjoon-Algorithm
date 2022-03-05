import java.io.*;
import java.util.*;

public class Main_bj_14696_딱지놀이 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int Round = Integer.parseInt(br.readLine());
		for(int t=0; t<Round;t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a= Integer.parseInt(st.nextToken());
			int[] cardA=new int[5];
			int[] cardB = new int[5];
 			for(int i=0; i<a;i++) {
				cardA[Integer.parseInt(st.nextToken())]++;
			}
 			st = new StringTokenizer(br.readLine());
 			int b= Integer.parseInt(st.nextToken());
 			char winner;
 			for(int i=0; i<b;i++) {
				cardB[Integer.parseInt(st.nextToken())]++;
			}
 			if(cardA[4]==cardB[4]) {
 				if(cardA[3]==cardB[3]) {
 					if(cardA[2]==cardB[2]) {
 						if(cardA[1]==cardB[1]) {
 							winner='D';
 						}else {
 		 					winner = cardA[1]>cardB[1]?'A':'B';
 		 				}
 					}else {
 	 					winner = cardA[2]>cardB[2]?'A':'B';
 	 				}
 				}else {
 					winner = cardA[3]>cardB[3]?'A':'B';
 				}
 			}else {
 				winner = cardA[4]>cardB[4]?'A':'B';
 			}
 			sb.append(winner).append("\n");

		}
		System.out.println(sb.toString());
		br.close();
		
	}

}
