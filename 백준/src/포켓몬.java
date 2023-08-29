package 백준.src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class 포켓몬 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        int N = Integer.valueOf(s[0]);
        int M = Integer.valueOf(s[1]);

        Map<String, Integer> mapString = new HashMap<>();
        Map<Integer, String> mapNumber = new HashMap<>();

        StringBuilder answer = new StringBuilder();
        // 도감 넣기
        for (int i = 0; i < N; i++) {
            String temp = br.readLine();
            mapString.put(temp, i + 1);
            mapNumber.put(i + 1, temp);
        }
        // 답 맞추기
        Pattern pattern = Pattern.compile("^[0-9]*$");

        for (int i = 0; i < M; i++) {
            String list = br.readLine();
            // 숫자면.
            if (pattern.matcher(list).find()) {
                answer.append(mapNumber.get( Integer.valueOf(list))).append("\n");
            } else {
                answer.append(mapString.get(list)).append("\n");
            }
        }
        // 제출
        System.out.println(answer.toString());
    }
}
