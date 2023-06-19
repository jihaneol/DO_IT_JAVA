import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;
// 왜 틀맂>??
public class 마인크래프트 {
	static int arr[][],B;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(br.readLine());;
		int N = Integer.valueOf(st.nextToken());
		int M = Integer.valueOf(st.nextToken());
		B= Integer.valueOf(st.nextToken());
		
		arr = new int[N][M];
		int max = 0;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				arr[i][j] = Integer.valueOf(st.nextToken());
				max = Math.max(max, arr[i][j]);
			}
		}
		int time=Integer.MAX_VALUE,H=0;
		// 기준
		for(int i=0; i<=max; i++) {
			int block = B;
			int tmpTime = 0;
			naga:for(int a=0; a<N; a++) {	
				if(tmpTime>time) break;
				for(int b=0; b<M; b++) {
					//쌓기
					if(arr[a][b]<i) {
						if(block==0) break naga;
						tmpTime+=i-arr[a][b];
						block-=(i-arr[a][b]);
					//빼기
					}else {
						tmpTime+=(arr[a][b]-i)*2;
						block+=(arr[a][b]-i);
					}
					
					
					
				}
			}
			if(time>tmpTime) {
				time = tmpTime;
				H=i;
			}else if(time==tmpTime && H<i) {
				H=i;
			}
		}
		System.out.println(time+" "+H);
	}

}
