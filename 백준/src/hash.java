import java.util.Scanner;

public class hash {
	static final int mod = 1234567891;
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		long sum = 0;
//		int N = sc.nextInt();
//		char[] arr = sc.next().toCharArray();
//		
//		for(int i=0; i<N; i++) {
//			int num= arr[i]-96;
//			sum += square(31, i)*num;
//			sum%=mod;
//		}
//		System.out.println(sum);
//	}
//	//거듭 제곱
//	public static long square(int num,int depth) {
//		if(depth==0) return 1;
//		if(depth==1) {
//			return num;
//		}else if(depth%2==0) {
//			long ans = square(num,depth/2)%mod;
//			return (ans*ans)%mod;			
//		}else {
//			long ans = square(num,depth-1)%mod;
//			return (ans*num)%mod;
//		}
//	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long sum = 0;
		int N = sc.nextInt();
		char[] arr = sc.next().toCharArray();
		long pow = 1;
		for(int i=0; i<N; i++) {
			int num= arr[i]-96;
			sum += num*pow;
			pow = (pow*31)%mod;
			
		}
		System.out.println(sum%mod);
	}
	

}
