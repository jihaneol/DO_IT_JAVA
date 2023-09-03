package 조합.src;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 패션왕 {
    static Map<String, Integer> map;
    static int answer;
    static boolean visited[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int test = Integer.valueOf(br.readLine());

        while (test-- > 0) {
            map = new HashMap<>();
            int N = Integer.valueOf(br.readLine());
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                String name = st.nextToken();
                String type = st.nextToken();

                map.put(type,map.getOrDefault(type,0)+1);

            }
            answer = 1;

            for(int num : map.values()){
                answer*=(num+1);
            }

            System.out.println(answer-1);

        }


    }
//    public static void comb(List<String> list, int depth, int N,int total){
//        if(depth == N){
//            answer+=total;
//            return;
//        }
//        for(int i=depth; i<list.size(); i++){
//            if(!visited[i]){
//                visited[i] = true;
//                comb(list,depth+1,N,total*map.get(list.get(i)));
//                visited[i] = false;
//            }
//            if(i>list.size()-N && depth==0){
//                return;
//            }
//        }
//    }
}
