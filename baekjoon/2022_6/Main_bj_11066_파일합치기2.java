package p06;
import java.util.Arrays;
import java.util.Scanner;
 
public class Main_bj_11066_파일합치기2 {
    static int T, K;
    static int[] fic;
    static int[] sum;
    static int[][] dp;
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();
 
        for(int test = 0; test < T; test++) {
             
            K = sc.nextInt();
             
            fic = new int[K+1];
            sum = new int[K+1];
            dp = new int[502][502];
             
            for(int i = 1; i <= K; i++) {
                fic[i] = sc.nextInt();
                sum[i] = sum[i-1]+ fic[i];
            }
             
            for (int i = 2; i <= K; i++)
            {
                for (int j = i - 1; j > 0; j--)
                {
                    dp[j][i] = 999999999;
                    for (int s = j; s <= i; s++)
                        dp[j][i] = Math.min(dp[j][i], dp[j][s] + dp[s + 1][i]);
      
                    dp[j][i] += sum[i] - sum[j - 1];
                }
                for(int x=0; x<7; x++) {
					
					System.out.println(Arrays.toString(dp[x]));
				}
            }
 
             
            System.out.println(dp[1][K]);
             
             
        }
         
        sc.close();
    }
 
}