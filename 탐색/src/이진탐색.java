package 탐색.src;

import java.io.*;
import java.util.*;

public class 이진탐색 {
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int n = Integer.valueOf(br.readLine());
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int[] arr = new int[n];
    	for(int i=0; i<n; i++) {
    		arr[i] = Integer.valueOf(st.nextToken());
    	}
    	Arrays.sort(arr);
    	int m = Integer.valueOf(br.readLine());
    	st = new StringTokenizer(br.readLine());
    	for(int i=0; i<m; i++) {
    		int num = Integer.valueOf(st.nextToken());
    		System.out.println(binarySearch(num, arr));
    	}
    }
    public static int binarySearch(int target,int[] arr) {
    	int start=0;
    	int end=arr.length-1;
    	int mid=0;
    	while(start<=end) {
    		mid = (start+end)/2;
    		if(arr[mid]==target) {
    			return 1;
    		}
    		if(arr[mid]<target) {
    			start=mid+1;
    		}
    		else {
    			end=mid-1;
    		}
    	}
    	return 0;
    }
}
