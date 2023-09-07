package 그래프.src;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_친구필요_21736 {
    static char map[][];
    static boolean visited[][];

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.valueOf(st.nextToken());
        int M = Integer.valueOf(st.nextToken());

        map = new char[N][M];
        visited = new boolean[N][M];
        Queue<int[]> q = new LinkedList();
        for (int i = 0; i < N; i++) {
            char[] charArray = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                map[i][j] = charArray[j];
                if (map[i][j] == 'I') {
                    q.add(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }
        int dx[] = {0, 0, -1, 1};
        int dy[] = {-1, 1, 0, 0};
        int answer = 0;
        while (!q.isEmpty()) {
            int now[] = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + now[0];
                int ny = dy[i] + now[1];

                try {
                    if (map[nx][ny] != 'X' && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        q.add(new int[]{nx, ny});
                        if (map[nx][ny] == 'P') answer++;
                    }
                } catch (Exception e) {
                    continue;
                }
            }

        }

        if (answer == 0) {
            System.out.println("TT");
        } else {

            System.out.println(answer);
        }

    }


}





