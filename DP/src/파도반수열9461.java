package DP.src;

import java.io.IOException;
import java.util.Scanner;

public class 파도반수열9461 {
    static long[] dp;
    public static void main(String[] args) throws NumberFormatException, IOException {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while(test-->0){

            int N = sc.nextInt();
            dp = new long[N+1];
            System.out.println(p(N));
        }
    }
    public static long p(int N) {
        if(N<4){
            dp[N] = 1;
            return 1;
        }
        if(dp[N]!=0){
            return dp[N];
        }
        dp[N] = p(N-2)+p(N-3);
        return dp[N];
    }

}
