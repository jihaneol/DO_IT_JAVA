package 팀노트.src;

import java.util.*;
import java.io.*;
public class 유니온파인드 {
	static int N,E;
	static int[] parents;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.valueOf(st.nextToken());
		E = Integer.valueOf(st.nextToken());
		parents = new int[N + 1];
		for(int i=1; i<=N; i++) {
			parents[i]=i;
		}
		
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int type = Integer.valueOf(st.nextToken());
			int s = Integer.valueOf(st.nextToken());
			int e = Integer.valueOf(st.nextToken());
			
			if(type==0) {
				union(s,e);
			}else {
				if(find(s)!=find(e)) {
					System.out.println("NO");
				}else {
					System.out.println("YES");
				}
			}
		}
		
		
	}
	
	public static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if(a!=b) {
			parents[a]=b;
		}
	}
	public static int find(int a) {
		if(parents[a]==a) {
			return a;
		}else {
			return parents[a] = find(parents[a]);
		}
	}

}
