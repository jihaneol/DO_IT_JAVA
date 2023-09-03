package 트리.src;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_최솟값찾기_10868 {
    static int[] tree;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.valueOf(st.nextToken());
        int M = Integer.valueOf(st.nextToken());

        int k = 1;
        while(Math.pow(2,k)<N){
            k++;
        }
        int center = (int)Math.pow(2,k);
        tree = new int[center*2];

        for(int i=0; i<N; i++){
            tree[center+i] = Integer.valueOf(br.readLine());
        }

        // 값 세팅
        for(int i = center; i<N+center; i++){

            int idx = i;
            while(idx!=1){
                if(tree[idx/2]==0){
                    tree[idx/2] = tree[idx];
                } else if (tree[idx / 2] > tree[idx]){
                    tree[idx/2] = tree[idx];
                }
                idx/=2;
            }
        }
        StringBuilder sb = new StringBuilder();
        // 최솟값 구하기
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());

            int s = Integer.valueOf(st.nextToken()) + center -1;
            int e = Integer.valueOf(st.nextToken()) + center -1;
            int min = Integer.MAX_VALUE;
            while(s<=e){
                if(s%2==1) {
                    if(tree[s]<min) min = tree[s];
                }
                if(e%2==0){
                    if(tree[e]<min) min = tree[e];
                }
                s = (s+1)/2;
                e = (e-1)/2;
            }
            sb.append(min).append('\n');

        }
        System.out.println(sb);

    }

}
