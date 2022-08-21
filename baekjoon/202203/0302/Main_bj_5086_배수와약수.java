package practice0302;
import java.io.*;
import java.util.*;
public class Main_bj_5086_배수와약수 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(a==0)break;
			if(a>b) {
				if(a%b==0)System.out.println("multiple");
				else System.out.println("neither");
			}else {
				if(b%a==0)System.out.println("factor");
				else System.out.println("neither");
			}	
			
			
		}

	}

}
