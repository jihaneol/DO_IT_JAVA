package 탐색.src;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 가장쉬운_최단거리 {

    static int[][] map;
    static boolean[][] visited;

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.valueOf(st.nextToken());
        int m = Integer.valueOf(st.nextToken());

        Point startPoint = null;

        // 맵 만들기
        map = new int[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int num;
            for (int j = 0; j < m; j++) {
                num = Integer.valueOf(st.nextToken());

                map[i][j] = num;

                if (num == 2) {
                    startPoint = new Point(i, j);
                }

            }
        }

        // 너비 탐색
        bfs(startPoint);

        // 갈수 있는데 땅인데 못가는 땅 -1 처리
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    map[i][j] = -1;
                }
            }
        }
        // 출력
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    static void bfs(Point p) {
        int dx[] = {0, 0, 1, -1};
        int dy[] = {1, -1, 0, 0};
        Queue<Point> queue = new LinkedList<>();
        queue.add(p);
        map[p.x][p.y] = 0;
        visited[p.x][p.y] = true;
        while (!queue.isEmpty()) {
            Point now = queue.poll();
            for (int i = 0; i < 4; i++) {

                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                try {
                    if (!visited[nx][ny] && map[nx][ny] == 1) {
                        visited[nx][ny] = true;
                        map[nx][ny] = map[now.x][now.y] + 1;
                        queue.add(new Point(nx, ny));
                    }
                } catch (Exception e) {
                    continue;
                }
            }
        }
    }
}


/**
 * String s = "a1=1,2,3/a2=4,5,6";
 * Map<String, String> map = Pattern.compile("/")
 * .splitAsStream(s.trim())
 * .map(i -> i.split("=", 2))
 * .collect(Collectors.toMap(a -> a[0], a -> a[1]));
 * <p>
 * for (String key : map.keySet()) {
 * System.out.println(map.get(key));
 * }
 * <p>
 * 결과 : 1,2,3
 * 4,5,6
 */