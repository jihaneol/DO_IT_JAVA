package 백준.src;
import java.util.Scanner;


public class 피보나치{
    public static void main(String[] arg){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int test=0; test<T; test++) {
        	int N = sc.nextInt();
        	
        	int[][] dp = new int[N+1][2];
        	fibo(N,dp);
        	// 0과 1 횟수 출력
        	System.out.println(dp[N][0]+" "+dp[N][1]);
        }
        
    }
    public static void fibo(int n,int[][] dp) {
    	if(n==1) {
    		dp[n][1]++;
    		return;
    	}else if(n==0) {
    		dp[n][0]++;
    		return;
    	}
    	
    	if(dp[n][1]!=0 || dp[n][0]!=0) {
    		return ;
    	}
    	fibo(n-1,dp);
    	fibo(n-2,dp);
    	dp[n][0] = dp[n-1][0]+dp[n-2][0];
    	dp[n][1] = dp[n-1][1]+dp[n-2][1];
    }
}