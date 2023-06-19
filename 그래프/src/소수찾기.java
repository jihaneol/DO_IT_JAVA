import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 소수찾기{
	static int answer;
	static int N;
	static int si(String s) {return Integer.valueOf(s);}
	static BufferedReader br;
	static StringTokenizer st;
	static StringBuilder sb;
	
	public static void main(String[] args) throws Exception{
		br = new BufferedReader(new InputStreamReader(System.in));
		N = si(br.readLine());	
		sb = new StringBuilder();
		// 숫자 , 자릿수
		made(0, 1);
		System.out.println(sb);
		
	}
	static void made(int num,int depth) {
		if(num==1) return;
		if(depth==N+1) {
			sb.append(num+"\n");
			return;
		}
		for(int i=1;i<10;i++) {
            if(i==4 || i==8 || i==6) continue;
			if(isPrime(num*10+i)) {
				made(num*10+i, depth+1);
			}
		}
	}
	static boolean isPrime(int num) {
		for(int i=2; i<=Math.sqrt(num); i++) {
			if ((num%i)==0) { 
				return false;
			}
		}
		return true;
	}
}