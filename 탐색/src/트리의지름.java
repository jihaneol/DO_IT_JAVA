	import java.io.*;
	import java.util.*;
	
	public class 트리의지름 {
		static LinkedList<Node>[] graph;
		static int vertax[],max;
		static boolean visited[];
		public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int V = Integer.valueOf(br.readLine());
			graph = new LinkedList[V+1];
			for(int i=1; i<V+1; i++) {
				graph[i] = new LinkedList<Node>();
			}
			StringTokenizer st = null;
			for(int i=0; i<V; i++) {
				st = new StringTokenizer(br.readLine());
				int start = Integer.valueOf(st.nextToken());
				int end=0;
				while((end=Integer.valueOf(st.nextToken()))!=-1) {
					graph[start].add(new Node(end,Integer.valueOf(st.nextToken())));
				}
			}
			vertax = new int[V+1];
			visited = new boolean[V+1];
			max = 0;
			int ans = dfs(1);
			System.out.println(ans);
//			bfs(1);
//			for(int i=2; i<V+1; i++) {
//				if(vertax[i]>vertax[max]) {
//					max=i;
//				}
//			}
//			vertax = new int[V+1];
//			visited = new boolean[V+1];
//			bfs(max);
//			Arrays.sort(vertax);
//			System.out.println(vertax[V]);
	
		}
		static int dfs(int now) {
			int var =0;
			int secVar = 0;
			visited[now] = true;
			for(Node next : graph[now]) {
				int e = next.value;
				int cost = next.cost;
				if(visited[e])
	                continue;
				int sum = dfs(e) +cost;
				if(var<sum) {
					secVar = var;
					var = sum;
				}else if(secVar<sum) {
					secVar=sum;
				}
			}
			max = Math.max(max, var+secVar);
			return var; // 현재 값중 가장 큰값 부모한테 건내주기..
		}
		
		static void bfs(int now) {
			Queue<Integer> q = new LinkedList();
			q.add(now);
			visited[now] = true;
			while(!q.isEmpty()) {
				now = q.poll();
				
				for(Node next:graph[now]) {
					if(!visited[next.value]) {
						q.add(next.value);
						visited[next.value] = true;
						vertax[next.value] = next.cost+vertax[now];
					}
				}
			}
		}
		static class Node{
			int value,cost;
			
			public Node(int va,int co) {
				this.value = va;
				this.cost = co;
			}
		}
	
	}
