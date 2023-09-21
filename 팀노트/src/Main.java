package 팀노트.src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.valueOf(st.nextToken());
        int M = Integer.valueOf(st.nextToken());

        int[] arr = new int[N+1];

        for(int c=0; c<M; c++){
            st = new StringTokenizer(br.readLine());
            int i = Integer.valueOf(st.nextToken());
            int j = Integer.valueOf(st.nextToken());
            int k = Integer.valueOf(st.nextToken());

            for(int x=i;x<=j;x++){
                arr[x] = k;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=N; i++){
            sb.append(arr[i]).append(" ");
        }
        System.out.println(sb);


    }

}
//
//        System.out.println(Integer.compare(1,2)); // 오름 -1
//        System.out.println(Integer.compare(1,1)); // 0
//        System.out.println(Integer.compare(2,1)); // 내림 1
//
//        System.out.println(("02151".charAt(1)-'0')+5);
//        List<Integer> list  = new ArrayList<>();
//        list.size();20
//
//        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
