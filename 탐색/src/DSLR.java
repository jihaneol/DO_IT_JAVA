package 탐색.src;

import java.util.*;

public class DSLR {
    static Map<Integer, String> map;
    static String answer;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while (test-- > 0) {
            int A = sc.nextInt();
            int B = sc.nextInt();
            // 중복 확인용
            map = new HashMap();
            bfs(A,B);
            System.out.println(answer);
        }
    }

    public static void bfs(int A, int findValue) {
        Queue<Integer> q = new LinkedList();
        q.add(A);
        map.put(A, "");
        while (!q.isEmpty()) {
            int now = q.poll();
            if(now == findValue){
                answer = map.get(now);
                return;
            }
            String nowCommend = map.get(now);

            int D = now * 2 > 9999 ? (now*2) % 10000 : now * 2;
            int S = now == 0 ? 9999 : now - 1;
            int L = (now % 1000) * 10 + now / 1000;
            int R = (now % 10) * 1000 + now / 10;

            if(!map.containsKey(D)){
                map.put(D,nowCommend+"D");
                q.add(D);
            }
            if(!map.containsKey(S)){
                map.put(S,nowCommend+"S");
                q.add(S);
            }if(!map.containsKey(L)){
                map.put(L,nowCommend+"L");
                q.add(L);
            }
            if(!map.containsKey(R)){
                map.put(R,nowCommend+"R");
                q.add(R);
            }
        }
    }


}
