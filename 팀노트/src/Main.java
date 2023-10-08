package 팀노트.src;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    // 배열로 구현
//    static class MyStack{
//
//    }

    public static void main(String[] args) throws Exception {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());

        /**
         * 1. 정수 넣기
         * 2. 정수 빼고 출력 없으면 -1
         * 3. 스택 갯수 세기
         * 4. 비었으면 1, 아니면 0
         * 5. 맨위 정수 보여 주기 없다면 -1
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Stack<Integer> stack = new Stack<>();

        int N = Integer.valueOf(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int comm = Integer.valueOf(st.nextToken());

            switch (comm) {
                case 1:
                    stack.push(Integer.valueOf(st.nextToken()));
                    break;
                case 2:
                    if (stack.isEmpty()) {
                        sb.append(-1).append("\n");
                    } else {
                        sb.append(stack.pop()).append("\n");
                    }
                    break;
                case 3:
                    sb.append(stack.size()).append("\n");
                    break;
                case 4:
                    if (stack.isEmpty()) {
                        sb.append(1).append("\n");
                    } else {
                        sb.append(0).append("\n");
                    }
                    break;
                case 5:
                    if (stack.isEmpty()) {
                        sb.append(-1).append("\n");
                    } else {
                        sb.append(stack.peek()).append("\n");
                    }
                    break;
            }

        }
            System.out.println(sb);

    }

}
