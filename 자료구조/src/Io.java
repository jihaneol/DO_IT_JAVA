package 자료구조.src;

import java.io.IOException;
import java.util.Scanner;

public class Io {
    static int cntI, cntO;
    static StringBuilder findP;
    static char P[];

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        P = sc.next().toCharArray();
        int memo[] = new int[M];
        int answer = 0;


        for (int i = 1; i < M - 1; i++) {
            if (P[i] == 'O' && P[i + 1] == 'I') {
                memo[i + 1] = memo[i - 1] + 1;
                if (memo[i + 1] == N) {
                    if (P[i + 1 - N * 2] == 'I') {
                        answer++;
                    }
                    memo[i + 1]--;

                }
            }
        }
        System.out.println(answer);


    }


}