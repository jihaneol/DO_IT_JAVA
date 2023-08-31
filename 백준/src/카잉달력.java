package 백준.src;

import java.io.IOException;
import java.util.Scanner;

public class 카잉달력 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while (test-- > 0) {

            int M = sc.nextInt();
            int N = sc.nextInt();
            int x = sc.nextInt();
            int y = sc.nextInt();
            int i = 0, lcm = 0;
            if (M < N) {
                lcm = M * N / gcd(N, M);

            } else {
                lcm = M * N / gcd(M, N);
            }
            boolean flag = true;
            while (M * i + x <= lcm) {

                if ((M * i + x - y) % N == 0) {
                    System.out.println(M * i + x);
                    flag = false;
                    break;
                }
                i++;

            }

            if (flag) {
                System.out.println(-1);
            }

        }
    }

    //최대 공약수
    public static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

}
