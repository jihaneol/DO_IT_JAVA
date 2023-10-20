package 그래프.src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_불_5427 {
    static int dx[] = {0,0,1,-1};
    static int dy[] = {1,-1,0,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int N = Integer.valueOf(br.readLine());
        while (N-- > 0) {
            int time = 0;
            Queue<int[]> position = new ArrayDeque<>();
            Queue<int[]> fire = new ArrayDeque<>();
            st = new StringTokenizer(br.readLine());
            int y = Integer.valueOf(st.nextToken());
            int x = Integer.valueOf(st.nextToken());

            char map[][] = new char[x][y];
            boolean visited[][] = new boolean[x][y];
            for (int i = 0; i < x; i++) {
                char[] s = br.readLine().toCharArray();
                for (int j = 0; j < y; j++) {
                    map[i][j] = s[j];
                    if (map[i][j] == '@') {
                        map[i][j] = '.';
                        visited[i][j] = true;
                        position.add(new int[] {i,j});
                    }
                    if(map[i][j] == '*'){
                        fire.add(new int[] {i,j});
                    }
                }
            }
            boolean flag = true;
            while(flag){
                int size = position.size();
                tofire(map,fire);
                nage : while(size-->0){
                    int[] poll = position.poll();
                    for(int i=0; i<4; i++){
                        int nx = dx[i] + poll[0];
                        int ny = dy[i] + poll[1];
                        try{
                            if(!visited[nx][ny]&&map[nx][ny]=='.'){
                                visited[nx][ny] = true;
                                position.add(new int[] {nx,ny});
                            }

                        }catch (Exception e){
                            flag= false;
                            System.out.println(++time);
                            break nage;
                        }
                    }
                }
                time++;
                if(position.size()==0&& flag == true){
                    flag = false;
                    System.out.println("IMPOSSIBLE");
                }
            }
        }

    }
    public static void tofire(char map[][],Queue<int[]> fire){
        int size = fire.size();
        while(size-->0){
            int[] poll = fire.poll();
            for(int i=0; i<4; i++){
                int nx = dx[i] + poll[0];
                int ny = dy[i] + poll[1];
                try{
                    if(map[nx][ny]=='.'){
                        map[nx][ny]='*';
                        fire.add(new int[] {nx,ny});
                    }

                }catch (Exception e){
                    continue;
                }
            }
        }
    }

}
