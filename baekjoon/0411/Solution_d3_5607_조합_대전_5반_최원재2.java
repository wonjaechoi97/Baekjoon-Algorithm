package p0411;
import java.io.*;
import java.util.*;
public class Solution_d3_5607_조합_대전_5반_최원재2 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T= Integer.parseInt(br.readLine());
		
		
		for(int t=1;t<=T;t++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int N = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			sb.append("#").append(t).append(" ").append(nCr(N,R,1234567891)).append("\n");
			
			
		}
		System.out.println(sb.toString());
		
		
		
		br.close();

	}
	static long nCr(int n, int r, int p) {
		if(r==0)return 1L;
		long fac[] = new long[n+1];
		fac[0]=1;
		for(int i=1; i<=n;i++) {
			fac[i]=fac[i-1]*i%p;
		}
		
		return (fac[n]*pow(fac[r],p-2,p)%p*pow(fac[n-r],p-2,p)%p)%p;
		
	}
	
	static long pow(long a, int r, int p) {
		if(r==0)return 1;
		else if(r==1)return a;
		if(r%2==0) {
			long tmp = pow(a,r/2,p);
			return tmp*tmp%p;
		}
		long tmp = pow(a,r-1,p);
		return tmp*a%p;
	}

}
