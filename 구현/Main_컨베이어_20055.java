package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
public class Main_컨베이어_20055 {
    static class Robot{
        int position;
        Robot(int position){
            this.position = position;
        }

    }
    static int N,K;
    static int[] belt;

    static boolean[] isThere;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.valueOf(st.nextToken());
        int K = Integer.valueOf(st.nextToken());
        belt = new int[N];
        isThere = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            belt[i] = Integer.valueOf(st.nextToken());
        }
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        belt[0]--;
        int answer = 0;
        while(!q.isEmpty()){
            int size = q.size();
            while(size-->0){
                int now = q.poll();
                answer++;
                if(now ==N-1) continue;
                if(belt[now+1]>=1 && !isThere[now+1]){
                    q.add(now+1);
                    belt[now+1]--;
                }else{
                    isThere[now] = true;
                }
                    answer++;
            }
            if(belt[0]>0){
                answer++;
                q.add(0);
                belt[0]--;
            }
            int cnt = 0;
            for(int i =0; i<N; i++){
                if(belt[i]==0){
                    cnt ++;
                }
            }
            if(cnt>=K) break;
        }
        System.out.println(answer);
    }
}
