package 조합.src;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_다리놓기_1010 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] dp = new int[31][31];

        // 초기화
        for(int i=0;i<31; i++){
            dp[i][0] = 1; //i 개중 1개 뽑을 경우의 개수
        }

        for(int i=1;i<31; i++){
            for(int j=1; j<=i; j++){
                dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
            }
        }


        int test = Integer.valueOf(br.readLine());

        while(test-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int k = Integer.valueOf(st.nextToken());
            int n = Integer.valueOf(st.nextToken());

            System.out.println(dp[n][k]);
        }
    }
}
