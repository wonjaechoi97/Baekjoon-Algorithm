import java.io.*;
import java.util.*;
public class Main_jo_1828_냉장고_대전_5반_최원재 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Sample[] samples = new Sample[N];
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			samples[i]=new Sample(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
						
		}
		Arrays.sort(samples);

		int last = samples[0].high;
		int count=1;
		for(int i=1; i<N;i++) {
			if(last<samples[i].low) {
				count++;
				last = samples[i].high;
			}
		}
		System.out.println(count);
		br.close();

	}
	static class Sample implements Comparable<Sample>{
		int low, high;

		public Sample(int low, int high) {
			super();
			this.low = low;
			this.high = high;
		}

		@Override
		public int compareTo(Sample o) {
			
			return this.high!=o.high?this.high-o.high:this.low-o.low;
		}
			
	}
}
