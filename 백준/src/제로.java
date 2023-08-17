package 백준.src;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;


public class 제로 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.valueOf(br.readLine());
		
		Stack<Integer> stack = new Stack();
		
		for(int i=0; i<N; i++) {
			int num = Integer.valueOf(br.readLine());
			if(num==0 && !stack.isEmpty()) {
				stack.pop();
			}else if(num!=0) {
				stack.push(num);
			}
		}
		int sum = 0;
		while(!stack.isEmpty()) {
			sum += stack.pop();
		}
		System.out.println(sum);
	}

}
