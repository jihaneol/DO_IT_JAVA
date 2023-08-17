package MST;

import java.util.*;
import java.io.*;
public class 다리만들기{
	static int[] dr = {0,0,-1,1};
	static int[] dc = {1,-1,0,0};
	static int[][] map;
    static boolean visited[][];
    static int sNum;
    static int[] parents;
    static ArrayList<ArrayList<int[]>> sumlist;
    static ArrayList<int[]> mlist;
    static PriorityQueue<bEdge> queue;
    static class bEdge implements Comparable<bEdge>{
    	int s,e,cost;
    	bEdge(int s, int e, int cost){
    		this.s = s;
    		this.e = e;
    		this.cost = cost;
    	}
		@Override
		public int compareTo(bEdge o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.cost, o.cost);
		}
    	
    }
    public static void main(String[] arg) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.valueOf(st.nextToken());
        int M = Integer.valueOf(st.nextToken());
        map = new int[N][M];
        // 맵 저장
        for(int i=0; i<N; i++) {
        	 st = new StringTokenizer(br.readLine());
        	for(int j=0; j<M; j++) {
        		map[i][j] = Integer.valueOf(st.nextToken());
        	}
        }
        
        
        visited = new boolean[N][M];
        sNum = 1; // 섬 개수
        sumlist = new ArrayList();
        // 각자리서 bfs 탐색으로 섬 분리
        for(int i=0; i<N; i++) {
        	for(int j=0; j<M; j++) {
        		// 방문 안했고 바다가 아니라면
        		if(!visited[i][j] && map[i][j]!=0) {
        			BFS(i,j);
        			sNum++;
        			sumlist.add(mlist);
        		}
        	}
        }
        
        queue = new PriorityQueue();
        // 섬의 각 지점에서 모든 에지 저장
        for(int i=0; i< sumlist.size(); i++) {
        	ArrayList<int[]> now = sumlist.get(i);
        	for(int j=0; j<now.size(); j++) {
        		int r = now.get(j)[0];
        		int c = now.get(j)[1];
        		int nowS = map[r][c];
        		for(int d=0; d<4; d++) {
    				int nx = dr[d]+r ;
    				int ny = dc[d]+c;
    				int dist = 0;
    				   try {
                           if(map[nx][ny]==0) {
                               while(map[nx][ny]==0) {
                                   nx+=dr[d];
                                   ny+=dc[d];
                                   dist++;
                               }
                               if(dist>1&& map[nx][ny]!=nowS) {
                                   // 엣지 만들기
                                   queue.add(new bEdge(nowS ,map[nx][ny] ,dist)); // A, B, dist
                               }
                           }
                       } catch (Exception e) {
                           continue;
                       }
    			}
        	}
        }
        parents = new int[sNum];
        for(int i=0; i<sNum; i++){
            parents[i] = i;
        }
        int ans = 0;
        int cnt = 0;
        // 크루스칼
        while(!queue.isEmpty()){
        	bEdge now = queue.poll();
            // 사이클이 없다면
            if(!union(now.s,now.e)){
            	ans += now.cost;
            	cnt++;
            }
        
        }
        if(cnt == sNum -2) {
        	System.out.println(ans);
        }else if(cnt!=sNum-2 || ans==0){
        	System.out.println(-1);
        }
        
    }
    private static void BFS(int i, int j) {
    	Queue<int[]> q = new LinkedList();
    	// 섬 정보들
    	mlist = new ArrayList();
    	int[] start = {i, j};
		q.add(start);
		mlist.add(start);
		visited[i][j] = true;
		map[i][j] = sNum;
		while(!q.isEmpty()) {
			int now[] = q.poll();
			
			for(int d=0; d<4; d++) {
				int nx = now[0] + dr[d];
				int ny = now[1] + dc[d];
				try {
					if(!visited[nx][ny] && map[nx][ny]!=0) {
						visited[nx][ny] = true;
						int[] tmp = {nx,ny};
						q.add(tmp);
						mlist.add(tmp);
						map[nx][ny] = sNum;
					}
				} catch (Exception e) {
				}
			}
			
					
		}
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