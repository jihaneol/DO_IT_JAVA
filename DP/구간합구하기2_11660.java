package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 구간합구하기2_11660 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.valueOf(st.nextToken());
        int M = Integer.valueOf(st.nextToken());
        int[][] darr = new int[N+1][N+1]; //dp
        StringBuilder sb = new StringBuilder();
        for (int i =1; i<=N;i++) {
            st = new StringTokenizer(bf.readLine());
            for(int j=1; j<=N; j++) {
                // 구간행열 합 공식
                darr[i][j] = darr[i-1][j]+darr[i][j-1]-darr[i-1][j-1]+Integer.valueOf(st.nextToken());
            }
        }
        for(int i=0; i<M;i++) {
            st = new StringTokenizer(bf.readLine());
            int x1=Integer.valueOf(st.nextToken());
            int y1=Integer.valueOf(st.nextToken());
            int x2=Integer.valueOf(st.nextToken());
            int y2=Integer.valueOf(st.nextToken());
            // 구간합 행열 구하는 공식
            sb.append(darr[x2][y2]-darr[x2][y1-1]-darr[x1-1][y2]+darr[x1-1][y1-1]+"\n");
        }
        System.out.println(sb);
    }
}
