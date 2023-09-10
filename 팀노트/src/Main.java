package 팀노트.src;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) {


        System.out.println(Integer.compare(1,2)); // 오름 -1
        System.out.println(Integer.compare(1,1)); // 0
        System.out.println(Integer.compare(2,1)); // 내림 1

        System.out.println(("02151".charAt(1)-'0')+5);
        List<Integer> list  = new ArrayList<>();
        list.size();

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

    }

}
