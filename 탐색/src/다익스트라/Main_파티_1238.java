package 탐색.src.다익스트라;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_파티_1238 {
    static class Edge implements Comparable<Edge> {
        int e, cost;

        Edge(int e, int cost) {
            this.e = e;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge e) {
            return Integer.compare(this.cost, e.cost);
        }
    }

    static ArrayList<Edge>[] graph;
    static ArrayList<Edge>[] reverseGraph;
    static int V,X;
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.valueOf(st.nextToken());
        int E = Integer.valueOf(st.nextToken());
        X = Integer.valueOf(st.nextToken());

        graph = new ArrayList[V + 1];
        reverseGraph = new ArrayList[V + 1];
        for (int i = 1; i < V + 1; i++) {
            graph[i] = new ArrayList<>();
            reverseGraph[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.valueOf(st.nextToken());
            int b = Integer.valueOf(st.nextToken());
            int c = Integer.valueOf(st.nextToken());

            graph[a].add(new Edge(b, c));
            reverseGraph[b].add(new Edge(a, c));
        }

        int[] dist = dik(graph);
        int[] reverseDist = dik(reverseGraph);
        int answer = 0;
        for(int i=1; i<V+1; i++){
            answer = Math.max(answer,dist[i]+reverseDist[i]);
        }


        System.out.println(answer);

    }

    public static int[] dik(ArrayList<Edge>[] graph) {
        PriorityQueue<Edge> pq = new PriorityQueue<Edge>((a, b) -> Integer.compare(a.cost, b.cost));
        boolean[] visited = new boolean[V+1];
        int[] dist = new int[V+1];

        pq.add(new Edge(X, 0));
        Arrays.fill(dist, INF);
        dist[X] = 0;
        // X 에서의 최단거리
        while (!pq.isEmpty()) {
            Edge now = pq.poll();
            if(!visited[now.e]){
                visited[now.e] = true;
                for (Edge next : graph[now.e]) { // 방문배열 사용 안할 시 또 돌아가기때문에 문제가 된다. 불필요한것이 또 돔...
                    if (dist[next.e] > now.cost + next.cost) {
                        dist[next.e] = now.cost + next.cost;
                        pq.add(new Edge(next.e, dist[next.e]));
                    }
                }
            }
        }
        return dist;
    }
}





















