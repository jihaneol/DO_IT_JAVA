package 자료구조.src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main_최대힙_11279 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        // 최대힙 priority 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.valueOf(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a,b)->Integer.compare(b,a));
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++){
            int cmd = Integer.valueOf(br.readLine());

            if(cmd==0){
                Integer num =pq.poll();
                if(num == null){
                    sb.append(0).append('\n');
                }else{
                    sb.append(num).append('\n');
                }
            }else{
                pq.add(cmd);
            }
        }
        System.out.println(sb.toString());
    }
}
