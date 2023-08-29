package DP.src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1. 계단을 오를 때 한 계단, 또는 두 계단을 오를 수 있다.
 * <p>
 * 2. 연속된 3개의 계단을 밟으면 안된다. (즉, 한 계단씩 올라갈 때 최대 연속으로 2번만 한계단씩 오를 수 있다는 의미다.)
 * <p>
 * 3. 마지막 계단은 '반드시' 밟아야 한다.
 */

public class 계단오르기 {
    static int[] stairs, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.valueOf(bf.readLine());

        stairs = new int[N + 1];
        dp = new int[N + 1];

        for (int i = 1; i < N + 1; i++) {
            stairs[i] = Integer.valueOf(bf.readLine());
        }

        dp[1] = stairs[1];
        if(N>=2)
        dp[2] = stairs[2]+ stairs[1];

        // bottom-up
        for(int i=3; i<=N; i++){
            dp[i] = Math.max(dp[i-2],dp[i-3]+stairs[i-1]) + stairs[i];
        }
        System.out.println(dp[N]);

    }

    // Top - Down
    public static int find(int N) {
        if(N<1){
            return 0;
        }
        if(dp[N]==0){
            dp[N] = Math.max(find(N-2),find(N-3)+stairs[N-1]) + stairs[N];
        }
        return dp[N];
    }

}
