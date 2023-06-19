import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 기수정렬 {
	public static long result;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.valueOf(br.readLine());
		int[] A = new int[N]; // 데이터 저장 배열
		
		for(int i=0; i<N; i++) {
			A[i] = Integer.valueOf(br.readLine());
		}
		br.close();
		radixSort(A,5);
		for(int i = 0; i<N; i++) {
			bw.write(A[i] + "\n");
		}
		bw.flush();
		bw.close();

	}
	public static void radixSort(int[] A, int maxSize) {
		int[] output = new int[A.length]; // 임시 
		int jarisu = 1;
		int count = 0;
		while(count!=maxSize) {
			int[] bucket = new int[10]; // queue 역할.
			for(int i=0; i<A.length; i++) {
				bucket[(A[i]/jarisu)%10]++; // 각자리수 개수 저장.
			}
			
			for(int i=1; i<10; i++) {
				bucket[i]+=bucket[i-1]; // 합배열을 이용해 index 계산
			}
			for(int i=A.length-1; i>=0; i--) {
				output[bucket[(A[i]/jarisu)%10]-1] = A[i];
				bucket[(A[i]/jarisu)%10]--;
			}
			for(int i=0; i< A.length; i++) {
				A[i] = output[i];
			}
			jarisu = jarisu *10;
			count++;
			
		}
	}

}















