package 다익스트라;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class k번째최단경로찾기 {
	static BufferedReader br;
	static StringTokenizer st;
	static class Node implements Comparable<Node>{
		int no,cost;

		public Node(int no, int cost) {
			super();
			this.no = no;
			this.cost = cost;
		}
		@Override
		public int compareTo(Node node) {
			return Integer.compare(this.cost, node.cost);
		}
		
	}
	public static void main(String[] args) throws Exception{
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		int N,M,K,map[][];
		N = Integer.valueOf(st.nextToken());
		M = Integer.valueOf(st.nextToken());
		K = Integer.valueOf(st.nextToken());
		map = new int[N+1][N+1]; // 인접행렬
		// 행렬 초기화
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.valueOf(st.nextToken());
			int b = Integer.valueOf(st.nextToken());
			int c = Integer.valueOf(st.nextToken());
			map[a][b] = c;
		}
		
		PriorityQueue<Integer>[] queueDist = new PriorityQueue[N+1];
		
		for(int i=1; i<=N; i++) {
			queueDist[i] = new PriorityQueue<Integer>((a,b)->{
				return a<b?1:-1;
			});
		}
		// 다익스트라
		PriorityQueue<Node> pq = new PriorityQueue();
		queueDist[1].add(0);
		pq.add(new Node(1,0));
		while(!pq.isEmpty()){
			Node now = pq.poll();
			
			for(int e=1; e<N+1; e++) {
				if(map[now.no][e]!=0) {
					
					if(queueDist[e].size()<K) {
						// K 미만이면 넣기
						queueDist[e].add(now.cost+map[now.no][e]);
						pq.add(new Node(e,now.cost+map[now.no][e]));
					}else if(now.cost+map[now.no][e]<queueDist[e].peek()) {
						queueDist[e].poll();
						queueDist[e].add(now.cost+map[now.no][e]);
						pq.add(new Node(e,now.cost+map[now.no][e]));
						
					}
				}
			}
		}
		for(int i=1; i<N+1; i++) {
			if(queueDist[i].size()==K) {
				System.out.println(queueDist[i].peek());
			}else {
				System.out.println(-1);
			}
		}
	}
	
}
