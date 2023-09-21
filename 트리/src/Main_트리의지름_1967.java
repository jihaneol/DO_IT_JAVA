package 트리.src;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main_트리의지름_1967 {
    static List<Node> graph[];
    static int answer,endNum;
    static boolean visited[];

    static class Node {
        int e, cost;

        Node(int e, int cost) {
            this.e = e;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int N = Integer.valueOf(br.readLine());

        if(N ==1 ){
            System.out.println(0);
            return;
        }

        graph = new List[N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i < N + 1; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.valueOf(st.nextToken());
            int e = Integer.valueOf(st.nextToken());
            int cost = Integer.valueOf(st.nextToken());
            graph[s].add(new Node(e, cost));
            graph[e].add(new Node(s, cost));
        }

        // x->y 가장 긴 정점 찾기, y->z 가장 긴 정점 찾으면 y->z가 지름
        dfs(1,0);
        answer = 0;
        Arrays.fill(visited,false);
        dfs(endNum,0);
        System.out.println(answer);

    }

    static void dfs(int start, int total) {
        int cnt = 0;
        visited[start] = true;
        for (Node next : graph[start]) {
            if (!visited[next.e]) {
                cnt++;
                dfs(next.e, next.cost + total);
            }
        }
        // 끝점
        if (cnt == 0) {
            if(answer<total){
                answer = total;
                endNum = start;
            }
        }
    }
}
