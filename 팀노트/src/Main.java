package 팀노트.src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());// 학생 수
        StringTokenizer st = new StringTokenizer(in.readLine());
        int now = 1;
        boolean flag = false;

        Queue<Integer> q = new ArrayDeque<>();
        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<N; i++){
            q.add(Integer.valueOf(st.nextToken()));
        }

        while(!q.isEmpty()){
            if(q.peek()==now){
                q.poll();
                now++;

            }else if(!stack.isEmpty() && stack.peek() == now){
                stack.pop();
                now++;
            }else{
                stack.push(q.poll());
            }
        }
        while(!stack.isEmpty()){
            int studunt = stack.pop();
            if(studunt!=now){
                flag = true;
                break;
            }else{
                now ++;
            }
        }
        if(flag){
            System.out.println("Sad");
        }else{
            System.out.println("Nice");
        }


    }

}