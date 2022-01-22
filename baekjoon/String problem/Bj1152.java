package baek;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Bj1152 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String S= br.readLine();
		
		String[] str =S.split(" ");
		int blank=0;
		for(int i=0; i< str.length;i++) {
			if(str[i].isEmpty())blank++;
			
		}
		int total = str.length;
		bw.write(""+(total-blank));
		br.close();
		bw.close();

	}

}
