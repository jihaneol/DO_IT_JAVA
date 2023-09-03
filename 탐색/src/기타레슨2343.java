package 탐색.src;

import java.io.*;
import java.util.*;
import java.util.stream.Stream;
public class 기타레슨2343 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
    	int n = Integer.valueOf(st.nextToken());
    	int m = Integer.valueOf(st.nextToken());
    	int arr[] = Stream.of(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
    	int s = Arrays.stream(arr).max().getAsInt();
    	int e = Arrays.stream(arr).reduce((a,b)->a+b).getAsInt();
    	while(s<=e) {
    		// 기준 값.
    		int mid = (s+e)/2;
    		int sum = 0;
    		int cnt = 0;
    		// 모든 레슨을 실행 할 수 있는지 확인.
    		for(int i=0; i<n; i++) {
    			// 값을 넘어가면
    			if(sum+arr[i]>mid) {
    				cnt++;
    				sum=0;
    			}
    			sum +=arr[i];
    		}
    		if(sum!=0) {
    			cnt++;
    		}
    		if(cnt>m) {
    			// 크기 늘리기
    			s = mid+1;
    		}else{
    			// 크기 줄이기
    			e = mid-1;
    		}
    	}
    	System.out.println(s);
	}

}
