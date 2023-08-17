package 그래프.src;
import java.util.*;
import java.io.*;
public class 특정한최단경로 {
	static LinkedList<Node>[] graph;
	static int N,E,v1,v2;
	static int[] dist;
	static boolean[] check;
	static final int INF = Integer.MAX_VALUE;
	static class Node implements Comparable<Node>{
		int e,cost;
		
		Node(int e, int cost){
			this.e = e;
			this.cost = cost;
		}

		public int compareTo(Node node) {
			return Integer.compare(this.cost, node.cost);
		}
		
		
	}

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.valueOf(st.nextToken());
		E = Integer.valueOf(st.nextToken());
		graph = new LinkedList[N+1];
		dist = new int[N + 1];
        check = new boolean[N + 1];
		for(int i=1; i<=N; i++) {
			graph[i] = new LinkedList<Node>();
		}
		
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.valueOf(st.nextToken());
			int e = Integer.valueOf(st.nextToken());
			int c = Integer.valueOf(st.nextToken());
			graph[s].add(new Node(e,c));
			graph[e].add(new Node(s,c));
		}
		
		st = new StringTokenizer(br.readLine());
		v1 = Integer.valueOf(st.nextToken());
		v2 = Integer.valueOf(st.nextToken());
		
		  // 1 -> v1 -> v2 -> N으로 가는 경우
        int res1 = 0;
        res1 += dijkstra(1, v1);
        res1 += dijkstra(v1, v2);
        res1 += dijkstra(v2, N);
 
        // 1 -> v2 -> v1 -> N으로 가는 경우
        int res2 = 0;
        res2 += dijkstra(1, v2);
        res2 += dijkstra(v2, v1);
        res2 += dijkstra(v1, N);
 
        int ans = (res1 >= INF && res2 >= INF) ? -1 : Math.min(res1, res2);
        System.out.println(ans);
	}
	
	public static int dijkstra(int start, int end) {
		Arrays.fill(dist, INF);
		Arrays.fill(check, false);
		PriorityQueue<Node> pq = new PriorityQueue();
		pq.offer(new Node(start,0));
		dist[start] = 0;
		
		while(!pq.isEmpty()) {
			Node curNode = pq.poll();
			int cur = curNode.e;
			
			// 방문 하지 않았다면.
			if(!check[cur]) {
				check[cur] = true;
				
				for(Node node:graph[cur]) {
					if (!check[node.e] && dist[node.e] > dist[cur] + node.cost) {
                        dist[node.e] = dist[cur] + node.cost;
                        pq.add(new Node(node.e, dist[node.e]));
                    }
				}
			}
		}
		
		return dist[end];
		
		
	}

}
