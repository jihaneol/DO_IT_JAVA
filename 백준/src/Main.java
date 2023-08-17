import java.util.*;
import java.io.*;
public class Main{
    static class Edge implements Comparable<Edge>{
        int s,e,cost;
        Edge(int s, int e, int cost){
            this.s = s;
            this.e = e;
            this.cost = cost;
        }
        public int compareTo(Edge e){
            return Integer.compare(this.cost,e.cost);
        }
    }
    static int[] parents;
    public static void main(String[] arg) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long ans = 0;
        int V = Integer.valueOf(st.nextToken());
        int E = Integer.valueOf(st.nextToken());
        PriorityQueue<Edge> edges = new PriorityQueue();
        parents = new int[V+1];
        for(int i=1; i<V+1; i++){
            parents[i] = i;
        }
        for(int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.valueOf(st.nextToken());
            int b = Integer.valueOf(st.nextToken());
            int c = Integer.valueOf(st.nextToken());
            edges.add(new Edge(a,b,c));
        }
        int cnt = 0;
        // 크루스칼
        for(Edge now:edges){
            if(cnt==V) break;
            // 사이클이 없다면
            if(!union(now.s,now.e)){
                ans+=now.cost;
            }
        
        }
        System.out.print(ans);
        
    }
    static int find(int a){
        if(parents[a]==a){
            return a;
        }else{
            return parents[a] = find(parents[a]);
        }
    }
    static boolean union(int a, int b){
        a = find(a);
        b = find(b);
        if(a==b){
            return true;
        }else{
            parents[a]=b;
            return false;
        }
    }
}