package 트리.src;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 트리11725 {
    static List<Integer>[] tree;
    static int[] parents;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;


        int N = Integer.valueOf(br.readLine());
        tree = new ArrayList[N + 1];
        parents = new int[N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            tree[i] = new ArrayList();
        }

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.valueOf(st.nextToken());
            int b = Integer.valueOf(st.nextToken());
            tree[a].add(b);
            tree[b].add(a);
        }

        dfs(1);
        StringBuilder sb = new StringBuilder();
        for(int i=2; i<=N; i++){
            sb.append(parents[i]).append("\n");
        }
        System.out.print(sb.toString());
    }

    public static void dfs(int node) {

        visited[node] = true;

        for (int nextNode : tree[node]) {
            if(!visited[nextNode]){
                parents[nextNode] = node;
                dfs(nextNode);
            }
        }

    }

}
