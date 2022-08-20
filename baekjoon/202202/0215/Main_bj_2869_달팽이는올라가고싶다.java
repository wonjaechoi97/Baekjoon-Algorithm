import java.io.*;
import java.util.*;import javax.swing.InputMap;
public class Main_bj_2869_달팽이는올라가고싶다 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());

		int a;
		if((V-A)%(A-B)==0) a = (V-A)/(A-B);
		else a= (V-A)/(A-B)+1;
		
		System.out.println(a+1);
		br.close();
	}
}
