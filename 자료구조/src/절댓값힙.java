package 자료구조.src;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class 절댓값힙 {
	static BufferedReader br;
	static StringTokenizer st;
	static int si(String s) {return Integer.valueOf(s);}

	
	public static void main(String[] args) throws IOException{
		StringBuilder sb = new StringBuilder();
		PriorityQueue<Integer> pq = new PriorityQueue<>((o1,o2)->{
			int x1 = Math.abs(o1);
			int x2 = Math.abs(o2);
			return x1!=x2?x1-x2:o1-o2;
		});
		int num=0;
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		int N = si(st.nextToken());
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			num=si(st.nextToken());;
			if(num!=0) {
				pq.add(num);
			}else {
				if(pq.isEmpty()) {
					System.out.println(0);
				}else {
					System.out.println(pq.poll());
				}
			}
		}
	}

}
