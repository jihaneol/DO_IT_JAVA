package 위상정렬;

import java.io.*;
import java.util.*;

public class 게임개발 {
	static BufferedReader br;
	static StringTokenizer st;
	static int N,inArr[],cost[],ans[];
	static ArrayList<Integer>[] graph;
	public static void main(String[] args) throws Exception{
		br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.valueOf(br.readLine());
		inArr = new int[N+1]; // inDegree
		cost = new int[N+1];
		ans = new int[N+1];
		Queue<Integer> queue = new LinkedList();
		graph = new ArrayList[N+1];
		for(int i=1; i<=N; i++) {
			graph[i] = new ArrayList();
		}
		// init
		int tmp = 0;
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			tmp = st.countTokens();
			for(int j=0; j<tmp-1; j++) {
				if(j==0) {
					cost[i] = Integer.valueOf(st.nextToken());
				}else {
					int e = Integer.valueOf(st.nextToken());
					graph[e].add(i);
					inArr[i]++;
				}
				
			}
		}
		ans = new int[N+1];
		// 진입 차수 0 찾기
		for(int i=1; i<N+1; i++) {
			if(inArr[i]==0) {
				queue.add(i);
				ans[i] = cost[i];
			}
		}
		// 위상 정렬
		while(!queue.isEmpty()) {
			int now = queue.poll();
			
			for(int next:graph[now]) {
				inArr[next]--;
				// 동시에 건물을 지을 수 있다..
				ans[next]=Math.max(ans[next],cost[next]+ans[now]);
				if(inArr[next]==0) {
					queue.add(next);
				}
			}
		}
		for(int i=1; i<=N; i++) {
			System.out.println(ans[i]);
		}
	}

}