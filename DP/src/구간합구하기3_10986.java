package DP.src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 구간합구하기3_10986 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.valueOf(st.nextToken());
        int M = Integer.valueOf(st.nextToken());
        long[] remain = new long[M];
        //10**6이므로 long으로 해준다.
        long ans=0;
        long[] S = new long[N+1];
        st = new StringTokenizer(bf.readLine());
        for(int i=1; i<=N; i++) {
            S[i] = S[i-1]+ Integer.valueOf(st.nextToken());
            S[i]%=M;
            if(S[i]==0) ans++;
            //인덱스는 인트형으로 캐스팅
            remain[(int) S[i]]++;
        }
        for(int i=0; i<=M-1; i++){
            if(remain[i]>=2){
                // nC2로 조합 뽑기
                ans+=com(remain[i]);
            }
        }
        System.out.println(ans);
    }
    public static long com(long n){
        return n*(n-1)/2;
    }
}
