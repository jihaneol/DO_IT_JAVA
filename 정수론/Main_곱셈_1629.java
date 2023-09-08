package 정수론;

import java.util.Scanner;

public class Main_곱셈_1629 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        long a = sc.nextInt();
        long b = sc.nextInt();
        long c = sc.nextInt();
        //21억 미만 자연수 ,.. a**b %c
        // 거듭 제곱
        System.out.println(division(a,b,c));
    }
    public static long division(long X, long Y, long M){
        if(Y==1){
            return X%M;
        }
        long answer = 0;
        if(Y%2==0){
            answer = division(X,Y/2, M)%M;
            return answer*answer%M;
        }else{
            answer = division(X,Y-1, M);
            return (answer * X %M)%M;
        }

    }


}
