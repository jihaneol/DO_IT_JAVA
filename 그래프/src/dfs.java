package 그래프.src;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class dfs {
	static ArrayList<Integer> graph[];
	static boolean visited[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.valueOf(st.nextToken());
		int E = Integer.valueOf(st.nextToken());
		graph = new ArrayList[V+1];
		for(int i=1; i<=V; i++) {
			graph[i] = new ArrayList<Integer>();
		}
		visited = new boolean[V+1];
		for(int i=0; i<E; i++) {	
			st = new StringTokenizer(br.readLine());
			int s = Integer.valueOf(st.nextToken());
			int e = Integer.valueOf(st.nextToken());
			
			graph[s].add(e);
			graph[e].add(s);
			
		}
		
		int ans = 0;
		for(int i=1; i<V+1; i++) {
			if(!visited[i]) {
				ans++;
				dfs(i);
			}
		}
		System.out.println(ans);

	}
	static void dfs(int node) {
		if(visited[node]) {
			return ;
		}
		// 방문 처리
		visited[node] = true;
		for(int next : graph[node]) {
			if(!visited[next]) {
				dfs(next);
			}
		}
		
	}	

}





