import java.io.*;
import java.util.*;

public class DNA {
    static int[] acgt,myacgt;
	static String amho;
	static int answer;
	static Map<String, Integer> code,myCode;
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		amho = sc.next();
		code = new HashMap<String, Integer>();
		myCode = new HashMap<String, Integer>();
		code.put("A", sc.nextInt());
		code.put("C", sc.nextInt());
		code.put("G", sc.nextInt());
		code.put("T", sc.nextInt());
		myCode.put("A", 0);
		myCode.put("C", 0);
		myCode.put("G", 0);
		myCode.put("T", 0);
		answer=0;
		for(int i=0; i<=N-M; i++) {
			//start값과 end값을 전달
			Solution(i, i+M);
			// 한칸 이동
			mycheckremove(amho.substring(i, i+1));
		}
		System.out.println(answer);
	}
	static void Solution(int start, int end) {
		// 처음
		if(start==0) {
			String[] me =  amho.substring(start,end).split("");
			for(String s: me) {
				mycheckadd(s);
			}
		} else {
			mycheckadd(amho.substring(end-1,end));
		}
		// 정답 확인 
		// 왜 틀리지 ?
		myCode.forEach((str,num)->{
			if(code.get(str)>num) {
				answer--;
				return;
			}
		});
		// 맞다
		for(String s : myCode.keySet()) {
			if(code.get(s)>myCode.get(s)) {
				return;
			}
		}
		answer++;			
	
	}
	// 나의 코드에 정답 넣기
	static void mycheckadd(String s) {
		myCode.put(s, myCode.get(s)+1);

	}
	
	// 나의 코드 한칸 움직이기
	static void mycheckremove(String s) {
		myCode.put(s, myCode.get(s)-1);
	}	
}