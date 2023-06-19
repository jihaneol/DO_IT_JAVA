import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class 토마토 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int m = Integer.valueOf(st.nextToken());
		int n = Integer.valueOf(st.nextToken());
		Queue<Tomato> queue = new LinkedList<Tomato>();
		int[][] arr = new int[n][];
		for(int i=0; i<n; i++) {
			arr[i] = Stream.of(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
			for(int j=0; j<m; j++) {
				if(arr[i][j]==1) {
					queue.add(new Tomato(i,j));
				}
			}
		}
		int[] dx = {0,0,-1,1};
		int[] dy = {1,-1,0,0};
		int ans=0;
		while(!queue.isEmpty()) {
			int cnt = queue.size();
				Tomato now = queue.poll();
					for(int i=0; i<4; i++) {
						int nx = dx[i] + now.x;
						int ny = dy[i] + now.y;
						try {
						if(arr[nx][ny]==0) {
							arr[nx][ny]=arr[now.x][now.y]+1;
							queue.add(new Tomato(nx,ny));
						}
					}catch (Exception e) {
						continue;
					}
				} 
				
			
		}
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(arr[i][j]==0) {
					System.out.println("-1");
					return;
				}
				ans = Math.max(arr[i][j], ans);
				
			}
		}
		System.out.println(ans-1);
		
	}
	static class Tomato{
		int x,y;

		public Tomato(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
		
	}

}
