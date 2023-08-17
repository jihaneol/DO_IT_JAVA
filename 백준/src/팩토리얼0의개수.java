package 백준.src;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class 팩토리얼0의개수 {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ans=0,num=1;
        for(int i=1;i<n+1; i++){
            while(num/10*10==num){
                ans++;
                num/=10;
            }
        }
        System.out.println(ans);
    }

}