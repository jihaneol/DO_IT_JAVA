package 팀노트.src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.valueOf(br.readLine());
        Set<Integer> cards = new HashSet<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++){
            cards.add(Integer.valueOf(st.nextToken()));
        }

        int M = Integer.valueOf(br.readLine());

        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<M; i++){
            if(cards.contains(Integer.valueOf(st.nextToken()))){
                sb.append(1).append(" ");
            }else{
                sb.append(0).append(" ");
            }
        }
        System.out.println(sb.toString());

    }
}