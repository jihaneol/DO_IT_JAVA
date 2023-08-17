package 정렬.src;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class 퀵정렬 {
	public static void main(String[] args) throws IOException {
			BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			
			int data[] = new int[n];
			st = new StringTokenizer(bf.readLine());
			for(int i=0; i<n; i++) data[i]=Integer.parseInt(st.nextToken());
			
			quickSort(data, 0, n-1, k-1);
			System.out.println(data[k-1]);
		// 퀵 솔트
	}
	public static  void quickSort(int[] A,int s, int e, int k) {
		if(s<e) {
			int pivot = partition(A, s, e);
			if(pivot==k) {
				return ;
			}else if(k<pivot) {
				quickSort(A, s, pivot-1, k);
			}else {
				quickSort(A, pivot+1, e, k);
			}
		}
	}
	//  작  <pivot < 큰 
	public static int partition(int[] A, int s, int e) {
		// 하나 차이 라면
		if(s+1==e) {
			if(A[s]>A[e]) swap(A,s,e);
			return e;
		}
		int mid = (s+e)/2;
		// 편하게 하기위해 중앙 pivot 값을 맨 앞으로 갖다 놓은다.
		swap(A,s,mid);
		int pivot = A[s];
		int i = s+1,j=e; 
		while(i<=j) {
			// e 이동
			while(A[j]>pivot && j>0) {
				j--;
			}
			// s 이동
			while(A[i]<pivot && i<A.length-1) {
				i++;
			}
			
			if(i<=j) {
				swap(A,i++,j--);
			}
		}
		A[s] = A[j];
		A[j] = pivot;
		return j;
	}
	public static void swap(int[] A, int s, int e) {
		int temp = A[s];
		A[s] = A[e];
		A[e] = temp;
	}
}
