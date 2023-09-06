package 팀노트.src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class bfs_depth세기 {
    static int N, M, answer;
    static Map<Integer, Integer> map;

    static int board[];

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new HashMap<>();
        for (int i = 0; i < N + M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map.put(a, b);
        }
        board = new int[101];
        // 주사위 굴리기
        game(1);

        System.out.println(answer);

    }

    public static void game(int nowP) {

        Queue<Integer> q = new LinkedList<>();
        q.add(nowP);
        int cnt = 0;
        while(!q.isEmpty()){
            int size = q.size();

            for(int c=0 ; c<size; c++){

                int now = q.poll();

                if(now>100) continue;
                if(now == 100){
                    answer = cnt;
                    return;
                }
                for(int i=1; i<7; i++){

                    int next = now+i;

                    if(map.containsKey(next)){
                        next = map.get(next);
                    }

                    if(next<=100&&board[next]==0) {
                        board[next] = 1+board[now];
                        q.add(next);
                    }

                }
            }
            cnt++;

        }


    }
}
