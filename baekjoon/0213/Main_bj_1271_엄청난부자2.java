import java.io.*;
import java.math.BigInteger;
import java.util.*;
public class Main_bj_1271_엄청난부자2 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		StringBuilder sb = new StringBuilder();
		BigInteger Money =new BigInteger(st.nextToken());
		BigInteger per = new BigInteger(st.nextToken());
		sb.append(Money.divide(per)).append("\n");
		sb.append(Money.remainder(per));
		System.out.println(sb.toString());
		br.close();
	}
}
