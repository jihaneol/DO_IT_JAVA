package 팀노트.src;
public class 비트마스킹 {

	public static void main(String[] args) {
		 int x = 10; // 2진수로 변환시 1010
		    int y = 12; // 2진수로 변환시 1100

		    System.out.println("x = \t" + Integer.toBinaryString(x));
		    System.out.println("x<<1 = \t" + Integer.toBinaryString(x<<1)+", "+(x<<1));
		    System.out.println("y = \t" + Integer.toBinaryString(y));
		    System.out.println("x|y = \t" + Integer.toBinaryString(x|y));
		    System.out.println("x&y = \t" + Integer.toBinaryString(x&y));
		    System.out.println("x^y = \t" + Integer.toBinaryString(x^y));
		    System.out.println("~x = \t" + Integer.toBinaryString(~x)+", "+~x);  // int는 4byte = 32bit이기때문에 앞에 28개의 1이 출력됨

		    int a = -127;           // 1111 1111 1111 1111 1111 1111 1000 0001
		    int shift_a = a>>1;     // 1111 1111 1111 1111 1111 1111 1100 0000
		    int ns_shift_a = a>>>1; // 0111 1111 1111 1111 1111 1111 1100 0000
		    System.out.println("a =\t" +a+","+ Integer.toBinaryString(a));
		    System.out.println("a>>1 =\t" +(a>>1)+","+ Integer.toBinaryString(a>>1));
		    System.out.println("a>>>1 =\t" +(a>>>1)+","+ Integer.toBinaryString(a>>>1));

	}

}
