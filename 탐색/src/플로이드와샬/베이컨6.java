package 탐색.src.플로이드와샬;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 베이컨6 {
    static BufferedReader br;
    static StringTokenizer st;
    static final int INF = 20000000;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        int n = Integer.valueOf(st.nextToken());
        int m = Integer.valueOf(st.nextToken());
        int[][] map = new int[n + 1][n + 1];

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (i != j) {
                    map[i][j] = INF;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.valueOf(st.nextToken());
            int b = Integer.valueOf(st.nextToken());
            map[a][b] = 1;
            map[b][a] = 1;
        }

        for (int w = 1; w <= n; w++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (map[i][j] > map[i][w] + map[w][j]) {
                        map[i][j] = map[i][w] + map[w][j];
                    }
                }
            }
        }
        int answer = Integer.MAX_VALUE;
        int no = 0;
        // 답 구하기
        for (int i = 1; i <= n; i++) {
            int temp = 0;
            for (int j = 1; j <= n; j++) {
                if (i != j && map[i][j] != INF) temp += map[i][j];
            }

            if (answer >= temp) {
                if (answer == temp && no < i){
                    continue;
                }
                answer = temp;
                no = i;
            }
        }

        System.out.println(no);
    }

}
