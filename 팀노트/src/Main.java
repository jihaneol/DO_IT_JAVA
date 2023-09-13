package 팀노트.src;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int N = sc.nextInt()/4;
        for(int i=0; i<N; i++){
            sb.append("long ");
        }
        sb.append("int");
        System.out.println(sb);

    }

}
//
//        System.out.println(Integer.compare(1,2)); // 오름 -1
//        System.out.println(Integer.compare(1,1)); // 0
//        System.out.println(Integer.compare(2,1)); // 내림 1
//
//        System.out.println(("02151".charAt(1)-'0')+5);
//        List<Integer> list  = new ArrayList<>();
//        list.size();20
//
//        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
