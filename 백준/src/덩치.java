package 백준.src;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 덩치 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
	     
		int N = Integer.valueOf(st.nextToken());
		
		Person[] person = new Person[N];
		for(int i=0; i<N; i++ ) {
			st = new StringTokenizer(br.readLine());
			person[i] = new Person(Integer.valueOf(st.nextToken()), Integer.valueOf(st.nextToken()));
		}
		
		for(int i=0; i<N; i++) {
			int cnt =1;
			for(int j=0; j<N; j++) {
				if(person[i].compareTo(person[j])==1) {
					cnt++;
				}
			}
			sb.append(cnt).append(" ");
		}
		
		System.out.println(sb);
	}
	public static class Person{
		int tall,weight;

		public Person(int tall, int weight) {
			super();
			this.tall = tall;
			this.weight = weight;
		}

		public int compareTo(Person o) {
			return this.tall<o.tall && this.weight<o.weight ? 1:-1;
		}

		
		
	}

}
