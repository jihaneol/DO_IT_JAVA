package 자료구조.src;


import java.io.*;
import java.util.*;

/**
 * 문자열 파싱
 */
public class AC {
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        int test = Integer.valueOf(br.readLine());
        StringTokenizer st;

        while (test-- > 0) {
            byte isUp = 0; // 0 이면 순방향 , 1 이면 역방향
            char commends[] = br.readLine().toCharArray();
            int N = Integer.valueOf(br.readLine());

            Deque<Integer> deque = new ArrayDeque();

            st = new StringTokenizer(br.readLine(), "[],");

            for (int i = 0; i < N; i++) {
                deque.add(Integer.parseInt(st.nextToken()));
            }

            boolean flag = true;
            // 명령 실행
            for (char comm : commends) {
                if (comm == 'R') {
                    isUp ^= 1;
                } else {
                    if (deque.isEmpty()) {
                        sb.append("error\n");
                        flag = false;
                        break;
                    }
                    if (isUp == 1) {
                        deque.pollLast();
                    } else {
                        deque.poll();
                    }

                }
            }

            if (flag) {
                sb.append('[');
                if (!deque.isEmpty()) {
                    if (isUp == 0) {

                        sb.append(deque.poll());
                        while (!deque.isEmpty()) {
                            sb.append(',').append(deque.poll());

                        }
                    } else {
                        sb.append(deque.pollLast());
                        while (!deque.isEmpty()) {
                            sb.append(',').append(deque.pollLast());
                        }
                    }
                }

                sb.append(']').append("\n");

            }

        }
        System.out.println(sb.toString());

    }

}
