import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 좌표정렬 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.valueOf(br.readLine());
		StringTokenizer st = null;
		Node[] arr = new Node[n];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i] = new Node(Integer.valueOf(st.nextToken()), Integer.valueOf(st.nextToken()));
		}
		Arrays.sort(arr);
		for(Node node:arr) {
			sb.append(node.one).append(" ").append(node.two).append("\n");
//			sb.append(node.one+" "+node.two+"\n");
		}
		System.out.println(sb);
		

	}
	static class Node implements Comparable<Node>{
		int one,two;

		public Node(int one, int two) {
			super();
			this.one = one;
			this.two = two;
		}

		@Override
		public int compareTo(Node o) {
			return this.two-o.two==0? Integer.compare(this.one,o.one):Integer.compare(this.two,o.two);
		}
		
		
		
	}

}
