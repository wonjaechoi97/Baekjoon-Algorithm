package baek;


import java.io.*;
import java.util.*;

public class Bj2309_일곱난쟁이 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int[] nanjang = new int[9];

		List<Integer> correct = new ArrayList<>();
		int sum = 0;
		for(int i=0; i<9;i++) {
			nanjang[i]=Integer.parseInt(br.readLine());
		}
		
		for(int i=0; i<9;i++) {
			sum+=nanjang[i];
		}
		
	end: for(int i=0;i<8;i++) {
			
			for(int j=i+1;j<9;j++) {
				int res = sum;
				res=res-nanjang[i]-nanjang[j];
				if(res == 100) {
					for(int x=0;x<9;x++) {
						if(x!=i&&x!=j) {
							correct.add(nanjang[x]);
						}
						
					}
					break end;
				}
			}
		}
		correct.sort(Comparator.naturalOrder());
		for(int i=0; i<7;i++) {
			sb.append(correct.get(i)).append("\n");
		}
		
		sb.setLength(sb.length()-1);
		System.out.println(sb.toString());
	}

}
