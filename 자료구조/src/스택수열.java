package 자료구조.src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 스택수열 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> myStack = new Stack<Integer>();
		int cnt = 0;
		StringBuilder sb = new StringBuilder();
		int n = Integer.valueOf(br.readLine());
		int[] arr = new int[n];
		
		for(int i=0; i<n; i++) {
			arr[i] = Integer.valueOf(br.readLine());
		}
		// 1~n 스택에 넣기
		for(int i=1; i<=n; i++) {
			myStack.push(i);
			sb.append("+").append("\n");
			
			// 스택의 top이 만들어야 할 수 보다 크면 
			if(i>arr[cnt]) {
				System.out.println("NO");
				return;
			}
			
			while(!myStack.isEmpty() && myStack.peek()==arr[cnt]) {
				myStack.pop();
				cnt++;
				sb.append("-").append("\n");
			}
			
		}
		if(!myStack.isEmpty()) {
			System.out.println("NO");
		}else {
			System.out.println(sb);
			
		}

	}

}
