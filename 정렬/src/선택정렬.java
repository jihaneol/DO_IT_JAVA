package 정렬.src;
import java.util.Scanner;
import java.util.stream.Stream;
import java.util.*;


public class 선택정렬 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] arr = Stream.of(sc.next().split("")).mapToInt(Integer::valueOf).toArray();
		
		for(int i=0; i<arr.length; i++) {
			int max = i; // 현재 인덱스
			for(int j=i+1; j<arr.length; j++) {
				if(arr[j]>arr[max]) max=j;
			}
			// 최댓값 첫번째 인덱스와 스왑 
			if(arr[i]<arr[max]) {
				int temp = arr[i];
				arr[i] = arr[max];
				arr[max]=temp;
			}
		}
		for(int num:arr) {
			System.out.print(num);
		}
	}

}
