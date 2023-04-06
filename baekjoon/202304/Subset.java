package algo202304;

public class Subset {

	public static void main(String[] args) {
		int n = 5;
		
		subset(n, new boolean[n], 0);

	}
	
	static void subset(int n, boolean[] set, int cnt) {
		
		if(cnt>=n) {
			for(int i=0; i<n; i++) {
				if(set[i]) {
					System.out.print(i+1+" ");
				}
			}
			System.out.println();
			return;
		}
		
		set[cnt] = true;
		subset(n, set, cnt+1);
		set[cnt] = false;
		subset(n, set, cnt+1);
		
	}

}
