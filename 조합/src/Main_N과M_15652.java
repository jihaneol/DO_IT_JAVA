package 조합.src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_N과M_15652 {
    static StringBuilder sb = new StringBuilder();
    static int[] input;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.valueOf(st.nextToken());
        int M = Integer.valueOf(st.nextToken());


        int arr[] = new int[N];
        input = new int[M];
        for(int i=0; i<N; i++){
            arr[i] = i+1;
        }

        perm(arr,M,0,0);
        System.out.println(sb);
    }
    public static void perm(int[] arr,int depth, int M,int flag){
        if(depth == M){
            for(int i=0; i<M; i++){
                sb.append(input[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=0; i<arr.length; i++){
            input[M] = arr[i];
            perm(arr,depth,M+1, flag|(1<<i));

        }

    }
}














