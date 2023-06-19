
public class 소수판별 {
	// 시간 복잡도 루트N   아리스토가 빠르다 NloglogN
	static boolean isPrime(int num) {
		for(int i=2; i<=Math.sqrt(num); i++) {
			if ((num%i)==0) { 
				return false;
			}
		}
		return true;
	}

}
