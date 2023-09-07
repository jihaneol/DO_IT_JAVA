package 탐색.src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_파티_1238 {
    static class Edge{
        int e,cost;
        Edge(int e, int cost){
            this.e = e;
            this.cost = cost;
        }
    }
    static ArrayList<Edge>[] graph;
    static int[] dist;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.valueOf(st.nextToken());
        int E = Integer.valueOf(st.nextToken());
        int X = Integer.valueOf(st.nextToken());

        graph = new ArrayList[V+1];
        for(int i=1; i<V+1; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.valueOf(st.nextToken());
            int b = Integer.valueOf(st.nextToken());
            int c = Integer.valueOf(st.nextToken());

            graph[a].add(new Edge(b,c));
        }

        for(int i= 1; i<V+1; i++){

        }


    }
}
