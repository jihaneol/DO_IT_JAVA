package 탐색.src.플로이드와샬;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 가장빠른노선 {
	static BufferedReader br;
	static StringTokenizer st;
	static final int  INF = 20000000;
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(br.readLine());
		int m = Integer.valueOf(br.readLine());
		int[][] map = new int[n+1][n+1];
		for(int i=1; i<n+1; i++) {
			for(int j=1; j<n+1; j++) {
				if(i!=j) {
					map[i][j] = INF;
				}
			}
		}
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.valueOf(st.nextToken());
			int b = Integer.valueOf(st.nextToken());
			int c = Integer.valueOf(st.nextToken());
			if(map[a][b]>c) map[a][b] = c;
		}
		
		for(int w=1; w<=n; w++) {
			for(int i=1; i<=n; i++) {
				for(int j=1; j<=n; j++) {
					if(map[i][j]>map[i][w]+map[w][j]) {
						map[i][j] = map[i][w]+map[w][j];
					}
				}
			}
		}
		for(int i=1; i<n+1; i++) {
			for(int j=1; j<n+1; j++) {
				if(map[i][j]==INF) System.out.print("0 ");
				else System.out.print(map[i][j]+ " ");
			}
			System.out.println();
		}
	}

}
