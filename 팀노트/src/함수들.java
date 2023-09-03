package 팀노트.src;

import java.util.HashMap;
import java.util.Map;

public class 함수들 {
    public static void main(String[] args) throws Exception{
        Map<Integer,Integer> map = new HashMap();

        map.put(20, 15);
        System.out.println(" computeifabsent 15 나와야한다. "+map.computeIfAbsent(20,c -> c+ 10));
        System.out.println(" 10 나와야 "+map.computeIfAbsent(15,c-> 10));
        System.out.println(" 10 나와야 " + map.get(15));
        System.out.println("10 나와야 " +map.getOrDefault(10,10));
    }
}
