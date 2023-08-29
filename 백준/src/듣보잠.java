package 백준.src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class 듣보잠 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        int N = Integer.valueOf(s[0]);
        int M = Integer.valueOf(s[1]);

        Map<String, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        // 듣도 명단
        for (int i = 0; i < N; i++) {
            map.put(br.readLine(), 1);
        }
        List<String> answer = new ArrayList<>();
        int cnt = 0;
        // 보도 명단
        for (int i = 0; i < M; i++) {
            String list = br.readLine();
            if (map.putIfAbsent(list, 1) != null) {
                cnt++;
                answer.add(list);
            }
        }
        // 사전순 정렬 ....
        System.out.println(cnt);
        Collections.sort(answer);
        for(int i=0; i<cnt; i++){
            sb.append(answer.get(i)).append("\n");
        }
        System.out.println(sb.toString());
    }
}
