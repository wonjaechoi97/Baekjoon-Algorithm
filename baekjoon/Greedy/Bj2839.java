package baek;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Bj2839 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N =Integer.parseInt(br.readLine());
		int bong = -1;
		
		while(true) {
			if(N<5&&N%5!=0&&N%3!=0) {
				bong=-1;
				break;
			}
			else {
				int n5=N/5;
				while(n5!=-1) {
					if(n5==0) {
						if(N%3==0) {
							bong=N/3;
							break;
						}
					}
					if((N-n5*5)%3==0) {
						bong = n5+(N-n5*5)/3;
						break;
					}
					n5--;	
				}
			}
			break;
		}
		bw.write(""+bong);
		br.close();
		bw.close();

	}

}
