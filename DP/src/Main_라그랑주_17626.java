package DP.src;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_라그랑주_17626 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int find = sc.nextInt();
        int dp[] = new int[find+1];
        dp[0] = 0;
        dp[1] = 1;

        for(int i =2; i<=find; i++){
            int min = 5;
            for(int j=1; j*j<=i; j++){
                min = Math.min(min,dp[i-j*j]);
            }
            dp[i] = min+1;
        }

        System.out.println(dp[find]);


    }

//    public static void dfs(int sum, int depth, int find) {
//        if(depth>4) return;
//        if (sum == find) {
//            answer = Math.min(depth,answer);
//            return;
//        }
//        for (int i = (int) Math.sqrt(find); i>0; i--) {
//            if(sum+i*i>find) continue;
//            dfs(sum + i * i, depth + 1, find);
//        }
//
//    }

}
