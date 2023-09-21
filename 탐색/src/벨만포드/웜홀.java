package 벨만포드;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class 웜홀 {
	static BufferedReader br;
	static StringTokenizer st;
	static ArrayList<Edge>[] edges;
	static class Edge{
		int end,cost;

		public Edge(int no, int cost) {
			super();
			this.end = no;
			this.cost = cost;
		}
		
	}
	public static void main(String[] args) throws Exception{
		br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.valueOf(br.readLine());
		for(int test=0; test<T; test++) {
			st = new StringTokenizer(br.readLine());
			int N,M,W;
			N = Integer.valueOf(st.nextToken());
			M = Integer.valueOf(st.nextToken());
			W = Integer.valueOf(st.nextToken());
			
			int[] dist = new int[N+1];
			// init
			edges = new ArrayList[N+1];
			for(int i=1; i<N+1; i++) {
				edges[i] = new ArrayList();
			}
			
			for(int i=0; i<M+W; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.valueOf(st.nextToken());
				int b = Integer.valueOf(st.nextToken());
				int c = Integer.valueOf(st.nextToken());
				
				if(i<M) {
					edges[a].add(new Edge(b,c));
					edges[b].add(new Edge(a,c));
				}else {
					edges[a].add(new Edge(b,-c));
					
				}
				
			}
			int INF = 999999999;
			Arrays.fill(dist,INF);
			dist[1]=0;
			boolean flag = true;
			// belman dist[j] !=INF 주위하자 !!
			for(int i=0; i<N-1; i++) {
				flag = true;
				for(int j=1; j<N+1; j++) {
					for(Edge now : edges[j]) {
						if(dist[j]!=INF && dist[now.end]>dist[j]+now.cost) {
							dist[now.end] = dist[j]+now.cost;
							flag = false;
						}
						
					}
				}
				if(flag) break;
				
			}
			if(flag){
				System.out.println("NO");
				continue;
			}

			boolean chk = true;
			for(int j=1; j<N+1; j++) {
				for(Edge now : edges[j]) {
					if(dist[j]!=INF && dist[now.end]>dist[j]+now.cost) {
						chk = false; // 사이클
					}
					
				}
			}
			if(!chk) {
				System.out.println("YES");
			}else {
				System.out.println("NO");
			}
			
			
		}
	}
}

