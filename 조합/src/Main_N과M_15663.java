package 조합.src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_N과M_15663 {

    static StringBuilder sb = new StringBuilder();
    static int[] input;
    static Set<String> set = new HashSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.valueOf(st.nextToken());
        int M = Integer.valueOf(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int arr[] = new int[N];
        input = new int[M];
        for(int i=0; i<N; i++){
            arr[i] = Integer.valueOf(st.nextToken());
        }

        Arrays.sort(arr);

        perm(arr,M,0,0);
        System.out.println(sb);
    }
    public static void perm(int[] arr,int depth, int M,int flag){
        StringBuilder sbClone = new StringBuilder();
        if(depth == M){
            for(int i=0; i<M; i++){
                sbClone.append(input[i]).append(" ");
            }
            if (!set.contains(sbClone.toString())){
                set.add(sbClone.toString());
                sb.append(sbClone).append('\n');
            }

            return;
        }

        for(int i=0; i<arr.length; i++){
            if((flag&(1<<i)) != 0) continue;
            input[M] = arr[i];
            perm(arr,depth,M+1, flag|(1<<i));

        }

    }
}














