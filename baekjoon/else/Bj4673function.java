package baek;

public class Bj4673function {

	public static void main(String[] args) {
		int[] notself =new int[10000];
		for(int i = 1; i<=10000;i++) {
			int x= selfnumber(i);
			if(x<=10000) {
			//System.out.println(x);
			notself[x-1]++;
			}
			
		}
		for(int i=0; i<10000;i++) {
			if(notself[i]==0) System.out.println(i+1);
		}

	}
	
	public static int selfnumber(int n) {
		int total = n;
		while(n!=0) {
			total+=n%10;
			n/=10;
			
		}
		return total;
	}

}
