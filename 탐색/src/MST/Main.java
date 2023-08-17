	package MST;
	
	import java.util.*;
	import java.io.*;
	public class Main{
		static int[][] map;
	    static int[] parents;
	    static int sum;
	    static PriorityQueue<bEdge> pq;
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
	        pq = new PriorityQueue();
	        
	        for(int i=0; i<N; i++) {
	        	 st = new StringTokenizer(br.readLine());
	        	 char[] tempc = st.nextToken().toCharArray();
	        	for(int j=0; j<N; j++) {
	        		int temp = 0;
	        		if(tempc[j]>='a' && tempc[j]<='z')
	        			temp = tempc[j] -'a' + 1;
	        		else if(tempc[j]>='A' && tempc[j]<='Z')
	        			temp = tempc[j] - 'A' + 27;
	        		// 총랜선 저장
	        		sum+=temp;
	        		if(i!=j && temp!=0) pq.add(new bEdge(i, j, temp));
	        	}
	        }
	        
	        parents = new int[N];
	        for(int i=0; i<parents.length; i++){
	            parents[i] = i;
	        }
	        int ans = 0;
	        int cnt = 0;
	        // 크루스칼
	        while(!pq.isEmpty()){
	        	bEdge now = pq.poll();
	            // 사이클이 없다면
	            if(find(now.s)!=find(now.e)){
	            	union(now.s, now.e);
	            	ans += now.cost;
	            	cnt++;
	            }
	        }
	        if(cnt == N -1) {
	        	System.out.println(sum-ans);
	        }else {
	        	System.out.println(-1);
	        }
	        
	    }
	  
		static int find(int a){
	        if(parents[a]==a){
	            return a;
	        }else{
	            return parents[a] = find(parents[a]);
	        }
	    }
	    static void union(int a, int b){
	        a = find(a);
	        b = find(b);
	        if(a !=b) parents[a]=b;
	    }
	}