package 팀노트.src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.valueOf(br.readLine());

        int temp = num;
        int cnt = 0;

        while(true){
            int a = temp/10; // 10자리
            int b = temp%10; // 1자리
            int c = (a+b)%10; // b 뒤에 있을 수
            temp = b*10 + c;
            cnt++;
            if(temp==num) break;

        }

        System.out.println(cnt);


    }
}