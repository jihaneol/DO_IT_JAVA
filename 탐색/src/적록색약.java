package 탐색.src;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 적록색약 {
    static boolean visited[][];
    static  char[][] board;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int N = Integer.valueOf(br.readLine());

        board = new char[N][N];

        for(int i=0; i<N; i++){
            char[] rgbs = br.readLine().toCharArray();
            for(int j=0; j<N; j++){
                char rgb = rgbs[j];
                board[i][j] = rgb;
            }
        }

        // 보통사람
        visited = new boolean[N][N];
        int cnt = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(!visited[i][j]){
                    bfs(i,j,true);
                    cnt ++;
                }
            }
        }
        System.out.print(cnt+" ");

        // 적록
        visited = new boolean[N][N];
        cnt = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(!visited[i][j]){
                    bfs(i,j,false);
                    cnt ++;
                }
            }
        }
        System.out.print(cnt);
    }
    public static void bfs(int a, int b,boolean flag){
        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};
        Queue<int[]> q = new LinkedList();
        q.add(new int[] {a,b});
        visited[a][b] = true;
        char find = board[a][b];
        while(!q.isEmpty()){
            int[] now = q.poll();
            for(int i=0; i<4; i++){
                int nx = dx[i] + now[0];
                int ny = dy[i] + now[1];
                if(flag){

                    try{
                        if(!visited[nx][ny]&&find == board[nx][ny]){
                            visited[nx][ny] = true;
                            q.add(new int[]{nx, ny});
                        }
                    }catch(Exception exception){
                        continue;
                    }
                }else{

                    try{
                        if((find=='R' || find=='G') && (board[nx][ny] == 'R' || board[nx][ny] == 'G')){
                            if(!visited[nx][ny]){
                                visited[nx][ny] = true;
                                q.add(new int[]{nx, ny});
                            }
                        }else{
                            if(!visited[nx][ny]&&find == board[nx][ny]){
                                visited[nx][ny] = true;
                                q.add(new int[]{nx, ny});
                            }
                        }
                    }catch(Exception exception){
                        continue;
                    }


                }


            }
        }


    }
}
