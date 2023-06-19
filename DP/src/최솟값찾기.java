import java.io.*;
import java.util.*;

public class 최솟값찾기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.valueOf(st.nextToken());
		int L = Integer.valueOf(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		Deque<Node> dq = new LinkedList();
		
		for(int i=1; i<=N; i++) {
			int now = Integer.valueOf(st.nextToken());
			// dq가 비었거나 뒷 값 >현재일 동안 값제거			
			while(!dq.isEmpty() && dq.getLast().value>now) {
				dq.removeLast();
			}
			// 값 저장
			dq.addLast(new Node(i,now));
			//	첫번째 인덱스와 현재 비교 L넘기면 제거
			if(i-dq.getFirst().index>=L) {
				dq.removeFirst();
			}
			// 덱의 1번째 값 저장..
				sb.append(dq.getFirst().value).append(" ");
		}
		System.out.println(sb);
		
	}
	public static class Node{
		int index;
		int value;
		public Node(int index, int value) {
			super();
			this.index = index;
			this.value = value;
		}
	}
	
}
