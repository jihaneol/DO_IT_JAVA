package DP.src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_스티커_9465 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        int test = Integer.valueOf(br.readLine());
        while(test-->0){
            int N = Integer.valueOf(br.readLine());

            int map[][] = new int[2][N];
            int dp[][] = new int[3][N+1];
            dp[0][1] = map[0][1];
            dp[1][1] = map[1][1];
            for(int i=0; i<2; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++){
                    map[i][j] = Integer.valueOf(st.nextToken());
                }
            }

            for(int i=1; i<N+1; i++){
                dp[0][i] = dp[1][i-1]+map[0][i-1];
                dp[1][i] = dp[0][i-1]+map[1][i-1];
            }
            int max = Math.max(dp[0][N-1], Math.max(dp[1][N], dp[2][N]));
            sb.append(max).append('\n');

        }
        System.out.println(sb);

    }
}
