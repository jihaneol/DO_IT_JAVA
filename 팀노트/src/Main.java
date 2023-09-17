package 팀노트.src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
//        Scanner sc = new Scanner(System.in);
//        StringBuilder sb = new StringBuilder();
//        Formatter f = new Formatter(sb);
        int N = Integer.valueOf(br.readLine());
        int dp[] = new int[201];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            dp[100+Integer.valueOf(st.nextToken())]++;
        }
        int k = Integer.valueOf(br.readLine());
        System.out.println(dp[100+k]);

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
