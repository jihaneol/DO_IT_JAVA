package 구현;

import java.io.IOException;
import java.util.Scanner;

public class Main_2563_색종이 {
    public static void main(String[] args) throws NumberFormatException, IOException {

        int map[][] = new int[101][101];
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for(int i=0; i<N; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();

            for(int x=a; x<a+10; x++){
                for(int y=b; y<b+10; y++){
                    map[x][y]+=1;
                }
            }

        }
        int answer =0;

        for(int i=1; i<101; i++){
            for(int j=1; j<101; j++){
                if(map[i][j]>0){
                    answer++;
                }
            }
        }
        System.out.println(answer);


    }
}
