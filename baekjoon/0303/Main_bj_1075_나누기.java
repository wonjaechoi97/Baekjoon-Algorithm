package practice0303;
import java.io.*;
import java.util.*;
public class Main_bj_1075_나누기 {

	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int A = Integer.parseInt(br.readLine());
		int B = Integer.parseInt(br.readLine());
		int result = 0;
		int nA = (A/100)*100;
		for(int i=nA; i<nA+100; i++) {
			if(i%B==0) {
				result = i-nA;
				break;
			}
		}
		
		if(result<10)System.out.println("0"+result);
		else System.out.println(result);

	}

}
