import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 병합정렬 {
	private static int[] A, tmp; // 원본 임시.
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		tmp = new int[N+1];
		A = new int[N+1];
		for(int i=1; i<=N; i++) {
			A[i] =  Integer.parseInt(br.readLine());
		}
		
		merget_sort(1, N);
		
		for(int i =1; i<N+1; i++) {
			bw.write(A[i]+"\n");
		}
		bw.flush();
	}
	private static void merget_sort(int s, int e) {
		if(e-s<1) return;
		
		int m = (s+e)/2;
		// 재귀 함수 형태로 구현
		merget_sort(s, m);
		merget_sort(m+1, e);
		
		for(int i=s; i<=e; i++) {
			tmp[i] = A[i];
		}
		int k = s;
		int idx1 = s;
		int idx2 = m+1;
		// 두 그룹을 병합하는 로직
		while(idx1<=m && idx2<=e) {
			if(tmp[idx1]>tmp[idx2]) {
				A[k++] = tmp[idx2++];
			}else {
				A[k++] = tmp[idx1++];
			}
		}
		// 남은거 처리
		while( idx1<=m) {
			A[k++] = tmp[idx1++];
		}
		while( idx2<=e) {
			A[k++] = tmp[idx2++];
		}
	}

}
