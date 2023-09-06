package 문자열;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main_가장가까운_20529 {
    static String[] arr;
    static int answer;
    static boolean visited[];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int test = Integer.valueOf(br.readLine());

        while(test-->0){
            int N = Integer.valueOf(br.readLine());

            arr = br.readLine().split(" ");
            answer = 1000000;
            if(N>32){
                sb.append(0).append('\n');
            }else{
                for(int i=0; i<N-2; i++){
                    for(int j=i+1; j<N-1; j++){
                        for(int x=j+1; x<N; x++){
                            answer = Math.min(answer,dist(arr[i],arr[j])+dist(arr[i],arr[x])+dist(arr[x],arr[j]));
                        }
                    }
                }
            sb.append(answer).append('\n');
            }

        }
        System.out.println(sb);
    }
    static int dist(String a, String b){
        int cnt = 0;
        for(int i=0; i<4; i++){
            if(a.charAt(i) != b.charAt(i)){
                cnt ++;
            }
        }
        return cnt;
    }







}
